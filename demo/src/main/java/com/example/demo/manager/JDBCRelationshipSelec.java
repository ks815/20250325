package com.example.demo.manager;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCRelationshipSelec {
    public List<Obje> jdbcProgram(String ck) {
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
            //String sql = "select * from `relationship` where classID = "+ ck;
            String sql = "SELECT obj.StudentLName, obj.StudentFName, relationship.classID \n" +
                    "FROM obj\n" +
                    "left JOIN relationship on relationship.studentID = obj.StudentID \n" +
                    "WHERE relationship.classID = " + ck;
            resultSet = statement.executeQuery(sql);

            //Step 5
            List<Obje> list = new ArrayList();
            while (resultSet.next()) {
                String LName = resultSet.getString("StudentLName");
                String FName = resultSet.getString("StudentFName");
                Obje o = new Obje();
                o.setStudentLName(LName);
                o.setStudentFName(FName);
                list.add(o);
            }

            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            return list;
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


    public List<clas> jdbcProgramClas(String ck) {
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
            //String sql = "select * from `relationship` where classID = "+ ck;
            String sql = "Select class.id, class.grade, relationship.studentID, obj.StudentFName, obj.StudentLName \n" +
                    "FROM class \n" +
                    "left JOIN relationship on relationship.classID = class.id \n" +
                    "left join obj on obj.StudentID  = relationship.studentID \n" +
                    "WHERE relationship.studentID = " + ck;
            resultSet = statement.executeQuery(sql);

            //Step 5
            List<clas> list2 = new ArrayList();
            while (resultSet.next()) {
                Integer classIDNum = Integer.valueOf(resultSet.getString("id"));
                String classGrade = resultSet.getString("grade");
                //String schooName = resultSet.getString("schoolName");
                //String FName = resultSet.getString("StudentFName");
                clas a = new clas();
                a.setId(classIDNum);
                a.setGrade(classGrade);
                //a.setSchoolName(schooName);
                //o.setStudentFName(FName);
                list2.add(a);
            }

            if (CollectionUtils.isEmpty(list2)) {
                return null;
            }
            return list2;
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
        JDBCRelationshipSelec jdbcRelationshipSelec = new JDBCRelationshipSelec();
        jdbcRelationshipSelec.jdbcProgram("1");
    }

}
