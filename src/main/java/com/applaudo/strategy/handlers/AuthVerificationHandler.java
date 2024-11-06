package com.applaudo.strategy.handlers;

import com.applaudo.exception.BuyerNotAllowedException;
import com.applaudo.exception.CustomerProfileNotFound;
import com.applaudo.model.*;
import com.applaudo.repository.CustomerProfileRepository;
import com.applaudo.strategy.PreProcessingAbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthVerificationHandler extends PreProcessingAbstractHandler {


    @Autowired
    CustomerProfileRepository customerProfileRepository;

    @Override
    public WrapperTransaction handle(WrapperTransaction txt) {
        System.out.println("---AUTH VERIFICATION---");
        /*
         Add auth-verification logic here
         */

        //find customer profile by POMailbox
        Optional<CustomerProfile> optProfile =
                customerProfileRepository.getCustomerProfileByPOMailbox(txt.getRequest().getPoMailbox());

        // verify if buyer is listed in customer's allowed users
        if(optProfile.isPresent()){
            CustomerProfile profile = optProfile.get();
            if(profile.getBuyerList().contains(txt.getRequest().getBuyerEmail())){
                //customer allowed to send PO Request
                txt.getResults().add(new StepResult("auth verification", true));
                return super.handle(txt);

            } else {
                //throw exception
                //notify user not allowed to send PO Requests
                throw new BuyerNotAllowedException("buyer: "+txt.getRequest().getBuyerEmail()+" is not allowed to send PO email requests");
            }
        }else {
            throw new CustomerProfileNotFound("buyer: "+txt.getRequest().getPoMailbox()+" Not found in db"); //
        }

    }


}
