package com.example.studentregistrationsystem.model;

public class Student {
    private Long id;
    private String name;
    private String gender;
    private int age;
    private String email;

    //Constructor
    public Student(Long id, String name, String gender, int age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
}

