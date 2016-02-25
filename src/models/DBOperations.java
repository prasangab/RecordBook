/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author prasanga
 */
public class DBOperations {

    // JDBC database URL
    static final String url = "jdbc:mysql://localhost:3306/recordbook";
    static final String USER = "root";
    static final String PASS = "psnp.1991";

    Connection con = null;
    Statement stmt = null;

    ResultSet rs1, rs2;

    public void addPatient(PatientDetails pd) {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, USER, PASS);
            stmt = con.createStatement();

            //String query1 = "INSERT INTO personal_details VALUES (?,?,?,?)";
            //pst = con.prepareStatement(query1);
            String patientID = pd.getPatientID();
            String name = pd.getName();
            int age = Integer.parseInt(pd.getAge());
            String town = pd.getTown();
            //pst.executeUpdate();

            //String query2 = "INSERT INTO investigation VALUES (?,?,?,?,?)";           
            //pst = con.prepareStatement(query2);
            //pst.setString(1 , pd.getPatientID());
            String date = pd.getDate();
            String pc = pd.getPc();
            String hpc = pd.getHpc();
            String management = pd.getManagement();
            //pst.executeUpdate();

            System.out.println(name);
            System.out.println(patientID);
            System.out.println(age);
            System.out.println(town);
            System.out.println(date);
            System.out.println(pc);
            System.out.println(hpc);
            System.out.println(management);

            String query1 = "insert into personal_details values ('" + patientID + "','" + name + "','" + age + "','" + town + "')";
            System.out.println(query1);
            stmt.executeUpdate(query1);
            System.out.println("personal details table updated....!!!");

            String query2 = "insert into investigation values ('" + patientID + "','" + date + "','" + pc + "','" + hpc + "','" + management + "')";
            System.out.println(query2);
            stmt.executeUpdate(query2);
            System.out.println("investigation table updated....!!!");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    con.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public List viewUser(String name, String id) {

        List<PatientDetails> userList1 = new ArrayList<PatientDetails>();

        //Connection connection = null;
        //String rstring = null;
        //Statement stmt = null;///*******
        //ResultSet resultSet = null;
        try {

            //    Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, USER, PASS);

            String query1 = "SELECT * FROM personal_details WHERE (id)='" + id + "'";
            PreparedStatement statement1 = con.prepareStatement(query1);
            //statement.setString(1, name);
            rs1 = statement1.executeQuery();

            String query2 = "SELECT * FROM investigation WHERE (id)='" + id + "'";
            PreparedStatement statment2 = con.prepareStatement(query2);
            rs2 = statment2.executeQuery();

            System.out.println("select query done....");
            // connection = dataSource.getConnection();
            //stmt = connection.createStatement();///*******
            //resultSet = stmt.executeQuery("SELECT * FROM users WHERE (username)='" + username + "'"
            //       + "AND (password)='" + password + "'");///*******

            while (rs1.next()) {
                PatientDetails patient = new PatientDetails();
                patient.setPatientID(rs1.getString("id"));
                patient.setName(rs1.getString("name"));
                patient.setAge(rs1.getString("age"));
                patient.setTown(rs1.getString("town"));
                userList1.add(patient);

                //System.out.println();
                //for (Object a : userList) {
                //    System.out.println(a);
                //}
            }
            while (rs2.next()) {
                PatientDetails patient = new PatientDetails();
                patient.setPatientID(rs2.getString("id"));
                patient.setDate(rs2.getString("date"));
                patient.setPc(rs2.getString("pc"));
                patient.setHpc(rs2.getString("hpc"));
                patient.setManagement(rs2.getString("management"));
                userList1.add(patient);

            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {

                if (rs1 != null) {
                    rs1.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
        return userList1;
    }

    public void deleteUser(String name, String id) {

        try {

            //    Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, USER, PASS);

            String sql1 = "DELETE FROM investigation WHERE id = ?";

            PreparedStatement statment1 = con.prepareStatement(sql1);
            statment1.setString(1, id);
            //rs1 = statment1.executeQuery();

            int rowsDeleted1 = statment1.executeUpdate();
            if (rowsDeleted1 > 0) {
                System.out.println("A user was deleted successfully!");
            }
            //String query1 = "DELETE FROM personal_details WHERE (id)='" + id + "'";
            //PreparedStatement statement1 = con.prepareStatement(query1);
            //statement.setString(1, name);
            //rs1 = statement1.executeQuery();

            String sql2 = "DELETE FROM personal_details WHERE id = ?";

            PreparedStatement statment2 = con.prepareStatement(sql2);
            statment2.setString(1, id);
            //String query2 =  ;
            //PreparedStatement statment2 = con.prepareStatement("DELETE FROM investigation WHERE id=" + id);
            //rs2 = statment2.executeQuery();
            
            int rowsDeleted2= statment2.executeUpdate();
            if (rowsDeleted2 > 0) {
                System.out.println("A user was deleted successfully!");
            }

            System.out.println("delete query done....");
            // connection = dataSource.getConnection();
            //stmt = connection.createStatement();///*******
            //resultSet = stmt.executeQuery("SELECT * FROM users WHERE (username)='" + username + "'"
            //       + "AND (password)='" + password + "'");///*******

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {

                if (rs1 != null) {
                    rs1.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }

    }

}
