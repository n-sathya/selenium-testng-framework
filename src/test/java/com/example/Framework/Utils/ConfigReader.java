package  com.example.Framework.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader{
    protected static Properties prop = new Properties();
    static String path = (System.getProperty("user.dir") + "//src//test/resources//config.properties");

    static{
        FileInputStream fis;
        try {
            fis = new FileInputStream(path);
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }

    public static String getProperty(String key) {         
         return prop.getProperty(key);    
    }
   

}