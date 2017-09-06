package com.zyn.microblog.dao;

import com.google.common.collect.Lists;
import com.zyn.microblog.model.*;
import lombok.val;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 测试工具类，生成模拟的model
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

    /**
     * 给相邻的user对创建会话
     *
     * @param users 模拟的用户列表
     * @return users.size / 2数量的会话，fromuserid为user.id,touserid为(user+1).id
     */
    static List<Conversation> genConversations(List<User> users) {
        List<Conversation> cvsts = Lists.newArrayList();
        for (int i = 0; i < users.size(); i += 2) {
            Conversation cvst = new Conversation();
            cvst.setFromUserId(users.get(i).getUserId());
            cvst.setToUserId(users.get(i + 1).getUserId());
            cvst.setDeleteMark(0);
            cvst.setType(0);
            cvst.setCreatedDate(new Date());
            cvsts.add(cvst);
        }
        return cvsts;
    }

    /**
     * @param cvsts
     * @return
     */
    static List<Message> genMessages(List<Conversation> cvsts) {
        List<Message> messages = Lists.newArrayList();
        for (int i = 0; i < 2; i++) {
            for (val cvst : cvsts) {
                Message message = new Message();
                message.setSenderId(cvst.getFromUserId());
                message.setReceiverId(cvst.getToUserId());
                message.setConversationId(cvst.getConversationId());
                message.setCreatedDate(new Date());
                message.setHasRead(0);
                message.setContent("message");
                messages.add(message);
            }
        }
        return messages;
    }
}