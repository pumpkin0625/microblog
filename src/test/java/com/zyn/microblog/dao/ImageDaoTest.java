package com.zyn.microblog.dao;

import com.zyn.microblog.model.Image;
import com.zyn.microblog.model.Microblog;
import com.zyn.microblog.model.User;
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
import java.util.stream.Collectors;

/**
 * Created by zyn on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)  //按照方法定义的顺序进行测试
@SpringBootTest
@Sql("classpath:dev/init-schema.sql")
public class ImageDaoTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private MicroblogDAO microblogDAO;
    @Autowired
    private ImageDao imageDao;

    private List<User> users;
    private List<Microblog> microblogs;
    private List<Image> images;

    @Before
    public void init() {
        users = ModlesUtils.genUsersWithoutUserId(5);
        microblogs = ModlesUtils.genMicroblogs(users);
        images = ModlesUtils.genImages(microblogs);
    }

    @Test
    public void insertTest() {
        imageDao.insertImage(images.get(0));
    }

    @Test
    void insertAll() {
        imageDao.insertImages(images.stream().skip(1).collect(Collectors.toList()));
    }


}
