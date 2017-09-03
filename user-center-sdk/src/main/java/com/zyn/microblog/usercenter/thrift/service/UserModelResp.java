package com.zyn.microblog.usercenter.thrift.service;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.zyn.microblog.common.thrift.Error;
import com.zyn.microblog.usercenter.thrift.dto.UserModelDTO;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@ThriftStruct
public class UserModelResp {
    private boolean success;
    private Error error;
    private UserModelDTO user;

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
    public UserModelDTO getUser() {
        return user;
    }

    public void setUser(UserModelDTO user) {
        this.user = user;
    }
}
