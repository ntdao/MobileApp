package com.example.mobileprogramming.model;

public class User {
    private String fullname;
//    private String password;
    private String phone_number;
//    private String birthday;
    private String email;
//    private String address;

    public User() {
    }

    public String getName() {
        return fullname;
    }

    public void setName(String name) {
        this.fullname = fullname;
    }
    public String getPhoneNumber(){return phone_number;}
    public void setPhoneNumber(String phoneNumber){this.phone_number=phoneNumber;}

//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }

    public User(String name, String phoneNumber, String email) {
        this.fullname = name;
        this.phone_number = phoneNumber;
        this.email = email;
    }

//    public User(String phoneNumber, String password, String name, String birthday, String email, String address) {
//        this.phoneNumber = phoneNumber;
//        this.password = password;
//        this.name = name;
//        this.birthday = birthday;
//        this.email = email;
//        this.address = address;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phone_number + '\'' +
                '}';
    }
}
