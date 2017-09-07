package com.Project.Pagination;

import com.Util.JDBCUtil;
import org.junit.Test;

import java.sql.*;

/**
 * edited by AndersonKim
 * at 2017/9/6
 */
public class Alpha {
    /**
     * 使用如下方法实现分页：
     * 1.获取当前数据表的行数
     * 2.根据分页的条件对总体数据进行处理
     */

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    /**
     * 获取当前表的行数
     * @return
     */
    public int getRowNum(){
        int result=-1;
       connection=JDBCUtil.getMySQLConn();
        try {

            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String sql="select * from sfzinfo";
            resultSet=statement.executeQuery(sql);
            resultSet.last();
            result=resultSet.getRow();//获得ResultSet的总行数
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(resultSet,statement,connection);
        }
        return result;
    }


    public void initialPage(){

    }

    @Test
    public void get(){
        System.out.println("======================================"+getRowNum());
    }
}
