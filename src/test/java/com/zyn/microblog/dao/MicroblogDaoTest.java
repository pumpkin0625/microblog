package com.zyn.microblog.dao;

import com.zyn.microblog.usercenter.model.Microblog;
import com.zyn.microblog.usercenter.model.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  //按照方法定义的顺序进行测试
@SpringBootTest
public class MicroblogDaoTest {

    @Autowired
    private MicroblogDAO microblogDAO;
    @Autowired
    private UserDAO userDAO;

    //TODO: 为什么把Sql放到类前面，每个方法都要执行一次sql语句， 放到方法前面，仅仅当前方法执行。
    @Sql(value = "classpath:dev/init-schema.sql")
    @Test
    public void init() {
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setUserName(String.format("USER%d", i));
            user.setNickname(String.format("NICKNAME%d", i));
            user.setRealName(String.format("REALNAME%d", i));
            user.setPassword("lsjdhf");
            user.setSalt("zyn");
            user.setHeadUrl("http://images.nowcoder.com/head/dt.png");
            user.setSex("Male");
            user.setEmail(String.format("EMAIL%d", i));
            user.setPhone(String.format("PHONE%d", i));
            user.setAddress("西北工业大学");
            user.setBirthday(new Date());
            user.setIntroduction("hello world");
            userDAO.addUser(user);
        }
    }

    @Test
    public void insertTest() {
        Microblog microblog = new Microblog();
        microblog.setUserId(1);
        microblog.setCreatedDate(new Date());
        microblog.setLikeCount(5);
        microblog.setCommentCount(2);
        microblog.setContent("第一条微博");
        microblogDAO.addMicroblog(microblog);
        assertEquals(1, microblog.getMicroblogId());
    }

    @Test
    public void selectBlogById() {
        Microblog microblog = microblogDAO.selectById(1);
        assertEquals("第一条微博", microblog.getContent());
    }

    @Test
    public void selectBlogByUserId() {
        List<Microblog> microblogs = microblogDAO.selectByUserId(1, 0, 10);
        assertEquals(1, microblogs.size());
    }
}
