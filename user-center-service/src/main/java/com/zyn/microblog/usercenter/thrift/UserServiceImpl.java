package com.zyn.microblog.usercenter.thrift;

import com.zyn.microblog.usercenter.thrift.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zyn
 * Created on 2017/9/4.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public long getUserIdByToken(String token) {
        return 0;
    }
}
