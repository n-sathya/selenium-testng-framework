package com.example.Practise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demo1 {
    @DataProvider(name = "Kamal")
    public Object[][] getDemoData1A() throws IOException{
        String path = System.getProperty("user.dir");
        FileReader fr = new FileReader(path + "//Data//data.csv");
        BufferedReader br = new BufferedReader(fr);
        List<String[]> emp_details = new ArrayList<String[]>();
        String line; 
        int ind = 0;       
        while(true){
            
            line = br.readLine();            
            if (line != null){
                if (ind > 0){
                    emp_details.add(line.split(","));
                    
                }
            }
            else{
                break;
            }
            ind = ind + 1;
        }
        System.out.println(emp_details);
        br.close();
        Object[][] data = new Object[emp_details.size()][];
        int i = 0;
        for (String[] emp : emp_details){
            data[i] = emp;
            i = i+1;
        }
        
        return data;       

    }
    
    @Test(groups="smoke", dataProvider = "Kamal")
    public void demoTest1A(String name, String age, String salary){
        System.out.println("Hello World from demo1A - Smoke Test");
        System.out.println(name + " , " + Integer.parseInt(age) + " , " + Float.parseFloat(salary));
    }

    @Test(groups="regression")
    public void demoTest1B(){
        System.out.println("Hello World from demo 1B - Regression Test");
    }
    
}
