package com.zyn.microblog.dao;

import com.zyn.microblog.model.Comment;
import com.zyn.microblog.model.Microblog;
import com.zyn.microblog.model.User;
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
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
public class CommentDaoTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private MicroblogDAO microblogDAO;
    @Autowired
    private CommentDao commentDao;

    @Sql("classpath:init-schema.sql")
    @Test
    public void init() {
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
        }
        Microblog microblog = new Microblog();
        microblog.setUserId(1);
        microblog.setCreatedDate(new Date());
        microblog.setLikeCount(5);
        microblog.setCommentCount(2);
        microblog.setContent("第一条微博");
        microblogDAO.addMicroblog(microblog);
    }

    @Test
    public void addCommentTest() {
        Comment comment = new Comment();
        comment.setContent("第一条评论");
        comment.setCreatedDate(new Date());
        comment.setEntityId(1);
        comment.setEntityType(0);
        comment.setMicroblogId(1);
        comment.setUserId(1);
        comment.setStatus(0);
        commentDao.addComment(comment);
        assertEquals(1, comment.getCommentId());
    }

    @Test
    public void selectCommentByCommentId() {
        Comment comment = commentDao.selectCommentByCommentId(1);
        assertNotNull(comment);
    }

    @Test
    public void selectCommentByMicroblogId() {
        List<Comment> comments = commentDao.selectCommentByMicroblogId(1);
        assertEquals(1, comments.size());
    }

    @Test
    public void deleteCommentByMicroblogId() {
        commentDao.deleteCommentsByMicroblogId(1);
        assertEquals(0, commentDao.selectCommentByMicroblogId(1).size());
    }

    @Test
    public void deleteCommentByCommentId() {
        Microblog microblog = new Microblog();
        microblog.setUserId(1);
        microblog.setCreatedDate(new Date());
        microblog.setLikeCount(5);
        microblog.setCommentCount(2);
        microblog.setContent("第一条微博");
        microblogDAO.addMicroblog(microblog);
        commentDao.deleteCommentByCommentId(2);
        assertEquals(0, commentDao.selectCommentByMicroblogId(1).size());
    }
}
