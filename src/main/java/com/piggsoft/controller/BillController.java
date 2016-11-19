package com.piggsoft.controller;

import com.piggsoft.dao.BillRepository;
import com.piggsoft.model.Bill;
import com.piggsoft.request.BillSearchRequest;
import com.piggsoft.response.Response;
import com.piggsoft.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by piggs on 2016/10/23.
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BillService billService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(Bill bill) {
        billRepository.save(bill);
        return Response.createSuccess();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findOne(id);
        return Response.createSuccess(bill);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object search(Pageable pageable, BillSearchRequest request) {
        return billService.search(pageable, request);
    }

}
