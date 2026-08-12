package com.example.Practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class ListnerdemoB {

    @Test
    public void testBrowserPass(){
        System.out.println("Testing in Browser");
        Assert.assertTrue(true);
    }

     @Test
    public void testBrowserFail(){
        System.out.println("Testing in Browser");
         Assert.assertTrue(false);
    }
}
