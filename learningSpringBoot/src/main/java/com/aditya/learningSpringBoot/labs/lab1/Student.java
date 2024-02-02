package com.aditya.learningSpringBoot.labs.lab1;

public class Student {
    String firstName;
    String lastName;

    Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return ("First Name: "+this.firstName+
                    "  Last Name: "+ this.lastName + "\n");
   }

}
