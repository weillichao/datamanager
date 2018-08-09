package com.bigdata.datamanager.util;

import com.bigdata.datamanager.domain.FieldManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/***
 * HIVE工具类，获取HIVE元数据信息
 *
 */
public class HiveMetaDataUtil {

    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.202.47:3306/hive";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public static List<FieldManager> getHiveMetadata(String tablename) {
        Connection conn = getConn();
        List<FieldManager> list=new ArrayList<FieldManager>();
        String sql = "SELECT t.COLUMN_NAME,t.TYPE_NAME FROM TBLS s,COLUMNS_V2 t,SDS m where s.SD_ID=m.SD_ID AND t.CD_ID=m.CD_ID AND s.TBL_NAME='"+tablename+"'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                FieldManager manager=new FieldManager();
                manager.setField_name(rs.getString("COLUMN_NAME"));
                manager.setField_type(rs.getString("TYPE_NAME"));
                list.add(manager);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
