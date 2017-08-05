package com.zyn.microblog.model;

import lombok.*;

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
    private Integer hasCared;       //关注状态，0表示careduser是user的分析，1表示相互关注
}