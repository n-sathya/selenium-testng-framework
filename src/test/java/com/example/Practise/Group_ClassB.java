package com.example.Practise;

import org.testng.annotations.Test;

public class Group_ClassB {

    @Test(groups = {"Chrome_v12"})
    public void Chromev12_Validation()
    {
        System.out.println("Validate in Chrome V12");
    }
    @Test(groups = {"Firefox_v12"})
    public void Firefoxv12_Validation()
    {
        System.out.println("Validate in Firefox V12");
    }
    
}
