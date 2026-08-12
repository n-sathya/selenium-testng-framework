package com.example.Practise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demo2 {
    @DataProvider(name = "Rajini")
    public Object[][] getJsonData() throws IOException{

        Path p = Paths.get(System.getProperty("user.dir") + "//Data//data.json");
        String content=new String(Files.readAllBytes(p));
        JSONArray jsons = new JSONArray(content);
        Object[][] data = new Object[jsons.length()][3];
        for (int i=0; i < jsons.length(); i++){
            JSONObject obj =  jsons.getJSONObject(i);
            data[i][0] = obj.getString("name");
            data[i][1] = obj.getInt("age");
            data[i][2] = obj.getFloat("salary");
        }
        return data;
    }

    @Test(groups="smoke", dataProvider = "Rajini")
    public void demoTest2A(String name, int age, float salary){
        System.out.println("Hello from demo2A smoke");
        System.out.println(name + " - " + age + " - " + salary);

    }
     @Test(groups="regression")
    public void demoTest2B(){
        System.out.println("Hello from demo2B regression");
    }
    
}
