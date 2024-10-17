import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int age;
    private double grade;

    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int idCounter = 1;

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Grade");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudentGrade();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Student Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        students.add(new Student(name, idCounter++, age, grade));
        System.out.println("Student added successfully.");
    }

    private void updateStudentGrade() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new grade for " + student.getName() + ": ");
                double grade = scanner.nextDouble();
                student.setGrade(grade);
                System.out.println("Grade updated successfully.");
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Student with ID " + id + " not found.");
    }

    private void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\nList of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}