package com.shesh.db.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by shesh on 5/23/17.
 */
public final class DbUtil {

    public static Properties getProp(String file) throws IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream(file));
        return prop;
    }

    public static List fileAsList(String fileName) throws Exception{

        return FileUtils.readLines(new File(fileName),"Utf-8");

    }
}
