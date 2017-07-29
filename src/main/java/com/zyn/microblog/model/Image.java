package com.zyn.microblog.model;

/**
 * Created by zyn on 2017/7/26.
 */
public class Image {
    private int imageId;
    private String imageUrl;
    private String imageServer;
    private int microblogId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public int getMicroblogId() {
        return microblogId;
    }

    public void setMicroblogId(int microblogId) {
        this.microblogId = microblogId;
    }


}
