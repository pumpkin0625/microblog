package com.zyn.microblog.dao;

import com.zyn.microblog.usercenter.model.Conversation;
import com.zyn.microblog.usercenter.model.Message;
import com.zyn.microblog.usercenter.model.User;
import lombok.val;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author zyn
 * Created on 2017/8/13.
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
@Sql("classpath:dev/init-schema.sql")
public class MessageDaoTest {
    @Autowired
    private ConversationDAO cvstDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDAO userDAO;

    private List<User> users;
    private List<Conversation> conversations;
    private List<Message> messages;

    public void setUp() throws Exception {
        users = ModlesUtils.genUsersWithoutUserId(6);
        users.forEach(userDAO::addUser);
        conversations = ModlesUtils.genConversations(users);
        conversations.forEach(cvstDao::insertCvst);
        messages = ModlesUtils.genMessages(conversations);
    }

    @Test
    public void insertMessage() throws Exception {
        setUp();
        messages.forEach(messageDao::insertMessage);
    }

    @Test
    public void selectMessageByMessageId() throws Exception {
        setUp();
        messages.forEach(messageDao::insertMessage);
        val message = messageDao.selectMessageByMessageId(1);
        assertNotNull(message);
    }

    @Test
    public void selectMesagesByConversationId() throws Exception {
        setUp();
        messages.forEach(messageDao::insertMessage);
        List<Message> messages = messageDao.selectMesagesByConversationId(1, 0, Integer.MAX_VALUE);
        assertEquals(2, messages.size());
    }

}