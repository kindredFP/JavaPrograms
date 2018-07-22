package com.mypackage.francis;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ReflectionClass {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Test
    void ReflectionTest() {
        Method[] myMethods = ReflectionClass.class.getMethods();
        //Field[] myFields = ReflectionClass.class.getFields();

        for (Method methods : myMethods) {
            System.out.println("Here is a list of methods for my Reflection Class Test " + methods.getName());
        }
        //for (Field fields : myFields){
        //    System.out.println("Here are the internal methods " + fields.get);
        //}

    }
}
