package com.piggsoft.service;

import com.piggsoft.dao.BillRepository;
import com.piggsoft.model.Bill;
import com.piggsoft.request.BillSearchRequest;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by piggs on 2016/11/15.
 */
@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    public Object search(Pageable pageable, BillSearchRequest request) {
        Date date = request.getDate() == null ? new Date() : request.getDate();
        int type = request.getType() == 0 ? 1 : request.getType();
        Date start, end;
        switch (type) {
            case 1:
                start = new DateTime(date).withTimeAtStartOfDay().toDate();
                end = new DateTime(date).millisOfDay().withMaximumValue().toDate();
                break;
            case 2:
                start = new DateTime(date).dayOfWeek().withMinimumValue().withTimeAtStartOfDay().toDate();
                end = new DateTime(date).dayOfWeek().withMaximumValue().millisOfDay().withMaximumValue().toDate();
                break;
            case 3:
                start = new DateTime(date).dayOfMonth().withMinimumValue().withTimeAtStartOfDay().toDate();
                end = new DateTime(date).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toDate();
                break;
            case 4:
                start = quarterStartFor(new DateTime(date)).withTimeAtStartOfDay().toDate();
                end = quarterEndFor(new DateTime(date)).millisOfDay().withMaximumValue().toDate();
                break;
            case 5:
                start = new DateTime(date).dayOfYear().withMinimumValue().withTimeAtStartOfDay().toDate();
                end = new DateTime(date).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toDate();
                break;
            default:
                return null;
        }
        return search(pageable, start, end);
    }

    public DateTime quarterStartFor(DateTime date) {
        return date.withDayOfMonth(1).withMonthOfYear((((date.getMonthOfYear() - 1) / 3) * 3) + 1);
    }

    public DateTime quarterEndFor(DateTime date) {
        return quarterStartFor(date).plusMonths(3).minusDays(1);
    }

    private Object search(Pageable pageable, Date start, Date end) {
        Pageable pageableClone = pageable;
        Sort sort = pageable.getSort();
        if (sort == null) {
            Sort.Order order = new Sort.Order(Sort.Direction.ASC, "billDate");
            sort = new Sort(order);
            PageRequest request = new PageRequest(pageable.getOffset(), pageable.getPageSize(), sort);
            pageableClone = request;
        }
        return pageable == null ?
                repository.findByBillDateBetween(start, end)
                : repository.findByBillDateBetween(start, end, pageableClone);
    }

}
