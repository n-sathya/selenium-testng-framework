package com.example.Practise;

import org.testng.annotations.Test;

public class Group_ClassA {

    @Test(groups = {"Chrome_v11"})
    public void Chromev11_Validation()
    {
        System.out.println("Validate in Chrome V11");
    }
    @Test(groups = {"Firefox_v11"})
    public void Firefoxv11_Validation()
    {
        System.out.println("Validate in Firefox V11");
    }
    
}
