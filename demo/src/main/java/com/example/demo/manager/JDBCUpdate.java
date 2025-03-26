package com.example.demo.manager;

import org.springframework.stereotype.Component;
import java.sql.*;
@Component
public class JDBCUpdate {
    public String jdbcProgram(Obje obje) {
        //connect object
        Connection connection = null;
        //operate object
        Statement statement = null;
        //the final result
        ResultSet resultSet = null;

        try {
            //Step 1
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);


            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Step 2
            String url = "jdbc:mysql://42.192.214.195:3306/kevin";
            String userName = "pzq";
            String passWord = "pzq123456";
            connection = DriverManager.getConnection("jdbc:mysql://42.192.214.195:3306/kevin", "pzq", "pzq123456");

            //Step 3
            statement = connection.createStatement();

            //Step 4
            String sql = "";
            int a = 0;
            if (obje.getStudentID() == null) {
                return "Game over";
            }
            else {
                if (obje.getStudentFName() != null && obje.getStudentLName() == null) {
                    sql = "update `obj` set StudentFName = '" + obje.getStudentFName() + "' where StudentID = " + obje.getStudentID();
                    a = statement.executeUpdate(sql);
                }
                else if (obje.getStudentLName() != null && obje.getStudentFName() == null) {
                    sql = "update `obj` set StudentLName = '" + obje.getStudentLName() + "' where StudentID = " + obje.getStudentID();
                    a = statement.executeUpdate(sql);
                }
               else if (obje.getStudentLName() != null && obje.getStudentFName() != null) {
                    sql = "update `obj` set StudentLName = '" + obje.getStudentLName() + "', StudentFName = '" + obje.getStudentFName()+ "' where StudentID = " + obje.getStudentID();
                    a = statement.executeUpdate(sql);
                }
               else {
                   return "Game over";
                }
            }

            if (a > 0) {
                return "Success";
            } else {
                return "Fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //step 6
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
        }
    }
