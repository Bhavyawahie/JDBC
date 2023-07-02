package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
    
    public static boolean addStudentToDB(Student student) {
        Connection connection = CreateDB.createDBConnection();
        boolean flag = false;
        try {
            String query = "INSERT INTO STUDENTS(SNAME, SPHONE, SCITY) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentPhone());
            preparedStatement.setString(3, student.getStudentCity());
            preparedStatement.executeUpdate();
            connection.close();
            flag = true;
        } catch (SQLException e) {
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static boolean deleteStudentFromDB(int studentId) {
        Connection connection = CreateDB.createDBConnection();
        boolean flag = false;
        try {
            String query = "DELETE FROM STUDENTS WHERE SID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            connection.close();
            flag = true;
        } catch (SQLException e) {
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static void showAllStudentsFromDB() {
        Connection connection = CreateDB.createDBConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet set = statement.executeQuery(query);
            while(set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phoneNumber = set.getString(3);
                String city = set.getString(4);
                System.out.println();
                System.out.println("ID: " + id );
                System.out.println("NAME: " + name );
                System.out.println("PHONE: " + phoneNumber );
                System.out.println("CITY: " + city );
                for(int i = 0; i < 25; i++) {
                    System.out.print("+");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Oops, Try again!");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
