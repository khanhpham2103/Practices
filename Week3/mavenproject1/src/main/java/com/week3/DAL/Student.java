package com.week3.DAL;

import java.sql.Date;

public class Student {
    String firstName, lastName;
    int personID;
    Date enrollmentDate;

    public Student() {
    }

    public Student(int personID, String firstName, String lastName, Date enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = personID;
        this.enrollmentDate = enrollmentDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return personID + " " + firstName + " " + lastName + " " + enrollmentDate;
    }
    
    
}

/*
 * @author KhanhPham
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
