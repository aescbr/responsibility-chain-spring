package com.applaudo.strategy.handlers;

import com.applaudo.exception.BuyerNotAllowedException;
import com.applaudo.model.*;
import com.applaudo.repository.CustomerProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AuthVerificationHandlerTest {

    @Mock
    private CustomerProfileRepository customerProfileRepositoryMock;

    @InjectMocks
    private AuthVerificationHandler handler;

    @Test
    void given_buyerIsAllowed_thenReturn_stepResultSuccess(){
        //Arrange
        Customer customer = new Customer(1, "Customer1", "123456");

        CustomerProfile customerProfile =
                new CustomerProfile(
                        "customerPO@mailbox.com",
                        "http://customer1-poDashboard",
                        "customerMR@mailbox.com",
                        "http://customer1-mrDashboard",
                        customer);
        customerProfile.setBuyerList(List.of("buyer@mail.com"));

        POEmailRequest request = new POEmailRequest(UUID.randomUUID().toString(),
                "buyer@mail.com",
                "customer.po@mailbox.com",
                Source.EMAIL_BODY,
                List.of());
        request.setSteps(new ArrayList<>());

        WrapperTransaction txt =  new WrapperTransaction(request);

        // dependcies, services mock
        given(customerProfileRepositoryMock.getCustomerProfileByPOMailbox(any()))
                .willReturn(Optional.of(customerProfile));


        //Act
        WrapperTransaction result = handler.handle(txt);

        //Assert
        System.out.println(result);
        assertThat(result.getResults().size()).isGreaterThan(0);
        assertThat(result.getResults().get(0).getSuccess()).isTrue();
    }

    @Test
    void given_buyerIsNotAllowed_thenReturn_stepResultSuccessFalse(){
        //Arrange
        Customer customer = new Customer(1, "Customer1", "123456");

        CustomerProfile customerProfile =
                new CustomerProfile(
                        "customerPO@mailbox.com",
                        "http://customer1-poDashboard",
                        "customerMR@mailbox.com",
                        "http://customer1-mrDashboard",
                        customer);
        customerProfile.setBuyerList(List.of("buyer@mail.com"));


        POEmailRequest request = new POEmailRequest(UUID.randomUUID().toString(),
                "buyer.notallowed@mail.com",
                "customer.po@mailbox.com",
                Source.EMAIL_BODY,
                List.of());
        request.setSteps(new ArrayList<>());

        WrapperTransaction txt =  new WrapperTransaction(request);

        given(customerProfileRepositoryMock.getCustomerProfileByPOMailbox(any()))
                .willReturn(Optional.of(customerProfile));


        //Act
        BuyerNotAllowedException exception = assertThrows(BuyerNotAllowedException.class,
                () -> handler.handle(txt));


        //Assert
        assertThat(exception.getMessage()).contains("is not allowed");
    }
}
