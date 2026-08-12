package com.example.Framework.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataGenerator {

    public static String getAlphabets(int count){
        return RandomStringUtils.insecure().nextAlphabetic(count);
    }

    public static String getAlphaNumeric(int count){
        return RandomStringUtils.insecure().nextAlphanumeric(count);
    }

    public static String getNumeric(int count){
        return RandomStringUtils.insecure().nextNumeric(count);       
    }
    
}
