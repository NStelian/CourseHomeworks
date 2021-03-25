package ro.fasttrackit.tema4.ex1;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Student("Steli", LocalDate.of(1999, 12, 1), 8));
        System.out.println(new Student("Cipri", 21, 10));

        Student student1 = new Student("Steli", LocalDate.of(1999, 12, 1), 8);
        Student student2 = new Student("Cipri", 21, 10);
        Student student3 = new Student("Radu", 21, 10);
        Student student4 = new Student("Cornel", 21, 10);
        Student student5 = new Student("Augustin", 21, 10);
        StudentService studentService = new StudentService(List.of(student1, student2, student3, student4, student5));

        System.out.println(studentService.averageStudentsGrades());

        System.out.println(studentService.allocateCourses());

        System.out.println(studentService.getStudentPlace(student1));
        System.out.println(studentService.getStudentPlace(student2));
        System.out.println(studentService.getStudentPlace(student3));
        System.out.println(studentService.getStudentPlace(student4));
        System.out.println(studentService.getStudentPlace(student5));


    }

    record Student(String name, LocalDate birthDate, int grade) {

        public Student(String name, int age, int grade) {
            this(name, setRandomBirthday(age), grade);
        }

        private static LocalDate setRandomBirthday(int age) {
            Random rand = new Random();
            LocalDate birthDate = LocalDate.now().minusYears(age).withMonth(rand.nextInt(12) + 1).withDayOfMonth(rand.nextInt(27) + 1);

            return birthDate;
        }

        public int getAge() {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
    }
}
