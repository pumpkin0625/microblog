package com.zyn.microblog.usercenter.thrift.service;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@ThriftService
public interface UserService {

    @ThriftMethod
    long getUserIdByToken(String token);


}
