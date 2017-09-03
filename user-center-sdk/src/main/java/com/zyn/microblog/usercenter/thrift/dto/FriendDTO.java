package com.zyn.microblog.usercenter.thrift.dto;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.zookeeper.server.Request;

/**
 * @author zyn
 * Created on 2017/9/3.
 */
@NoArgsConstructor
@AllArgsConstructor
@ThriftStruct
public class FriendDTO {
    private Integer userId;         //被关注者
    private Integer caredUserId;    //user的粉丝，关注者
    private Integer hasCared;       //关注状态，0表示careduser是user的分析，1表示相互关注


    @ThriftField(value = 1, requiredness = ThriftField.Requiredness.REQUIRED)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ThriftField(value = 2, requiredness = ThriftField.Requiredness.REQUIRED)
    public Integer getCaredUserId() {
        return caredUserId;
    }

    public void setCaredUserId(Integer caredUserId) {
        this.caredUserId = caredUserId;
    }

    @ThriftField(value = 3, requiredness = ThriftField.Requiredness.REQUIRED)
    public Integer getHasCared() {
        return hasCared;
    }

    public void setHasCared(Integer hasCared) {
        this.hasCared = hasCared;
    }
}
