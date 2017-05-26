package com.shesh.db.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by shesh on 5/23/17.
 */
public final class DbUtil {

    public static Properties getProp() throws IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.out.println("Properties Called ");
        return prop;
    }
}
