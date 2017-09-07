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

    /**
     * 使用当前行数与页面的每页数量生成对应的每页的行数范围
     * ex：
     * 1000行/10行=100页
     * 第i页包含第i项到第i+10项
     *
     * 递推
     * sum/page_size=page_number
     * i->i~i+page_size
     *
     * 问题简化为：如何在数据库中检索第i项到第i+offset项
     */

    /**
     * 获取某一页的结果集
     * @param pageNumber 页码
     * @param pageSize 页面大小
     * @return
     */
    public ResultSet getPage(int pageNumber,int pageSize){
        ResultSet result=null;
        connection=JDBCUtil.getMySQLConn();
        try {
            //SELECT * FROM table LIMIT 5,10;  // 检索记录行 6-15
            statement=connection.createStatement();
            //计算对应的行数
            int sline=pageNumber*pageSize;
            String sql="SELECT * FROM sfzinfo LIMIT "+sline+","+pageSize+";";
            resultSet=statement.executeQuery(sql);
            result=resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(resultSet,statement,connection);
        }
        return result;
    }

    @Test
    public void get(){
        System.out.println("======================================"+getRowNum());
    }
}
