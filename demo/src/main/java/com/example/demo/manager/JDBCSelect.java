package com.example.demo.manager;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class JDBCSelect {


    public String jdbcProgram(String ck) {
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
            DriverManager.setLoginTimeout(200000);
            connection = DriverManager.getConnection("jdbc:mysql://42.192.214.195:3306/kevin", "pzq", "pzq123456");

            //Step 3
            statement = connection.createStatement();

            //Step 4
            String sql = "select * from `obj` where StudentRank <= "+ ck;
            resultSet = statement.executeQuery(sql);

            //Step 5
            //String nameList = "";
            List<String> list = new ArrayList();
            while (resultSet.next()) {
                String LName = resultSet.getString("StudentLName");
                String FName = resultSet.getString("StudentFName");
                list.add(FName);
                list.add(LName);
            }
            if (CollectionUtils.isEmpty(list)){
                return null;
            }
            return String.join(", ", list);
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
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

    public static void main(String[] args){
        JDBCSelect jdbc = new JDBCSelect();
        jdbc.jdbcProgram("1");
    }

}
