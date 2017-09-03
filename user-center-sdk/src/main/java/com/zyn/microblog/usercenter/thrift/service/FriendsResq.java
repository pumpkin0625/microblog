package com.zyn.microblog.usercenter.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.zyn.microblog.common.thrift.Error;
import com.zyn.microblog.usercenter.thrift.dto.FriendDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zyn
 * Created on 2017/9/4.
 */
@AllArgsConstructor
@NoArgsConstructor
public class FriendsResq {
    private boolean success;
    private Error error;
    private List<FriendDTO> friend;

    @ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED)
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @ThriftField(value = 2, requiredness = ThriftField.Requiredness.REQUIRED)
    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @ThriftField(value = 3, requiredness = ThriftField.Requiredness.REQUIRED)
    public List<FriendDTO> getFriend() {
        return friend;
    }

    public void setFriend(List<FriendDTO> friend) {
        this.friend = friend;
    }
}
