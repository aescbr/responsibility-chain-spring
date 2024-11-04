package com.applaudo.strategy.handlers;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.StepResult;
import com.applaudo.model.WrapperTransaction;
import com.applaudo.strategy.PreProcessingAbstractHandler;
import org.springframework.stereotype.Component;

@Component
public class FileExtensionValidationHandler extends PreProcessingAbstractHandler {

    @Override
    public WrapperTransaction handle(WrapperTransaction txt) {
        System.out.println("file extension validation");
        /*
         Add pre-processing logic here
         */
        txt.getResults().add(new StepResult("file extension validation", true));
        return super.handle(txt);
    }
}
