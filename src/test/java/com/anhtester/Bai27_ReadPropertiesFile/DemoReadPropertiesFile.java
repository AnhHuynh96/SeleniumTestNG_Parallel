package com.anhtester.Bai27_ReadPropertiesFile;

import com.anhtester.helpers.PropertiesHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFile {
    @Test
    public void testReadFile(){
        //Load all properties file
        PropertiesHelper.loadAllFiles();
        //Get value
        System.out.println("BROWSER : " + PropertiesHelper.getValue("browser"));
        System.out.println("URL : " + PropertiesHelper.getValue("url"));
        System.out.println("EMAIL : " + PropertiesHelper.getValue("email"));
        System.out.println("PASSWORD : " + PropertiesHelper.getValue("password"));
        System.out.println("MESSAGE : " + PropertiesHelper.getValue("message1"));
        System.out.println("TIMEOUT : " + PropertiesHelper.getValue("timeout"));

    }
    @Test
   public void setDataToProperties(){
        //Chi dinh file can set data
        //PropertiesHelper.setFile("src/test/resources/configs/configs.properties");
        PropertiesHelper.loadAllFiles();
        //Goi ham set value
        PropertiesHelper.setValue("headless","10");
    }
}
