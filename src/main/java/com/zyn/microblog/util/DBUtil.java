package com.zyn.microblog.util;

import java.sql.*;

/**
 * Created by zyn on 2017/7/26.
 */
//jdbc连接数据库和关闭数据库
public class DBUtil {

    private static String driver = "com.mysql.jdbc.Driver";                   //驱动名称
    private static String url = "jdbc:mysql://123.206.227.84/microblog";     //连接数据库地址
    private static String user = "zynsql";                                      //用户名
    private static String password = "sunshine*_0625";                         //密码

    public static Connection conn = null;            //连接对象
    public static PreparedStatement pst = null;     //语句对象
    private ResultSet rs = null;              //结果集对象


    public static Connection getConn() {
        try{
            Class.forName(driver);             //指定连接类型
            conn = DriverManager.getConnection(url, user ,password);    //获取连接
            return conn;
            //pst = conn.prepareStatement(sql);                            //准备执行语句
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void close(Connection conn, PreparedStatement pst, ResultSet rs){
            try {
                if(rs!=null)
                    rs.close();
                if(pst!=null)
                    pst.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}
