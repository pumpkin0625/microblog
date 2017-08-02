package com.zyn.microblog.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * 粉丝关注
 * Created by zyn on 2017/7/28.
 */
@Mapper
public class FriendDao {
    String TABLE_NAME = " friend ";
    String INSERT_FIELDS = " cared_user_id, has_cared ";
    String SELECT_FIELDS = " user_id," + INSERT_FIELDS;
    
}
