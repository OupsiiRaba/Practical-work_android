package com.example.myapplication;




public class Contact {


    String firstName;

    String lastName;
    String job;
    String phone;

    String email;
    public Contact() {
    }

    public Contact(String firstName, String lastName, String job, String phone, String email) {
       ;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.phone = phone;
        this.email = email;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
