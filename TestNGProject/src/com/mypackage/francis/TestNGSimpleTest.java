package com.mypackage.francis;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGSimpleTest extends BaseClass{

    @Test(groups = {CONSTANT_FIRST})
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

}
