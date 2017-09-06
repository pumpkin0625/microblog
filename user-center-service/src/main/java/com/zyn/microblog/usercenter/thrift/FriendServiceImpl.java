package com.zyn.microblog.usercenter.thrift;

import com.zyn.microblog.dao.FriendDao;
import com.zyn.microblog.model.Friend;
import com.zyn.microblog.usercenter.thrift.dto.FriendDTO;
import com.zyn.microblog.usercenter.thrift.service.FriendResp;
import com.zyn.microblog.usercenter.thrift.service.FriendService;
import com.zyn.microblog.usercenter.thrift.service.FriendsResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyn
 * Created on 2017/9/4.
 */
@Service
@Slf4j
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendDao friendDao;

    @Override
    public FriendsResp getFriendByUserId(long userId, int offset, int limit) {
        List<Friend> friends = new ArrayList<>(0);
        try {
            friends = friendDao.selectFriendsByUserId((int) userId, offset, limit);
        } catch (Exception e) {

        }
        List<FriendDTO> friendDTOS = new ArrayList<>(friends.size());
        friends.forEach(friend -> friendDTOS.add(new FriendDTO(
                friend.getUserId(),
                friend.getCaredUserId(),
                friend.getHasCared())));
        return new FriendsResp(true, null, friendDTOS);
    }

    @Override
    public FriendResp getFriendByCaredUserId(long caredUserId) {
        return null;
    }
}
