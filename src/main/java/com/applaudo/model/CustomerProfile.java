package com.applaudo.model;

import java.util.List;

public class CustomerProfile {

    private String poMailbox;
    private String poDashboardLink;
    private String mrMailbox;
    private String mrDashboardLink;
    private List<String> buyerList;

    private Customer customer;


    public String getPoMailbox() {
        return poMailbox;
    }

    public void setPoMailbox(String poMailbox) {
        this.poMailbox = poMailbox;
    }

    public String getPoDashboardLink() {
        return poDashboardLink;
    }

    public void setPoDashboardLink(String poDashboardLink) {
        this.poDashboardLink = poDashboardLink;
    }

    public String getMrMailbox() {
        return mrMailbox;
    }

    public void setMrMailbox(String mrMailbox) {
        this.mrMailbox = mrMailbox;
    }

    public String getMrDashboardLink() {
        return mrDashboardLink;
    }

    public void setMrDashboardLink(String mrDashboardLink) {
        this.mrDashboardLink = mrDashboardLink;
    }

    public List<String> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<String> buyerList) {
        this.buyerList = buyerList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerProfile(String poMailbox, String poDashboardLink, String mrMailbox, String mrDashboardLink, Customer customer) {
        this.poMailbox = poMailbox;
        this.poDashboardLink = poDashboardLink;
        this.mrMailbox = mrMailbox;
        this.mrDashboardLink = mrDashboardLink;
        this.customer = customer;
    }

    public CustomerProfile() {
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "poMailbox='" + poMailbox + '\'' +
                ", poDashboardLink='" + poDashboardLink + '\'' +
                ", mrMailbox='" + mrMailbox + '\'' +
                ", mrDashboardLink='" + mrDashboardLink + '\'' +
                ", customer=" + customer +
                ", buyerList=" + buyerList +
                '}';
    }
}
