import java.util.ArrayList;

public class StudentDatabase {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- List of Students ---");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Update a student
    public boolean updateStudent(int id, String newName, String newCourse) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setCourse(newCourse);
                System.out.println("Student updated successfully!");
                return true;
            }
        }
        return false;
    }

    // Delete a student
    public boolean deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return true;
            }
        }
        return false;
    }
}
