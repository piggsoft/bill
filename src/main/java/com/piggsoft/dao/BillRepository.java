package com.piggsoft.dao;

import com.piggsoft.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by piggs on 2016/11/13.
 */
public interface BillRepository extends PagingAndSortingRepository<Bill, Long> {
    Page<Bill> findByBillDateBetween(Date start, Date end, Pageable pageable);

    List<Bill> findByBillDateBetween(Date start, Date end);
}
