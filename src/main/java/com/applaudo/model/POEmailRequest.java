package com.applaudo.model;

import java.util.List;

public class POEmailRequest {


    private String id;
    private String buyerEmail;

    private String poMailbox;
    private Source source;
    private List<String> files;
    private List<String> steps;

    public POEmailRequest(String id, String buyerEmail, String poMailbox, Source source, List<String> files) {
        this.id = id;
        this.buyerEmail = buyerEmail;
        this.poMailbox = poMailbox;
        this.source = source;
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public String getPoMailbox() {
        return poMailbox;
    }

    public void setPoMailbox(String poMailbox) {
        this.poMailbox = poMailbox;
    }

    @Override
    public String toString() {
        return "POEmailRequest{" +
                "id='" + id + '\'' +
                ", buyerEmail='" + buyerEmail + '\'' +
                ", poMailbox='" + poMailbox + '\'' +
                ", source=" + source +
                ", files=" + files +
                ", steps=" + steps +
                '}';
    }
}
