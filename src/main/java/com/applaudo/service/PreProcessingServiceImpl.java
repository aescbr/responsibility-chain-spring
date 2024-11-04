package com.applaudo.service;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.StepResult;
import com.applaudo.model.WrapperTransaction;
import com.applaudo.strategy.handlers.SourceRequestHandler;
import com.applaudo.strategy.handlers.AuthVerificationHandler;
import com.applaudo.strategy.handlers.FileExtensionValidationHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreProcessingServiceImpl implements PreProcessingService {

    private final FileExtensionValidationHandler fileExtensionValidationHandler;
    private final SourceRequestHandler sourceRequestHandler;
    private final AuthVerificationHandler authVerificationHandler;

    public PreProcessingServiceImpl(FileExtensionValidationHandler fileExtensionValidationHandler,
                                    SourceRequestHandler sourceRequestHandler, AuthVerificationHandler authVerificationHandler) {
        this.fileExtensionValidationHandler = fileExtensionValidationHandler;
        this.sourceRequestHandler = sourceRequestHandler;
        this.authVerificationHandler = authVerificationHandler;
    }

    @Override
    public WrapperTransaction processRequest(WrapperTransaction txt) {

        authVerificationHandler.setNext(sourceRequestHandler);

        WrapperTransaction result = authVerificationHandler.handle(txt);
        System.out.println(result);
        //send

        return result;
    }
}
