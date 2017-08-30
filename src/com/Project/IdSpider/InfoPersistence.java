package com.Project.IdSpider;

import com.Util.JDBCUtil;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Persistence the info into the mysql
 */
public class InfoPersistence {
public void putListIntoMySQL(ArrayList<SFZ> sfzArrayList) throws SQLException, ClassNotFoundException {
    JDBCUtil jdbcUtil=new JDBCUtil();
    jdbcUtil.batch(sfzArrayList);
}
}
