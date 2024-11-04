package com.applaudo.model;

import java.util.List;

public class Result {
    private List<String> steps;

    public Result(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Result{" +
                "steps=" + steps +
                '}';
    }
}
