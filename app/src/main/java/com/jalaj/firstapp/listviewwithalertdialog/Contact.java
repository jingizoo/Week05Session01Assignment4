package com.jalaj.firstapp.listviewwithalertdialog;

import java.util.Date;

/**
 * Created by jalajmehta on 7/23/16.
 */

public class Contact {

    String name;
    Date dateOfBirth;
    int age;

    public Contact(String name, Date dateOfBirth, int age) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
