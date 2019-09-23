package com.bankmanager.repository;

import com.bankmanager.customer.Customer;
import com.bankmanager.customer.CustomerImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomersRepository {

    private static final Map<String, Customer> customers = new HashMap<String, Customer>();

    @PostConstruct
    public void initData(){

        Customer customer1 = new CustomerImpl("Jordi", "112233M");
        customers.put(customer1.getCustomerId(), customer1);

        Customer customer2 = new CustomerImpl("Maria", "9988773Y");
        customers.put(customer2.getCustomerId(), customer2);


        Customer customer3 = new CustomerImpl("Laura", "12345677Z");
        customers.put(customer3.getCustomerId(), customer3);

    }

    public Customer findCustomer(String customerId) {
        return customers.get(customerId);
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

}
