package com.applaudo.model;

import java.util.ArrayList;
import java.util.List;

public class WrapperTransaction {
    private POEmailRequest request;
    private List<StepResult> results;

    public POEmailRequest getRequest() {
        return request;
    }

    public void setRequest(POEmailRequest request) {
        this.request = request;
    }

    public List<StepResult> getResults() {
        return results;
    }

    public void setResults(List<StepResult> results) {
        this.results = results;
    }

    public WrapperTransaction(POEmailRequest request) {
        this.request = request;
        this.results = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "WrapperTransaction{" +
                "request=" + request +
                ", results=" + results +
                '}';
    }
}
