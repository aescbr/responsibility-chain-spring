package com.applaudo.service;

import com.applaudo.exception.BuyerNotAllowedException;
import com.applaudo.model.*;
import com.applaudo.strategy.handlers.AuthVerificationHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
public class PreProcessingServiceTest {

    @Mock
    private AuthVerificationHandler authVerificationHandlerMock;

    @InjectMocks
    private PreProcessingServiceImpl service;


    @Test
    void given_buyerIsAuthorized_ThenReturn_stepSuccess() {

        //Arrange
        POEmailRequest request =
                new POEmailRequest("12345",
                        "buyer1@mail.com",
                        "customer.po@mailbox.com",
                        Source.EMAIL_BODY,
                        List.of("path1", "path2"));

        WrapperTransaction txt =  new WrapperTransaction(request);

        List<StepResult> results = new ArrayList<>();
        results.add(new StepResult("authorization-validation", true));
        results.add(new StepResult("source handler", true));

        WrapperTransaction txtSteps = txt;

        txtSteps.setResults(results);

        given(authVerificationHandlerMock.handle(any()))
                .willReturn(txtSteps);

        //Act
        WrapperTransaction processResult = service.processRequest(txt);

        //Assert
        assertThat(processResult.getResults().size()).isEqualTo(2);
    }

    @Test
    void given_buyerIsNotAuthorized_ThenThrow_aBuyerNotAllowedException() {
        //Arrange
        POEmailRequest request =
                new POEmailRequest("12345",
                        "buyer1@mail.com",
                        "customer.notAllowed.po@mailbox.com",
                        Source.EMAIL_BODY,
                        List.of("path1", "path2"));

        WrapperTransaction txt =  new WrapperTransaction(request);

        String exceptionMessage = "buyer not allowed";


        given(authVerificationHandlerMock.handle(any()))
                .willThrow(new BuyerNotAllowedException(exceptionMessage));

        //Act
        BuyerNotAllowedException exception = assertThrows(BuyerNotAllowedException.class,
                () -> service.processRequest(txt));

        //Assert
        assertEquals(exception.getMessage(), exceptionMessage);
    }

}
