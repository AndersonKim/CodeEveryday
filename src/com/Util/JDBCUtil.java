package com.Util;

import com.Project.IdSpider.SFZ;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * sample of JDBC util for mysql
 */
public class JDBCUtil {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //ensure encoding
    static final String DB_URL = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    @Test
    public void connectMySQL() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM tableinfo";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int subject = rs.getInt("subject");
                int grade = rs.getInt("grade");
                String name = rs.getString("name");


                //Display values
                System.out.print("ID: " + id);
                System.out.print(", subject: " + subject);
                System.out.print(", grade: " + grade);
                System.out.print(", name: " + name);
                System.out.println();
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println();
        System.out.println("Goodbye!");
    }//end main

    //insert record
    @Test
    public void insert() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO sfzinfo VALUES (null,'ander','123123123123',36,'阿斯顿','男')";
        stmt.executeUpdate(sql);
        if (stmt != null)
            conn.close();
        if (conn != null)
            conn.close();
    }


    //delete record
    public void delete() {

    }


    //update record
    public void update() {

    }


    //search record
    public void search() {

    }

    //batch operation
    @Test
    public void batch() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement stmt = conn.createStatement();

        // Set auto-commit to false
        conn.setAutoCommit(false);

        String sql1 = "INSERT INTO tableinfo VALUES ('6','Tom', 3, 18)";

        stmt.addBatch(sql1);
        String sql2 = "INSERT INTO tableinfo VALUES ('7','Tom', 3, 18)";
        stmt.addBatch(sql2);
        String sql3 = "INSERT INTO tableinfo VALUES ('8','Tom', 3, 18)";
        stmt.addBatch(sql3);

        // Create an int[] to hold returned values
        int[] count = stmt.executeBatch();
        System.out.println(count);
        //Explicitly commit statements to apply changes
        conn.commit();

        if (stmt != null)
            conn.close();
        if (conn != null)
            conn.close();
    }

    //build table
    @Test
    public void buildTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql = "CREATE TABLE sfzinfo " +
                    "(id INTEGER not NULL, " +
                    " _name VARCHAR(255), " +
                    " _sfzid VARCHAR(255), " +
                    " _age INTEGER, " +
                    " _location VARCHAR(255), " +
                    " _sex VARCHAR(255) ," +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    /**
     * using statement
     * @param sfzArrayList
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void batch(ArrayList<SFZ> sfzArrayList) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement stmt = conn.createStatement();

        // Set auto-commit to false
        conn.setAutoCommit(false);

        for (SFZ sfz:sfzArrayList) {
            //"INSERT INTO sfzinfo VALUES (null,'ander','123123123123',36,'阿斯顿','男')";
            String sql1 = "INSERT INTO sfzinfo VALUES (null,'"+sfz.getName()+"','"+sfz.getId()+"',"+sfz.getAge()+",'"+sfz.getLocation()+"','"+sfz.getSex()+"')";
            stmt.addBatch(sql1);
        }

        // Create an int[] to hold returned values
        int[] count = stmt.executeBatch();
        System.out.println(count+" size id add complete.");
        //Explicitly commit statements to apply changes
        conn.commit();

        if (stmt != null)
            conn.close();
        if (conn != null)
            conn.close();
    }

    /**
     * using preparestatement
     * @param sfzArrayList
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void batchPre(ArrayList<SFZ> sfzArrayList) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        String presql="INSERT INTO sfzinfo VALUES (null,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(presql);


        // Set auto-commit to false
        conn.setAutoCommit(false);

        for (SFZ sfz:sfzArrayList) {
            //"INSERT INTO sfzinfo VALUES (null,'ander','123123123123',36,'阿斯顿','男')";
            stmt.setString(1,sfz.getName());
            stmt.setString(2,sfz.getId());
            stmt.setInt(3,sfz.getAge());
            stmt.setString(4,sfz.getLocation());
            stmt.setString(5,sfz.getSex());
            stmt.addBatch();
        }

        // Create an int[] to hold returned values
        int[] count = stmt.executeBatch();
        System.out.println(count+" size id add complete.");
        //Explicitly commit statements to apply changes
        conn.commit();

        if (stmt != null)
            conn.close();
        if (conn != null)
            conn.close();
    }
}