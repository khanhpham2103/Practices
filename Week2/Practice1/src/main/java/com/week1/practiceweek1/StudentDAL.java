package com.week1.practiceweek1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAL {
    private MySQLConnect mysql = new MySQLConnect();
    
    public StudentDAL(){
    }
    
    public void readStudent() throws SQLException{
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0";
        System.out.println(query);
        ResultSet resultSet = mysql.executeQuery(query);
        System.out.print("No." + "\t");
        System.out.print("PersonID" + "\t\t");
        System.out.print("Firstname" + "\t\t");
        System.out.print("Lastname" + "\t\t\t");
        System.out.println("Enrollment Date");
        if (resultSet != null){
            int i = 1;
            while (resultSet.next()){
                System.out.print(i + "\t");
                System.out.print(resultSet.getInt("PersonID") + "\t\t");
                System.out.print(resultSet.getString("Firstname") + "       \t\t");
                System.out.print(resultSet.getString("Lastname")+ "       \t\t");
                System.out.println(resultSet.getString("EnrollmentDate"));
                i++;
            }
        }
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
    
    public void findStudent(String fullName) throws SQLException{
        String query = "SELECT * FROM Person WHERE concat(Firstname, '', Lastname) LIKE " + "'%" + fullName + "%'";
//        System.out.println(query);
        ResultSet resultSet = mysql.executeQuery(query);
        System.out.print("No." + "\t");
        System.out.print("PersonID" + "\t");
        System.out.print("Firstname" + "\t");
        System.out.println("Lastname" + "\t");
        if (resultSet != null){
            int i = 1;
            while (resultSet.next()){
                System.out.print(i + "\t");
                System.out.print(resultSet.getInt("PersonID") + "\t\t");
                System.out.print(resultSet.getString("Firstname") + "\t\t");
                System.out.println(resultSet.getString("Lastname"));
                i++;
            }
        }
        else {
            System.out.println("Not found");
        }
    }
}

/*
 * @author KhanhPham
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
