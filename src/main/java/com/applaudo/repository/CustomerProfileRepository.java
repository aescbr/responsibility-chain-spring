package com.applaudo.repository;

import com.applaudo.model.CustomerProfile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerProfileRepository {


    public List<CustomerProfile> getAllProfiles() {
        return List.of();
    }

    public CustomerProfile getCustomerById(Integer id) {
        return new CustomerProfile();
    }

    public Optional<CustomerProfile> getCustomerProfileByPOMailbox(String mail){
        return Optional.of(new CustomerProfile());
    }

}
