package com.shesh.db.main;

import com.shesh.db.utils.DbUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shesh on 5/27/17.
 */
public class Tester {
    public static void main(String[] args) throws  Exception {
        List res = new ArrayList();
        res = DbUtil.fileAsList("src/main/resources/mappings.txt");
        System.out.println(res.size());
        for(Object s : res){
            System.out.println(s.toString());
        }
    }
}
