package com.Project.IdSpider;

import com.Util.JDBCUtil;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * Persistence the info into the mysql
 */
public class InfoPersistence {

    ////////////////////////////////////////////////////////
    /////////////////////refactor///////////////////////////
    ////////////////////////////////////////////////////////
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    //connect to mysql server

    /**
     * connect to the mysql server
     */
    private void connectMySQL() {
        connection = JDBCUtil.getMySQLConn();
    }

    /**
     * insert record
     * fast but can't defend SQL explode
     *
     * @param sfz
     */
    public void insertUsingStatement(SFZ sfz) {
        connectMySQL();
        try {
            statement = connection.createStatement();
            String sql = "INSERT INTO sfzinfo VALUES (" +
                    "null,'"
                    + sfz.getName() + "','"
                    + sfz.getId() + "',"
                    + sfz.getAge() + ",'"
                    + sfz.getLocation() + "','"
                    + sfz.getSex() + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(resultSet, statement, connection);
        }
    }

    /**
     * insert record
     * in case of SQL explode but slow
     *
     * @param sfz
     */
    private void insertUsingPreStatement(SFZ sfz) {
        connectMySQL();
        try {
            String sql = "INSERT INTO sfzinfo VALUES (null,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sfz.getName());
            preparedStatement.setString(2, sfz.getId());
            preparedStatement.setInt(3, sfz.getAge());
            preparedStatement.setString(4, sfz.getLocation());
            preparedStatement.setString(5, sfz.getSex());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(resultSet, statement, connection);
        }
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


    /**
     * batch insert data
     * using statement for speed
     *
     * @param sfzList
     */
    public void batch(ArrayList<SFZ> sfzList) {
        connectMySQL();
        try {
            // Set auto-commit to false
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            for (SFZ sfz : sfzList) {
                String sql = "INSERT INTO sfzinfo VALUES (" +
                        "null,'"
                        + sfz.getName() + "','"
                        + sfz.getId() + "',"
                        + sfz.getAge() + ",'"
                        + sfz.getLocation() + "','"
                        + sfz.getSex() + "')";
                statement.addBatch(sql);
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(resultSet, statement, connection);
        }

    }

    //build table
    public void buildTable() {
        connectMySQL();
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE sfzinfo " +
                    "(id INTEGER not NULL, " +
                    " _name VARCHAR(255), " +
                    " _sfzid VARCHAR(255), " +
                    " _age INTEGER, " +
                    " _location VARCHAR(255), " +
                    " _sex VARCHAR(255) ," +
                    " PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            JDBCUtil.closeConn(resultSet, statement, connection);
        }
    }

    /**
     * using preparestatement batch
     * in order to prevent sql explod
     *
     * @param sfzArrayList
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void batchPre(ArrayList<SFZ> sfzArrayList) throws ClassNotFoundException, SQLException {
        connectMySQL();
        try {
            // Set auto-commit to false
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("INSERT INTO sfzinfo VALUES (null,?,?,?,?,?)");
            for (SFZ sfz : sfzArrayList) {
                preparedStatement.setString(1, sfz.getName());
                preparedStatement.setString(2, sfz.getId());
                preparedStatement.setInt(3, sfz.getAge());
                preparedStatement.setString(4, sfz.getLocation());
                preparedStatement.setString(5, sfz.getSex());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(resultSet, statement, connection);
        }
    }
}
