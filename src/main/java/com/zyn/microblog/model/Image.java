package com.zyn.microblog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by zyn on 2017/7/26.
 */
@Setter
@Getter
@ToString
public class Image {
    private int imageId;
    private String imageUrl;
    private String imageServer;
    private Integer microblogId;
}
