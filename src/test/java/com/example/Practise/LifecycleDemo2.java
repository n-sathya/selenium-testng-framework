package com.example.Practise;

import org.testng.annotations.*;

public class LifecycleDemo2 {

    @BeforeClass
    public void beforeClass(){ System.out.println("3. @BeforeClass - Class2"); }

    @BeforeMethod
    public void beforeMethod(){ System.out.println("   @BeforeMethod - Class2"); }

    @Test
    public void testC(){ System.out.println("      @Test testC - Class2"); }

    @Test
    public void testD(){ System.out.println("      @Test testD - Class2"); }

    @AfterMethod
    public void afterMethod(){ System.out.println("   @AfterMethod - Class2"); }

    @AfterClass
    public void afterClass(){ System.out.println("4. @AfterClass - Class2"); }
}