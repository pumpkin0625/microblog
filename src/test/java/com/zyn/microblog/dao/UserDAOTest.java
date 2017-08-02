package com.zyn.microblog.dao;

import com.zyn.microblog.dao.UserDAO;
import com.zyn.microblog.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by zyn on 2017/7/26.
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
@Sql(scripts = "classpath:init-schema.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Before
    public void insetTest() {
        Random random = new Random();
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setUserName(String.format("USER%d", i));
            user.setNickname(String.format("NICKNAME%d", i));
            user.setRealName(String.format("REALNAME%d", i));
            user.setPassword("lsjdhf");
            user.setSalt("zyn");
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png,", random.nextInt(1000)));
            user.setSex("Male");
            user.setEmail(String.format("EMAIL%d", i));
            user.setPhone(String.format("PHONE%d", i));
            user.setAddress("西北工业大学");
            user.setBirthday(new Date());
            user.setIntroduction("hello world");
            userDAO.addUser(user);
            assertEquals(i, user.getUserId());
        }
    }

    @Test
    public void selectByIdTest() {
        assertEquals("USER1", userDAO.selectById(1).getUserName());
    }

    @Test
    public void updateUserTest() {
        User user = userDAO.selectById(1);
        user.setAddress("abc");
        userDAO.updateUser(user);
        assertEquals("abc", userDAO.selectById(1).getAddress());
    }

    @Test
    public void selectByNicknameTest() {
        assertEquals("NICKNAME1", userDAO.selectByNickname("NICKNAME1").getNickname());
    }

    @After
    public void deleteUserById() {
        for (int i = 1; i <= 3; i++) {
            userDAO.deleteByUserId(i);
            assertNull(userDAO.selectById(i));
        }
    }
}