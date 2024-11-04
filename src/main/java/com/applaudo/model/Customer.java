package com.applaudo.model;

public class Customer {

    private Integer id;
    private String name;
    private String cicCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCicCode() {
        return cicCode;
    }

    public void setCicCode(String cicCode) {
        this.cicCode = cicCode;
    }

    public Customer(Integer id, String name, String cicCode) {
        this.id = id;
        this.name = name;
        this.cicCode = cicCode;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cicCode='" + cicCode + '\'' +
                '}';
    }

}
