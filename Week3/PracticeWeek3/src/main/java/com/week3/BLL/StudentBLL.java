package com.week3.BLL;

import com.week3.DAL.Student;
import com.week3.DAL.StudentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentBLL {
    StudentDAL studentDAL = new StudentDAL();
    
    public void addStudent(Student newStudent){
        studentDAL.addStudent(newStudent);
    }
    
    public void deleteStudent(int id){
        studentDAL.deleteStudent(id);
    } 
    
    public void updateStudent(Student student){
        studentDAL.updateStudent(student);
    }
    
    public List findStudent(String firstName){
        return studentDAL.findStudent(firstName);
    }
    
    public List StudentList(){
        ArrayList list = studentDAL.StudentList();
        return list;
    }
    
    public int listSize(){
        return studentDAL.StudentList().size();
    }
}


/*
 * @author KhanhPham
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
