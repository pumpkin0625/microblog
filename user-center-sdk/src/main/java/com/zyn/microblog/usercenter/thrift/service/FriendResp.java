package com.zyn.microblog.usercenter.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.zyn.microblog.common.thrift.Error;
import com.zyn.microblog.usercenter.thrift.dto.FriendDTO;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@ThriftStruct
public class FriendResp {
    private boolean success;
    private Error error;
    private FriendDTO friend;

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
    public FriendDTO getFriendDTO() {
        return friend;
    }

    public void setFriendDTO(FriendDTO friend) {
        this.friend = friend;
    }
}
