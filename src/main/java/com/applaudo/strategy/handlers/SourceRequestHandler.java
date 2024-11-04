package com.applaudo.strategy.handlers;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.StepResult;
import com.applaudo.model.WrapperTransaction;
import com.applaudo.strategy.PreProcessingAbstractHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SourceRequestHandler extends PreProcessingAbstractHandler {
    @Override
    public WrapperTransaction handle(WrapperTransaction txt) {
        System.out.println("SourceRequest");
        /*
         Add pre-processing logic here
         */
        txt.getResults().add(new StepResult("Source Request", true));
        return super.handle(txt);
    }
}
