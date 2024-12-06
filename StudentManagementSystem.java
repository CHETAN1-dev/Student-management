import java.util.Scanner;

public class StudentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static StudentDatabase studentDatabase = new StudentDatabase();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> studentDatabase.viewAllStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        studentDatabase.addStudent(new Student(id, name, course));
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Course: ");
        String newCourse = scanner.nextLine();

        boolean isUpdated = studentDatabase.updateStudent(id, newName, newCourse);
        if (!isUpdated) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        boolean isDeleted = studentDatabase.deleteStudent(id);
        if (!isDeleted) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
