package com.omar.homework.codealong;

public class Student{

    private String name;
    private int age;
    private double grade;

    public Student(String name, int age,double grade ) {
        this.grade = grade;
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        Student student = (Student) obj;
        return name.equals(student.getName());
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
