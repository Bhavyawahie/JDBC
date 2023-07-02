package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            System.out.println("Connection Failed!");
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
}
