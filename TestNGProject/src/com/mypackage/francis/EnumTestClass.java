package com.mypackage.francis;

import com.helper.enums.DIRECTIONS;
import org.testng.annotations.Test;

public class EnumTestClass {

    //Enums
    @Test()
    public void enumerationTest() {

        for (DIRECTIONS myDirections : DIRECTIONS.values()) {
            System.out.println("myDirections=" + myDirections);
            System.out.println("myDirections.values()=" + myDirections.values());
            //name
            System.out.println("myDirections.name()=" + myDirections.name());
            //value passed in constructor
            System.out.println("myDirections.getClassReference()=" + myDirections.getClassReference());
        }


    }


}
