package com.zyn.microblog.usercenter.thrift.dto;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import lombok.ToString;

import java.util.Date;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@ToString
@ThriftStruct
public class UserModelDTO {
    private Integer userId;
    private String userName;
    private String nickname;
    private String realName;
    private String headUrl;
    private String sex;
    private String email;
    private String phone;
    private String address;
    private Date birthday;
    private String introduction;

    @ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ThriftField(value = 2, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ThriftField(value = 3, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @ThriftField(value = 4, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getRealName() {
        return realName;
    }

    @ThriftField(value = 5, requiredness = ThriftField.Requiredness.REQUIRED)
    public void setRealName(String realName) {
        this.realName = realName;
    }


    @ThriftField(value = 6, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    @ThriftField(value = 7, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @ThriftField(value = 8, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ThriftField(value = 9, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ThriftField(value = 10, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ThriftField(value = 11, requiredness = ThriftField.Requiredness.REQUIRED)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @ThriftField(value = 12, requiredness = ThriftField.Requiredness.REQUIRED)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
