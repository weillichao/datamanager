package com.bigdata.datamanager.util;

import com.bigdata.datamanager.domain.DatabaseManager;
import com.bigdata.datamanager.domain.FieldManager;
import com.bigdata.datamanager.domain.SystemManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***
 * 数据库工具类，通过数据库获取元数据
 *
 */
public class DBUtil {


    private static final String driverClass = "oracle.jdbc.driver.OracleDriver";



    public static Connection getConn(String url,String user,String passward) {
        // 1.注册驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2.创建Connection(数据库连接对象)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passward);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*
         * Connection是Statement的工厂，一个Connection可以生产多个Statement。
         * Statement是ResultSet的工厂，一个Statement却只能对应一个ResultSet（它们是一一对应的关系）。
         * 所以在一段程序里要用多个ResultSet的时候，必须再Connection中获得多个Statement，然后一个Statement对应一个ResultSet。
         */
        return null;
    }

    /**
     * 关闭编译的 SQL 语句的对象
     * @param stmt
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集
     * @param rs
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接(数据库连接对象)
     * @param conn
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        /**
         * 查找
         * @param tablename
         * @return
         */
    public static List<FieldManager> find(DatabaseManager datasource, String tablename,String sourceName) {
        List<FieldManager> list=new ArrayList<FieldManager>();
        Connection conn = DBUtil.getConn(datasource.getUrl(),datasource.getUsername(),datasource.getPassword());
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        String sql = "select * from all_tab_columns where TABLE_NAME='"+tablename+"' AND OWNER='"+sourceName+"'";

        try {
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
                while (resultSet.next()) {
                    FieldManager manager=new FieldManager();
                    String data_type = resultSet.getString("DATA_TYPE");
                    String data_name = resultSet.getString("COLUMN_NAME");
                    String data_length = resultSet.getString("DATA_LENGTH");
                    manager.setField_name(data_name);
                    manager.setField_type(data_type);
                    manager.setField_length(data_length );
                    list.add(manager);//System.out.println(name);
                }

    } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }
        return list;
    }



}
