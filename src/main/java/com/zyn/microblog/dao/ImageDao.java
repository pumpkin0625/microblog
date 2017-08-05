package com.zyn.microblog.dao;

import com.zyn.microblog.model.Image;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zyn on 2017/8/5.
 */
@Mapper
public interface ImageDao {
    String TABLE_NAME = " image ";
    String INSERT_FIELDS = " image_url,image_server,microblog_id ";
    String SELECT_FIELDS = " image_id," + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{imageUrl},#{imageServer},#{microblogUrl}"})
    void insertImage(Image image);

    //TODO: zyn-2017/08/05, 批量插入
    void insertImages(List<Image> image);

    /**
     * 根据image id查找图片
     *
     * @param imageId 待查找的图片id
     * @return 图片
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where image_id=#{imageId}"})
    //TODO: zyn-2017/08/05, 结果映射
    Image selectImageByImageId(int imageId);

    /**
     * 查找某条微博的所有配图
     *
     * @param microblogId 微博id
     * @return 图片列表
     */
    //TODO: zyn-2017/08/05, 实现批量查询
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where microblog_id=#{microblogId}"})
    List<Image> selectImageByMicroblogId(int microblogId);

    /**
     * 根据用户id查询其图片列表
     *
     * @param userId 要查询的用户id
     * @param offset 偏移量
     * @param limit  选取量
     * @return
     */
    //TODO: zyn-2017/08/05, 查询一个用户的所有图片
    List<Image> selectImagesByUserId(int userId, int offset, int limit);

    @Delete({"delete from", TABLE_NAME, "where image_id=#{imageId}"})
    void deleteByImageId(int imageId);

    //TODO: zyn-2017/08/05, 批量删除
    @Delete({"delete from", TABLE_NAME, "where microblog_id=#{microblogId}"})
    void deleteImagesByMircoblog(int microblogId);
}
