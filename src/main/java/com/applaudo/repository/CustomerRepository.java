package com.applaudo.repository;

import com.applaudo.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    Customer findByPOMailbox(){
        return new Customer();
    }
}
