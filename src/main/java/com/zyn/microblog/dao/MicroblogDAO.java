package com.zyn.microblog.dao;

import com.zyn.microblog.model.Microblog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zyn on 2017/7/28.
 */
@Mapper
public interface MicroblogDAO {
    String TABLE_NAME = " microblog";
    String INSERT_FIELDS = " user_id, created_date, content, like_count, comment_count ";
    String SELECT_FIELDS = " microblog_id," + INSERT_FIELDS;

    //插入一条微博
    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userId},#{createdDate}," +
            "#{content},#{likeCount},#{commentCount})"})
    @Options(keyProperty = "microblogId", useGeneratedKeys = true)
    void addMicroblog(Microblog microblog);

    //查询一条微博
    @Select({"select", SELECT_FIELDS, " from ", TABLE_NAME, "where microblog_id=#{microblogId}"})
    @Results(id = "microblog", value = {
            @Result(id = true, property = "microblogId", column = "microblog_id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "content", column = "content"),
            @Result(property = "likeCount", column = "like_count"),
            @Result(property = "commentCount", column = "comment_count")
    })
    Microblog selectById(int microblogId);

    //TODO: limit分页方式待优化，参考https://my.oschina.net/No5stranger/blog/158202，http://www.cnblogs.com/fjytzh/archive/2010/04/02/1702886.html
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where user_id = #{userId} limit #{offset}, #{limit}"})
    @ResultMap("microblog")
    List<Microblog> selectByUserId(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    //@Update({"update ",TABLE_NAME ,"set comment_count = #{commentCount},"})

}
