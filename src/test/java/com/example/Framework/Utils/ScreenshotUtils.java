package com.example.Framework.Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;



public class ScreenshotUtils {

    protected TakesScreenshot ts;

    public void captureScreenShot(WebDriver driver, String testName) throws IOException{
        ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String folder = System.getProperty("user.dir");
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM_dd_yyyy-HH_mm_ss");
        String timeStamp = time.format(format);
        String date = time.toLocalDate().toString();
        String path = folder + String.format("//Screenshots//%s//screenshot_%s_%s.png",date,testName,timeStamp);
        File destination = new File(path);
        FileUtils.copyFile(source,destination);

    }

    @Attachment(value="Failure Screenshot", type = "image/png")
    public byte[] captureScreenShotForAllure(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
}
