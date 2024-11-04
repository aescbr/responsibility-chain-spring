package com.applaudo.strategy;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.StepResult;
import com.applaudo.model.WrapperTransaction;

import java.util.List;
import java.util.Optional;

public interface PreProcessingHandler {

    Optional<PreProcessingHandler> setNext(PreProcessingHandler handler);
    WrapperTransaction handle(WrapperTransaction txt);
}
