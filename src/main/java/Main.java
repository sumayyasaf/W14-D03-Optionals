import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Omar Kamal", 38,"Manama");

        List<Student> students = Arrays.asList(
                new Student("Rob", 18, 92.5, "Riyadh"),
                new Student("Bob", 22, 84.3, "Los Angeles"),
                new Student("Clair", 21, 67.8, "Manama"),
                new Student("Deena", 19, 75.4, "Manama"),
                new Student("Eve", 23, 89.9, "Boston")
        );
        Classroom classroom = new Classroom(teacher, students);
        System.out.println("Students below age 20: " + classroom.findStudentsBelowAge(20));
        System.out.println("High achievers: " + classroom.getHighAchievers(85));
        System.out.println("Students with age half or less than teacher's: " + classroom.getHalfTeacherAgeStudents());
        System.out.println("Average grade: " + classroom.calculateAverageGrade());
        System.out.println("Student names: " + classroom.getStudentNames());
        System.out.println("Grades map: " + classroom.getGradesMap());
        System.out.println("Sorted by age: " + classroom.sortStudentsByAge());
        System.out.println("Sorted by grade: " + classroom.sortStudentsByGrade());
        System.out.println("Top performers: " + classroom.findTopPerformers(3));
        System.out.println("Lowest performers: " + classroom.findLowestPerformers(2));
        System.out.println("Students by city: " + classroom.studentByCity());
        System.out.println("In-person tutoring students: " + classroom.getInPersonTutoringStudent());
        System.out.println("Unique students by city: " + classroom.getUniqueStudentsByCity());
        System.out.println("Students by age range: " + classroom.groupStudentsByAgeRange());
        System.out.println("Search student: " + classroom.searchStudents("Rob", 18, 92.5));
    }
    }

