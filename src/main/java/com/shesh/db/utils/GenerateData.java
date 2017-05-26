package com.shesh.db.utils;

import com.shesh.db.model.Student;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by shesh on 5/23/17.
 */
public final class GenerateData<T> {


    public GenerateData(T t) {
        this.t = t;
    }

    private T t;
    private  List<Student>  genericList = new ArrayList<Student>();
    
    
    public List<Student> checkInstance() throws  Exception{

        if(t instanceof Student) {
            return this.genericData(((Student) t));
        }

        return null;
    }

    ICsvBeanReader beanReader ;
    public  List<Student> genericData(Student student) throws Exception{

        InputStream is = ClassLoader.getSystemResourceAsStream("input/studentdata");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        beanReader = new CsvBeanReader(reader, CsvPreference.STANDARD_PREFERENCE);
        String[] header = beanReader.getHeader(true);
        CellProcessor[] cellProcessors = CsvProcessor.getProcessors();


        while( (student = beanReader.read( new Student(), header, cellProcessors)) != null ) {
            Logger.getLogger("DATA-TEST").finer(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
                    beanReader.getRowNumber(), student));
            genericList.add(student);
        }

        return genericList;

    }
    
    



}
