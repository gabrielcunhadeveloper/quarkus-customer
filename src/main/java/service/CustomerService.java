package service;

import domain.Customer;

import java.util.List;


public class CustomerService {


    public List<Customer> findAll(){
        return Customer.listAll();
    }

}
