package com.zyn.microblog.dao;

import com.zyn.microblog.model.Friend;
import com.zyn.microblog.model.Image;
import com.zyn.microblog.model.Microblog;
import com.zyn.microblog.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by zyn on 2017/8/5.
 */
class ModlesUtils {
    /**
     * 生成n个user
     *
     * @param n 要生成的user数量
     * @return user list
     */
    static List<User> genUsersWithoutUserId(int n) {
        List<User> users = new ArrayList<>(n);
        Random random = new Random();
        for (int i = 1; i <= n; i++) {
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
            users.add(user);
        }
        return users;
    }

    /**
     * 为每个user生成一个粉丝，粉丝必须是已经存在的user
     *
     * @param users
     * @return 粉丝列表
     */
    static List<Friend> genFriendForUsers(List<User> users) {
        List<Friend> friends = new ArrayList<>(users.size());
        for (int i = 0; i < users.size(); i++) {
            Friend friend = new Friend();
            friend.setUserId(users.get(i).getUserId());
            friend.setCaredUserId(users.get((i + 1) % users.size()).getUserId());
            friend.setHasCared(0);
            friends.add(friend);
        }
        return friends;
    }

    /**
     * 为每个用户生成一条微博
     *
     * @param users
     * @return
     */
    static List<Microblog> genMicroblogs(List<User> users) {
        List<Microblog> microblogs = new ArrayList<>(users.size());
        users.forEach(user -> {
            Microblog microblog = new Microblog();
            microblog.setUserId(user.getUserId());
            microblog.setCreatedDate(new Date());
            microblog.setLikeCount(0);
            microblog.setCommentCount(0);
            microblog.setContent("user" + user.getUserId() + " : 第一条微博");
            microblogs.add(microblog);
        });
        return microblogs;
    }

    /**
     * 为每条微博配一个图片
     *
     * @param microblogs 待配图的微博
     * @return 图片列表
     */
    static List<Image> genImages(List<Microblog> microblogs) {
        List<Image> images = new ArrayList<>(microblogs.size());
        microblogs.forEach(microblog -> {
            Image image = new Image();
            image.setImageServer("12.23.34.45");
            image.setImageUrl("/img/" + microblog.getMicroblogId() + ".jpg");
            image.setMicroblogId(microblog.getMicroblogId());
        });
        return images;
    }
}