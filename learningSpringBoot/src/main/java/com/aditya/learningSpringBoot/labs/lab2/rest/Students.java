package com.aditya.learningSpringBoot.labs.lab2.rest;

// this is an entity class 

public class Students {
    
    private String firstName;
    private String lastName;

    Students(String firstName,String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLasttName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

}
