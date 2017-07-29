package com.zyn.microblog;

import com.zyn.microblog.dao.UserDAO;
import com.zyn.microblog.dao.UserDAOJDBC;
import com.zyn.microblog.model.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * Created by zyn on 2017/7/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("classpath:init-schema.sql")
public class InitDatabaseTests {
    //JDBC的插入测试
    /*@Test
    public void initData(){
        UserDAOJDBC userDAOJDBC = new UserDAOJDBC();
        User user = new User();
        user.setUserName("lkgkugai");
        user.setNickname("slwhger");
        user.setRealName("zhaoyana");
        user.setPassword("jfhasdfad");
        user.setSalt("asdf");
        user.setHeadUrl("da");
        user.setSex("sex");
        user.setEmail("fjdhsg");
        user.setPhone("1dfheahs");
        userDAOJDBC.insert(user);
    }*/

    @Autowired
    UserDAO userDAO;
    @Test
    public void initData(){
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName(String.format("USER%d",i));
            user.setNickname(String.format("NICKNAME%d",i));
            user.setRealName(String.format("REALNAME%d",i));
            user.setPassword("lsjdhf");
            user.setSalt("zyn");
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png,",random.nextInt(1000)));
            user.setSex("Male");
            user.setEmail(String.format("EMAIL%d",i));
            user.setPhone(String.format("PHONE%d",i));
            user.setAddress("西北工业大学");
            user.setBirthday(new Date());
            user.setIntroduction("hello world");
            userDAO.addUser(user);
        }

        Assert.assertNotNull(userDAO.selectById(1));

    }

}
