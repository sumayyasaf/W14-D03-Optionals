import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Classroom {
    private Teacher teacher;
    private List<Student> students;

    public Classroom(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //---------------1. Filtering Methods-----------------------------------
    public List<Student> findStudentsBelowAge(int age) {
        return students.stream()
                .filter(student -> student.getAge() < age)
                .collect(Collectors.toList());
    }

    public List<Student> getHighAchievers(double minGrade) {
        return students.stream()
                .filter(student -> student.getGrade() >= minGrade)
                .collect(Collectors.toList());
    }

    public List<Student> getHalfTeacherAgeStudents() {
        int halfAge = teacher.getAge() / 2;
        return students.stream()
                .filter(student -> student.getAge() <= halfAge)
                .collect(Collectors.toList());
    }

    //--------------2. Transformation and Aggregation Methods--------------------
    public double calculateAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);

    }

    public String getStudentNames() {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
    }

    public Map<Character, List<Student>> getGradesMap() {
        return students.stream()
                .collect(Collectors.groupingBy(student -> {
                    double grade = student.getGrade();
                    if (grade >= 90) return 'A';
                    else if (grade >= 80) return 'B';
                    else if (grade >= 70) return 'C';
                    else return 'D';
                }));
    }

    //----------------3. Sorting Methods------------------------------
    public List<Student> sortStudentsByAge() {
        return students.stream()
                .sorted(Comparator.comparingInt(Student::getAge))
                .collect(Collectors.toList());
    }

    public List<Student> sortStudentsByGrade() {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .collect(Collectors.toList());
    }

    //4. Advanced Queries
    public List<Student> findTopPerformers(int count) {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public List<Student> findLowestPerformers(int count) {
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade))
                .limit(count)
                .collect(Collectors.toList());
    }

    public Map<String, List<Student>> studentByCity() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCity));
    }

    //----------------------5. Bonus Tasks------------------------------
    public List<Student> getInPersonTutoringStudent() {
        String teacherCity = teacher.getCity();
        return students.stream()
                .filter(student -> student.getCity().equals(teacherCity))
                .collect(Collectors.toList());
    }

    public Map<String, Student> getUniqueStudentsByCity() {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCity,
                        Collectors.minBy(Comparator.comparing(Student::getName))
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPresent()) // Remove optional wrapping
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().get()
                ));
    }

    public Map<String, List<Student>> groupStudentsByAgeRange() {
        return students.stream()
                .collect(Collectors.groupingBy(student ->{
                    if(student.getAge()>=20 && student.getAge()<=29 ) return "20-29";
                    else if (student.getAge() >= 30 && student.getAge() <= 39) return "30-39";
                    else if (student.getAge() >= 40 && student.getAge() <= 49) return "40-49";
                    else return "50-59";
                }));

                }
    public List<Student> searchStudents(String name, int age, double grade) {
        return students.stream()
                .filter(student -> student.getName().equalsIgnoreCase(name)
                        && student.getAge() == age
                        && student.getGrade() == grade)
                .collect(Collectors.toList());
    }


    }


