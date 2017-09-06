//package com.zyn.microblog.dao;
//
//import com.zyn.microblog.model.User;
//import com.zyn.microblog.util.DBUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
///**
// * Created by zyn on 2017/7/26.
// */
//public class UserDAOJDBC {
//
//
//    private String inserteUserSql = "insert into user " +
//            "(user_name,nickname,real_name,password,salt,head_url,sex,email,phone,address,birthday,introduction) " +
//            "values(?,?,?,?,?,?,?,?,?,?,?,?)";
//    public void insert(User user) {
//        Connection conn = DBUtil.getConn();
//        PreparedStatement pst = null;
//        try {
//            pst = conn.prepareStatement(inserteUserSql);
//            pst.setString(1, user.getUserName());
//            pst.setString(2, user.getNickname());
//            pst.setString(3, user.getRealName());
//            pst.setString(4,user.getPassword());
//            pst.setString(5,user.getSalt());
//            pst.setString(6,user.getHeadUrl());
//            pst.setString(7,user.getSex());
//            pst.setString(8,user.getEmail());
//            pst.setString(9,user.getPhone());
//            pst.setString(10, null);
//            pst.setString(11,null);
//            pst.setString(12,null);
//            //pst.setString(13,null);
//            //pst.setString(11,user.getAddress());
//            pst.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.close(conn, pst, null);
//        }
//
//    }
//}
