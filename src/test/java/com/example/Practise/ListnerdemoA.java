package com.example.Practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ListnerdemoA {

    @Test
    public void testAPIPass(){
        System.out.println("Testing in API");
        Assert.assertTrue(true);
    }

     @Test
     public void testAPIFail(){
        System.out.println("Testing in API");
         Assert.assertTrue(false);
    }

    @Test(testName = "Skipped", enabled = false)
    public void testAPISkip(){
        System.out.println("THis is skipped");
    }
}
