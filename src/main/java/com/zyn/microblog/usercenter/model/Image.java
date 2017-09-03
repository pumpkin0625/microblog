package com.zyn.microblog.usercenter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微博配图，每个微博最多有九张图
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Image {
    private int imageId;        //图片id
    private String imageUrl;    //图片链接或图片名
    private String imageServer; //图片所位于的服务器
    private Integer microblogId;//图片所属于的微博id
}
