package com.shesh.db.main;

import com.shesh.db.model.Student;
import com.shesh.db.service.StudentService;
import com.shesh.db.service.StudentServiceImpl;
import com.shesh.db.utils.GenerateData;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by shesh on 5/23/17.
 */
public class DatabaseStarter {
    public static void main(String[] args) throws Exception {

        GenerateData<Student> gen = new GenerateData<Student>(new Student());
        List<Student> studentList = gen.checkInstance();
        StudentService studentService = new StudentServiceImpl();
        for(Student student : studentList)studentService.create(student);

        Scanner scanner = new Scanner(System.in);
        String choice = "0";
        int findChoice = 0;
        HashMap<Integer,Student> studentMap = new HashMap<Integer, Student>();
        Student display = null;
        Student student = null;

        do{


           if(!choice.equals("4")){
               System.out.println("\t\t Select the Operation from Below");
               System.out.println("\t\t**********************************");
               System.out.println("\t\t 1. Find By Id");
               System.out.println("\t\t 2. Update By Id");
               System.out.println("\t\t 3. Delete By Id");
               System.out.println("\t\t 4. quit");
               System.out.println("\t\t**********************************");
               System.out.println("\t\t Enter your choice ");
           }
            choice = scanner.next();
            switch(Integer.parseInt(choice)){

                case 1: List<Student> students =studentService.findAll();
                    System.out.println("Select the Id from the list");
                    int ctr = 1;
                    for(Student s : students){
                        studentMap.put(ctr,s);
                        System.out.println("\t\t "+ctr+"\t"+s.getId());
                        ctr+=1;
                    }
                    findChoice = Integer.parseInt(scanner.next());
                    display = studentService.findOne(studentMap.get(findChoice).getId());
                    System.out.println(display.toString());
                    break;
                case 2:
                    System.out.println("\t\t Updating the Object with id"+studentMap.get(findChoice).getId());
                    System.out.println("Update the fields :");
                    scanner.nextLine();
                    System.out.println("firstname :");
                    String fName  = scanner.nextLine();
                    System.out.println("lastname :");
                    String lastName = scanner.nextLine();
                    System.out.println("address :");
                    String address  = scanner.nextLine();
                    student = studentService.findOne(studentMap.get(findChoice).getId());
                    student.setFirstName(fName);
                    student.setLastName(lastName);
                    student.setAddress(address);
                    Student res = studentService.update(student);
                    System.out.println("\t\t Updated :"+res.toString());
                    break;
                case 3:
                    System.out.println("Now deleting Object : "+studentMap.get(findChoice).getId());
                    //1findChoice = scanner.nextInt();
                    Student delS = studentService.findOne(studentMap.
                            get(findChoice).getId());
                    studentService.delete(delS);
                    break;
                case 4:
                    System.out.println("\t\t***************");
                    System.out.println("\t\t Process Complete");
                    System.out.println("\t\t***************");
                    break;
                default:
                    break;

            }

        }while(choice !=  "4");

    }
}
