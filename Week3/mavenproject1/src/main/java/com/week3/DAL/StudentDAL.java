package com.week3.DAL;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAL {
    private MySQLConnect mysql = new MySQLConnect();
    
    public StudentDAL(){
    }
    
    public ArrayList<Student> StudentList(){
        mysql.Connect();
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        System.out.println(query);
        ResultSet resultSet = mysql.executeQuery(query);
        ArrayList<Student> list = new ArrayList<Student>();
//        System.out.print("No." + "\t");
//        System.out.print("PersonID" + "\t\t");
//        System.out.print("Firstname" + "\t\t");
//        System.out.print("Lastname" + "\t\t\t");
//        System.out.println("Enrollment Date");
        if (resultSet != null){
            try {
                //            int i = 1;
                while (resultSet.next()){
//                System.out.print(i + "\t");
//                System.out.print(resultSet.getInt("PersonID") + "\t\t");
//                System.out.print(resultSet.getString("Firstname") + "       \t\t");
//                System.out.print(resultSet.getString("Lastname")+ "       \t\t");
//                System.out.println(resultSet.getString("EnrollmentDate"));
//                i++;
                    Student student = new Student();
                    student.setPersonID(resultSet.getInt("PersonID"));
                    student.setLastName(resultSet.getString("Lastname"));
                    student.setFirstName(resultSet.getString("Firstname"));
                    student.setEnrollmentDate(resultSet.getDate("EnrollmentDate"));
                    list.add(student);
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    
    public void addStudent(Student student){
        int id = student.getPersonID();
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String hireDate = "NULL";
        String enrollmentDate = student.getEnrollmentDate().toString();
        String query = "INSERT INTO Person (PersonID, Lastname, Firstname, HireDate, EnrollmentDate) VALUES ("
                        + "'" +      id        +"'"  + ", " 
                        + "'" + firstName      + "'" + ", " 
                        + "'" + lastName       + "'" + ", "
                        +       hireDate             + ", "
                        + "'" + enrollmentDate + "'" + ")";
        System.out.println(query);
        mysql.executeUpdate(query);
        System.out.println("Student added!");
    }
    
    public void deleteStudent(int id){
        String query = "DELETE FROM Person WHERE PersonID = " + id;
        System.out.println(query);
        mysql.executeUpdate(query);
        System.out.println("Student deleted!");
    }
    
    public void updateStudent(Student student){
        String query = "UPDATE Person SET "
                     + "Firstname = "      + "'" + student.getFirstName() + "'" + ", "
                     + "Lastname = "       + "'" +student.getLastName() + "'"   + ", "
                     + "HireDate = "       + "NULL"                             + ", "
                     + "EnrollmentDate = " + "'" + student.getEnrollmentDate().toString() + "'" + " "
                     + "WHERE PersonID = " + student.getPersonID();
        System.out.println(query);
        mysql.executeUpdate(query);
        System.out.println("Student updated!");
    }
    
    public ArrayList<Student> findStudent(String firstName){
        ArrayList<Student> list = new ArrayList<Student>();
        String query = "SELECT * FROM Person WHERE Firstname LIKE " + "'%" + firstName + "%'";
        System.out.println(query);
        ResultSet resultSet = mysql.executeQuery(query);
//        System.out.print("No." + "\t");
//        System.out.print("PersonID" + "\t");
//        System.out.print("Firstname" + "\t");
//        System.out.println("Lastname" + "\t");
        if (resultSet != null){
            int i = 1;
            try {
                while (resultSet.next()){
//                        System.out.print(i + "\t");
//                        System.out.print(resultSet.getInt("PersonID") + "\t\t");
//                        System.out.print(resultSet.getString("Firstname") + "\t\t");
//                        System.out.println(resultSet.getString("Lastname"));
//                        i++;
                    Student student = new Student();
                    student.setPersonID(resultSet.getInt("PersonID"));
                    student.setLastName(resultSet.getString("Lastname"));
                    student.setFirstName(resultSet.getString("Firstname"));
                    student.setEnrollmentDate(resultSet.getDate("EnrollmentDate"));
                    list.add(student);
                }
                return list;
            } catch (SQLException ex) {                
                Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            return new ArrayList<Student>();
    }
}

/*
 * @author KhanhPham
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
