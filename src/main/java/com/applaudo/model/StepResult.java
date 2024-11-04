package com.applaudo.model;

public class StepResult {
    private String name;
    private Boolean isSuccess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public StepResult(String name, Boolean isSuccess) {
        this.name = name;
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "StepResult{" +
                "name='" + name + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
