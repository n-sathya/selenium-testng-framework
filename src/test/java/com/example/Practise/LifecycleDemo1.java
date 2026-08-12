package com.example.Practise;

import org.testng.annotations.*;

public class LifecycleDemo1 {

    @BeforeSuite
    public void beforeSuite(){ System.out.println("1. @BeforeSuite - Class1"); }

    @BeforeTest
    public void beforeTest(){ System.out.println("2. @BeforeTest - Class1"); }

    @BeforeClass
    public void beforeClass(){ System.out.println("3. @BeforeClass - Class1"); }

    @BeforeMethod
    public void beforeMethod(){ System.out.println("   @BeforeMethod - Class1"); }

    @Test
    public void testA(){ System.out.println("      @Test testA - Class1"); }

    @Test
    public void testB(){ System.out.println("      @Test testB - Class1"); }

    @AfterMethod
    public void afterMethod(){ System.out.println("   @AfterMethod - Class1"); }

    @AfterClass
    public void afterClass(){ System.out.println("4. @AfterClass - Class1"); }

    @AfterTest
    public void afterTest(){ System.out.println("5. @AfterTest - Class1"); }

    @AfterSuite
    public void afterSuite(){ System.out.println("6. @AfterSuite - Class1"); }
}