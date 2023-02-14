/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.week1.practiceweek1;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author KhanhPham
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        StudentDAL studentDAL = new StudentDAL();
        showMenu();
        System.out.print("Enter your choice: ");
        int choice = input.nextByte();
        input.nextLine();
        while(choice != 0){
            switch (choice) {
                case 1:
                    studentDAL.readStudent();
                    break;
                case 2:
                    studentDAL.addStudent(NewStudent());
                    break;
                case 3:
                    System.out.println("Enter Student ID:");
                    studentDAL.deleteStudent(input.nextInt());
                    break;
                case 4:
                    System.out.println("Updating progress");
                    studentDAL.updateStudent(OldStudent());
                    break;
                case 5:
                    System.out.println("Enter a student name to find:");
                    String name = input.nextLine();
                    studentDAL.findStudent(name);
                    break;
                default:
                    System.out.println("Enter a valid number");
            }
            showMenu();
            System.out.print("Enter your choice: ");
            choice = input.nextByte();
            input.nextLine();
        }
    }
    
    public static Student NewStudent(){
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter student ID:");
        student.setPersonID(input.nextInt());
        System.out.println("Enter student's first name:");
        input.nextLine();
        student.setFirstName(input.nextLine());
        System.out.println("Enter student's last name:");
        student.setLastName(input.nextLine());
        Date today = new Date(System.currentTimeMillis());
        student.setEnrollmentDate(today);
        return student; 
    }
    
    public static Student OldStudent(){
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Enter student ID:");
        student.setPersonID(input.nextInt());
        System.out.println("Enter student's first name:");
        input.nextLine();
        student.setFirstName(input.nextLine());
        System.out.println("Enter student's last name:");
        student.setLastName(input.nextLine());
        System.out.println("Modify the EnrollmentDate:");
        Date date;
        String dateString = "";
        System.out.println("Year:");
        dateString += input.nextLine() + "-";
        System.out.println("Month:");
        dateString += input.nextLine() + "-";
        System.out.println("Day:");
        dateString += input.nextLine();
        date = Date.valueOf(dateString);
        student.setEnrollmentDate(date);
        return student; 
    }
    
    public static void showMenu(){
        System.out.println("=======================================");
        System.out.println("Student Information Management");
        System.out.println("0. Exit");
        System.out.println("1. Show list");
        System.out.println("2. Add a student");
        System.out.println("3. Delete a student");
        System.out.println("4. Update a student");
        System.out.println("5. Find a student");
        System.out.println("=======================================");
    }
}
