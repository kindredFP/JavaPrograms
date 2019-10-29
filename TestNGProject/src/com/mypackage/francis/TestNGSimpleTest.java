package com.mypackage.francis;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestNGSimpleTest extends BaseClass {

    public enum DIRECTIONS {UP, DOWN, LEFT, RIGHT}

    int x;

    @Test(groups = {CONSTANT_SECOND})
    public void testAdd() {
        String str = "TestNG is working fine first";
        System.out.println(str);
        assertEquals("TestNG is working fine first", str);
    }

    @Test(groups = {CONSTANT_SECOND})
    public void testSecond() {
        String str = "TestNG is working fine second";
        System.out.println(str);
        assertEquals("TestNG is working fine second", str);
    }

    //for each
    @Test()
    public void forEachTest() {
        List<String> myList = new ArrayList<>();
        myList.add("value1");
        myList.add("value2");
        myList.add("value3");

        for (String myL : myList) {
            System.out.println(myL);
        }
    }

    //Enums
    @Test()
    public void enumerationTest() {

        for (DIRECTIONS myDirections : DIRECTIONS.values()) {
            System.out.println(myDirections);
            System.out.println(myDirections.values());
            System.out.println(myDirections.name());

        }


    }

    //Generics
    @Test()
    public void genericsTest() {

        List<String> myList = new ArrayList<>();
        myList.add("string1");
        myList.add("string2");
        // Caught on compile time
        //myList.add(new Integer("1"));
    }

    //Sample
    @Test()
    public void sampleTest() {

        int y;

        //compile time error need to initialize primitive type
        System.out.println(x);
    }

}
