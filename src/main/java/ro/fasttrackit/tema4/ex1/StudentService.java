package ro.fasttrackit.tema4.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentService {
    public final List<Main.Student> students;

    public StudentService(List<Main.Student> students) {
        this.students = new ArrayList<>(students);
    }

    public String getStudentPlace(Main.Student student) {
        return switch (students.indexOf(student)) {
            case 0, 1, 2 -> "1st grade";
            case 3 -> "5th grade";
            default -> "7th grade";
        };
    }

    public String averageStudentsGrades() {
        return students.stream()
                .collect(Collectors.teeing(
                        Collectors.mapping(Main.Student::name, Collectors.toList()),
                        Collectors.averagingInt(Main.Student::grade),
                        (names, average) -> names + " have an average grade of " + average
                ));
    }

    public List<String> allocateCourses() {
        return students.stream()
                .map(student -> student.name() + " will participate to course " + getRandomCourse())
                .collect(Collectors.toList());
    }

    private String getRandomCourse() {
        Random random = new Random();

        String course1 = """
                {
                    "course":"Math 101",
                    "semester":2
                }
                """.formatted("Math 101", 2);

        String course2 = """
                {
                    "course":"Geography",
                    "semester":2
                }
                """.formatted("Geography", 1);

        String course3 = """
                {
                    "course":"English",
                    "semester":2
                }
                """.formatted("English", 1);

        List<String> courses = List.of(course1, course2, course3);

        return courses.get(random.nextInt(courses.size()));
    }
}
