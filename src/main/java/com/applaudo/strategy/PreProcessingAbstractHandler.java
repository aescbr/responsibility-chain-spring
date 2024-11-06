package com.applaudo.strategy;

import com.applaudo.model.POEmailRequest;
import com.applaudo.model.Result;
import com.applaudo.model.StepResult;
import com.applaudo.model.WrapperTransaction;

import java.util.List;
import java.util.Optional;

public abstract class PreProcessingAbstractHandler implements PreProcessingHandler {

    private Optional<PreProcessingHandler> next = Optional.empty();

    @Override
    public Optional<PreProcessingHandler> setNext(PreProcessingHandler handler) {
        this.next = Optional.of(handler);
        return this.next;
    }

    @Override
    public WrapperTransaction handle(WrapperTransaction txt) {
        if (this.next.isPresent()){
            PreProcessingHandler nextStep = next.get();
            return nextStep.handle(txt);
        }else
            return txt;
    }
}
