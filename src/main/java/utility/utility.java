package utility;

import base.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utility extends BaseClass {

    public static String readPFData(String key) throws IOException{
        FileInputStream file=new FileInputStream((System.getProperty("user.dir")+"//utility//config.properties"));
        Properties prop=new Properties();
        prop.load(file);
        String value=prop.getProperty(key);
        return value;

    }
}
