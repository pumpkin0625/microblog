package com.zyn.microblog.dao;

import com.zyn.microblog.usercenter.model.Friend;
import com.zyn.microblog.usercenter.model.User;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
@Sql("classpath:dev/init-schema.sql")
public class FriendDaoTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private FriendDao friendDao;
    private List<Friend> friends;


    @Before
    public void init() {
        List<User> users = ModlesUtils.genUsersWithoutUserId(5);
        users.forEach(userDAO::addUser);
        friends = ModlesUtils.genFriendForUsers(users);
        friends.forEach(friendDao::insertFriend);
    }

    @Test
    public void selectFriendByUserIdAndhasCaredIdTest() {
        List<Friend> selectedFriends = new ArrayList<>();
        friends.forEach(friend -> {
            Friend selected = friendDao.selectFriendByUserIdAndCaredId(friend.getUserId(), friend.getCaredUserId());
            selectedFriends.add(selected);
        });
        assertArrayEquals(friends.toArray(), selectedFriends.toArray());
    }

    @Test
    public void selectUserFansByUserIdTest() {
        List<User> users = new ArrayList<>();
        friends.forEach(friend -> {
            User user = friendDao.selectUserFansByUserId(friend.getUserId()).get(0);
            users.add(user);
        });
        for (int i = 0; i < friends.size(); i++) {
            assertEquals(friends.get(0).getCaredUserId(), users.get(0).getUserId());
        }
    }

    @Test
    public void deleteFriendByUserIdAndCaredUserIdTest() {
        friends.forEach(friend ->
                friendDao.deleteFriendByUserIdAndCaredUserId(friend.getUserId(), friend.getCaredUserId()));
    }

}
