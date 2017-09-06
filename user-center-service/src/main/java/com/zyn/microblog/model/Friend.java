package com.zyn.microblog.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Friend {
    private Integer userId;         //被关注者
    private Integer caredUserId;    //user的粉丝，关注者
    private Integer hasCared;       //关注状态，0表示careduser是user的粉丝，1表示相互关注
}