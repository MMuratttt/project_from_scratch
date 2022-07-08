package kuzzat.cydeo.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static{

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("ConfigurationReader issue!");
            e.printStackTrace();
        }

    }


    public static String getProperty(String string){
        return properties.getProperty(string);
    }




}
