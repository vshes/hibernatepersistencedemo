package com.shesh.db.utils;

import com.shesh.db.model.Course;
import com.shesh.db.model.Student;

import java.io.*;
import java.util.Properties;


/**
 * Created by shesh on 5/27/17.
 */
public class ModelSer implements Serializable {


    public void writeObjtoFile() throws  Exception{

        Properties files = DbUtil.getProp("generic.properties");
        Student s = new Student();
        Course c = new Course();
        FileOutputStream fos = new FileOutputStream(files.getProperty("serialfile"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.writeObject(c);
        oos.close();
        fos.close();

    }


    public void readFilesAndSer() throws  Exception{

        Properties files = DbUtil.getProp("generic.properties");
        FileInputStream fos = new FileInputStream(files.getProperty("serialfile"));
        ObjectInputStream oos = new ObjectInputStream(fos);
        Object s = oos.readObject();
        Object c = oos.readObject();

        if(s instanceof Student){
            Student student = (Student) s;
        }

        if(c instanceof Course){
            System.out.println("Found Course !");
        }
        oos.close();
        fos.close();

    }


}
