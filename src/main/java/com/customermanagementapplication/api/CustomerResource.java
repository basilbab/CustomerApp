package com.customermanagementapplication.api;

import org.springframework.web.bind.annotation.RestController;

import com.customermanagementapplication.model.Customer;
import com.customermanagementapplication.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(value="/customers")

public class CustomerResource {
    @Autowired
    private CustomerService customerService;
    public Customer addCustomer(@RequestBody Customer customer)
    {
        
        return customerService.addCustomer(customer);
    }

}
