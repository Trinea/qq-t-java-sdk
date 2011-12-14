package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博视频信息
 * 
 * @author Trinea 2011-11-2 下午11:10:47
 */
public class QqTVideoInfo implements Serializable {

    private static final long serialVersionUID = 1867062995454017877L;

    /** 视频小图片地址 **/
    private String            miniPicUrl;
    /** 播放器地址 **/
    private String            playerUrl;
    /** 视频实际地址 **/
    private String            realUrl;
    /** 视频短url **/
    private String            shortUrl;
    /** 视频标题 **/
    private String            title;

    public String getMiniPicUrl() {
        return miniPicUrl;
    }

    public void setMiniPicUrl(String miniPicUrl) {
        this.miniPicUrl = miniPicUrl;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public void setPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
