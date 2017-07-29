package com.zyn.microblog.dao;

import com.zyn.microblog.model.LoginTicket;
import com.zyn.microblog.model.Microblog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zyn on 2017/7/28.
 */
public interface MicroblogDAO {
    String TABLE_NAME = " microblog";
    String INSERT_FIELDS = " user_id, created_date, content, like_count, comment_count ";
    String SELECT_FIELDS = " microblog_id,"+ INSERT_FIELDS;

    //插入一条微博
    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values (#{userId},#{createdDate}," +
            "#{content},#{likeCount},#{commentCount})"})
    int addMicroblog(Microblog microblog);

    //查询一条微博
    @Select({"select",SELECT_FIELDS," from ",TABLE_NAME, "where microblog_id=#{microblogId}"})
    Microblog getByMicroblogId(int microblogId);

    //@Update({"update ",TABLE_NAME ,"set comment_count = #{commentCount},"})





}
