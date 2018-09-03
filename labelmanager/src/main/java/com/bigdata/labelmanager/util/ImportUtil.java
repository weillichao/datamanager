package com.bigdata.labelmanager.util;

import com.bigdata.labelmanager.domain.Condition;
import com.bigdata.labelmanager.domain.ImportResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportUtil {
    private static final String driverClass = "com.mysql.jdbc.Driver";
    private static final String jdbcUrl = "jdbc:mysql://192.168.1.18:3306/bigdata?useUnicode=true&characterEncoding=utf8";
    private static final String user = "root";
    private static final String password = "Sczq@1234!";
    private static Gson gson =new GsonBuilder().serializeNulls().create();

    public static Connection getConn(String url, String user, String passward) {
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
            //   conn.setAutoCommit(false);
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

    public static List<ImportResult> find(String date) {
        List<ImportResult> listName=new ArrayList<ImportResult>();
        Connection conn = DBUtil.getConn(jdbcUrl,user,password);
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;


        String sql = "select * from import_result where date='"+date+"'";

        //  Student student = null;

        // sql=sql+cd;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            // pstmt =conn.prepareStatement()
            //  pstmt.setInt(1, id);
            resultSet = pstmt.executeQuery();


            while (resultSet.next()) {
                //   System.out.println("sss");
                ImportResult ss=new ImportResult();
                ss.setTablename(resultSet.getString(1));
                ss.setDate(resultSet.getString(2));
                ss.setStart_time(resultSet.getString(3));
                ss.setEnd_time(resultSet.getString(4));
                ss.setResult(resultSet.getString(5));

                listName.add(ss);
            }




        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }
        return  listName;
    }
}
