// Student Mangement System
import java.util.*;
class Student {
    private int id;
    private String name;
    private String grade;
    private int attendance;
    private String course;
    public Student(int id, String name, String grade, int attendance, String course) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.attendance = attendance;
        this.course = course;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade + ", Course: " + course + ", Attendance: " + attendance;
    }
}

class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }
    public void viewStudents() {
        students.forEach(System.out::println);
    }
    public void updateStudent(int id, String newName, String newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setGrade(newGrade);
                break;
            }
        }
    }
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
    public Student searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}
class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Update student details");
            System.out.println("4. Delete student");
            System.out.println("5. Search student by name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter student attendance: ");
                    int attendance = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter student course: ");
                    String course = scanner.nextLine();
                    sms.addStudent(new Student(id, name, grade, attendance, course));
                    break;
                case 2:
                    System.out.println("\nStudents List:");
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    sms.updateStudent(updateId, newName, newGrade);
                    break;
                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    Student foundStudent = sms.searchStudentByName(searchName);
                    System.out.println(foundStudent != null ? foundStudent : "Student not found.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}