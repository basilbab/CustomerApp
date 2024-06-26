package com.customermanagementapplication.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import com.customermanagementapplication.model.Customer;
@Component
public class CustomerService {
    private List<Customer> customerList=new CopyOnWriteArrayList<>();
    private int customerIdCount=1;
    public Customer addCustomer(Customer customer){
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;
    }
    public List<Customer> getCustomers()
    {
        return customerList;
    }

    public Customer getCustomer(int customerId)
    {
       return customerList.stream().filter(c-> c.getCustomerId()==customerId).findFirst().get();
    }

    public Customer updateCustomer(int customerId, Customer customer)
    {
            customerList.stream()
           .forEach(c->{
            if(c.getCustomerId()==customerId)
            {
                c.setCustomerFirstName(customer.customerFirstName);
                c.setCustomerEmail(customer.customerLastName);
                c.setCustomerEmail(customer.customerEmail);

            }
           });

           return customerList.stream().filter(c-> c.getCustomerId()==customerId).findFirst().get();
    }

    public void deleteCustomer(int customerId){
        customerList.forEach(c->{
            if(c.getCustomerId()==customerId)
            {
                customerList.remove(c);
            }
        });
    }


}
