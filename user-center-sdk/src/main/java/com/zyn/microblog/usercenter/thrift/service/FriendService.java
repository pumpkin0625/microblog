package com.zyn.microblog.usercenter.thrift.service;

import com.facebook.swift.service.ThriftService;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@ThriftService
public interface FriendService {
    /**
     * 根据userId获取其所有的粉丝
     *
     * @param userId 要查询粉丝的用户
     * @param offset
     * @param limit
     * @return 如果查询成功，返回friends且success为true；否则success为false。
     */
    FriendsResp getFriendByUserId(long userId, int offset, int limit);

    /**
     * @param caredUserId
     * @return
     */
    FriendResp getFriendByCaredUserId(long caredUserId);


}
