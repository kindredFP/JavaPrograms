package com.mypackage.francis;

import com.helper.interfaces.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RetryFailureTest extends BaseClass {

    HashMap myMap;

    @DataProvider(name = "test1")
    public static Object[][] myDataProvider() {

        return new Object[][]{{"francis", true}, {"aiden", false}, {"hannah", true}};
    }

    //for each
    @Test(dataProvider = "test1",retryAnalyzer = RetryAnalyzer.class)
    public void myTest(String myString, boolean myBoolean) {

        System.out.println("my string =" + myString);
        System.out.println("my boolean =" + myBoolean);
        System.out.println("*******");
        Assert.assertEquals(myBoolean,true,"Failed test");

    }

    @Test(dataProvider = "test1")
    public void anotherSampletest(String myString, boolean myBoolean) {

        System.out.println("my string =" + myString);
        System.out.println("my boolean =" + myBoolean);
        System.out.println("*******");
        Assert.assertEquals(myBoolean,true,"Failed test");

    }

}
