package com.zyn.microblog.common.thrift;

import com.facebook.swift.codec.ThriftField;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
public class Error {
    private int code;
    private int level;
    private String type;
    private String message;

    @ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @ThriftField(value = 2, requiredness = ThriftField.Requiredness.REQUIRED)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @ThriftField(value = 3, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ThriftField(value = 4, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
