package com.omar.homework.codealong;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>( Arrays.asList(
                new Student("Alice", 20, 88.5),
                new Student("Bob", 22, 75.0),
                new Student("Charlie", 23, 92.0),
                new Student("David", 21, 84.0),
                new Student("Eve", 22, 90.5),
                new Student("Eve", 30, 80.11)

        ));


        Stream<Student> studentStream = students.stream();

       students.forEach((oneStudent)->{
            System.out.println(oneStudent);;
        });

        HashSet<Student> uniqueStudents = new HashSet<>(students);


        students.stream()
                .map((oneStudent)->oneStudent.getName().toUpperCase())
                .forEach(oneStudent-> System.out.println(oneStudent));

        students.stream()
                .filter(oneStudent->oneStudent.getAge()>=22)
                .forEach(System.out::println);

        System.out.println("----------------------");

        students.stream()
                .sorted(Comparator.comparingDouble((student)->student.getGrade()))
                .forEach(oneStudent-> System.out.println(oneStudent));


        System.out.println("----------");
        students.stream()
                .distinct()
                .forEach(student -> System.out.println(student));


        System.out.println(students.stream()
                .filter(student -> student.getAge()>21)
                .count());

        System.out.println(students.stream()
                .filter(student -> student.getGrade()>80).toList());

        System.out.println(students.stream().mapToInt(student->student.getAge()).average());

        System.out.println(students.stream().mapToDouble(student->student.getGrade()).sum());

        System.out.println(students.parallelStream().mapToDouble(student->student.getGrade()).sum());




    }

}
