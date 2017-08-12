package com.zyn.microblog.dao;

import com.zyn.microblog.model.Conversation;
import com.zyn.microblog.model.User;
import lombok.val;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zyn on 2017/8/13.
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
@Sql("classpath:init-schema.sql")
public class ConversationDAOTest {

    @Autowired
    private ConversationDAO cvstDao;
    @Autowired
    private UserDAO userDAO;
    private List<Conversation> conversations;
    private List<User> users;

    @Before
    public void setUp() throws Exception {
        users = ModlesUtils.genUsersWithoutUserId(4);
    }

    @Test
    public void insertCvst() throws Exception {
        users.forEach(userDAO::addUser);
        conversations = ModlesUtils.genConversations(users);
        conversations.forEach(cvstDao::insertCvst);
    }

    @Test
    public void selectCvstByFromUserId() throws Exception {
        insertCvst();
        val cvst = cvstDao.selectCvstByFromUserId(users.get(0).getUserId(), 0, Integer.MAX_VALUE);
        assertEquals(conversations.get(0), cvst);
    }

    @Test
    public void selectCvstByCvstId() throws Exception {
        users.forEach(userDAO::addUser);
        val cvst = cvstDao.selectCvstByFromUserId(conversations.get(0).getConversationId(), 0, Integer.MAX_VALUE);
        assertEquals(conversations.get(0), cvst);
    }

    @Test
    public void selectCvstByToUserId() throws Exception {
        users.forEach(userDAO::addUser);
        val cvst = cvstDao.selectCvstByToUserId(users.get(1).getUserId(), 0, Integer.MAX_VALUE);
        assertEquals(conversations.get(0), cvst);
    }

    @Test
    public void selectCvstByFromToUserId() throws Exception {
        users.forEach(userDAO::addUser);
        val cvst = cvstDao.selectCvstByFromUserId(conversations.get(0).getConversationId(), 0, Integer.MAX_VALUE);
        assertEquals(conversations.get(0), cvst);
    }

    @Test
    public void deleteCvstByCvstId() throws Exception {
        users.forEach(userDAO::addUser);
        cvstDao.deleteCvstByCvstId(1);
        assertNull(cvstDao.selectCvstByCvstId(1));
    }

}