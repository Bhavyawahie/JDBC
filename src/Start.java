import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDAO;

public class Start {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to the Student Management application");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println("Press 1 to 'ADD' a new student.");
            System.out.println("Press 2 to 'DELETE' a given student.");
            System.out.println("Press 3 to 'UPDATE' a given student.");
            System.out.println("Press 4 to 'DISPLAY' a given student.");
            System.out.println("Press 5 to EXIT");
            System.out.println();
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    // add student
                    System.out.println("Enter The Name of the Student.");
                    String StudentName = bufferedReader.readLine();
                    System.out.println("Enter The Phone Number of the Student.");
                    String StudentPhone = bufferedReader.readLine();
                    System.out.println("Enter The City of Residence of the Student.");
                    String StudentCity = bufferedReader.readLine();
                    Student student = new Student(StudentName, StudentPhone, StudentCity);
                    if (StudentDAO.addStudentToDB(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Something went wrong. Please Try Again!");
                    }
                    break;
                case 2:
                    System.out.println("Enter The 'ID' of the Student you would want to delete.");
                    int StudentID = Integer.parseInt(bufferedReader.readLine());
                    if (StudentDAO.deleteStudentFromDB(StudentID)) {
                        System.out.println("Deleting...");
                        Thread.sleep(500);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Something went wrong. Please Try Again!");
                    }
                    break;
                case 3:
                    System.out.println("Enter The 'ID' of the Student you would want to update.");
                    int StudentId = Integer.parseInt(bufferedReader.readLine());
                    Student existingStudent = StudentDAO.getStudentById(StudentId);
                    if (existingStudent != null) {
                        System.out
                                .println("Enter the updated Name of the Student (Leave blank to keep existing value):");
                        String updatedName = bufferedReader.readLine();
                        System.out.println(
                                "Enter the updated Phone Number of the Student (Leave blank to keep existing value):");
                        String updatedPhone = bufferedReader.readLine();
                        System.out.println(
                                "Enter the updated City of Residence of the Student (Leave blank to keep existing value):");
                        String updatedCity = bufferedReader.readLine();
                        if (updatedName.isEmpty()) {
                            updatedName = existingStudent.getStudentName();
                        }
                        if (updatedPhone.isEmpty()) {
                            updatedPhone = existingStudent.getStudentPhone();
                        }
                        if (updatedCity.isEmpty()) {
                            updatedCity = existingStudent.getStudentCity();
                        }
                        Student updatedStudent = new Student(updatedName, updatedPhone, updatedCity);
                        if (StudentDAO.updateStudentInDB(StudentId, updatedStudent)) {
                            System.out.println("Updating...");
                            Thread.sleep(500);
                            System.out.println("Student updated successfully!");
                        } else {
                            System.out.println("Something went wrong. Please try again!");
                        }
                    } else {
                        System.out.println("No student found with ID: " + StudentId);
                    }
                    break;
                case 4:
                    StudentDAO.showAllStudentsFromDB();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    Thread.sleep(500); // Delay execution for 1 second
                    System.out.println("Adios Amigo!");
                    return;
                default:
                    System.out.println("Enter a valid option!");
            }
        }
    }
}
