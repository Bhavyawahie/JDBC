

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;

public class Start {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to the Student Management application");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to 'ADD' a new student.");
            System.out.println("Press 2 to 'DELETE' a given student.");
            System.out.println("Press 3 to 'DISPLAY' a given student.");
            System.out.println("Press 4 to EXIT");
            int choice = Integer.parseInt(bufferedReader.readLine());
            switch (choice) {
                case 1:
                    // add student
                    System.out.println("Enter The Name of the Student.");
                    String StudentName = bufferedReader.readLine();
                    System.out.println("Enter The Phone Number of the Student.");
                    String StudentPhone = bufferedReader.readLine();
                    System.out.println("Enter The City of residence of the Student.");
                    String StudentCity = bufferedReader.readLine();
                    Student student = new Student(StudentName, StudentPhone, StudentCity);
                    System.out.println(student);
                    break;
                case 2:
                    // delete student
                    break;
                case 3:
                    // display student
                    break;
                case 4:
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
