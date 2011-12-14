package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博信息
 * 
 * @author Trinea 2011-10-8 下午11:45:09
 */
public class QqTStatus implements Serializable {

    private static final long serialVersionUID = -361015223160572717L;

    private QqTUser           user;                                   // 发布人信息
    private long              time;                                   // 发布时间，以秒为单位

    private long              statusId;                               // 内容id
    private String            statusContent;                          // 发布内容，若isForward为true，则表示转发评论
    private String            statusOrigiContent;                     // 发布内容，若isForward为true，则表示转发评论
    /** 1-原创发表、2-转载、3-私信 4-回复 5-空回 6-提及 7-评论 **/
    private int               statusType;                             // 状态类型
    /** 微博状态 0-正常，1-系统删除 2-审核中 3-用户删除 4-根删除 **/
    private int               statusStatus;                           // 状态状态
    private int               commentCount;                           // 评论数目
    private String            sourceType;                             // 来源，如iphone、android、网页

    /** 图片信息 image:["",""] **/
    private boolean           isContainImage;                         // 是否包含图片
    private String[]          imageUrl;                               // 图片列表

    /** video 信息 video:{picurl:""",player:"",realurl:"",shorturl:"",title:""} **/
    private boolean           isContainVideo;                         // 是否包含视频
    private String            videoImageUrl;                          // 视频图片地址
    private String            videoPlayerUrl;                         // 视频播放器地址
    private String            videoActualUrl;                         // 视频实际地址
    private String            videoShortUrl;                          // 视频短地址
    private String            videoTitle;                             // 视频标题

    /** 音频信息　music:{author:"",url:"",title:""} **/
    private boolean           isContainMusic;
    private String            musicAuthor;                            // 演唱者
    private String            musicUrl;                               // 音乐地址
    private String            musicTitle;                             // 歌名

    private int               repostCount;                            // 转发数目
    private boolean           isContainSource;                        // 是否包含原微博，可能是评论、转发等
    private QqTStatus         sourceStatus;                           // 如果isRepost为true，保存原status信息

    private long              colloctNum;                             // 当表示话题时，指被收藏次数
    private long              tweetNum;                               // 当表示话题时，指该话题下微博总数

    public QqTUser getUser() {
        return user;
    }

    public void setUser(QqTUser user) {
        this.user = user;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStatusContent() {
        return statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getStatusOrigiContent() {
        return statusOrigiContent;
    }

    public void setStatusOrigiContent(String statusContent) {
        this.statusOrigiContent = statusContent;
    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    public int getStatusStatus() {
        return statusStatus;
    }

    public void setStatusStatus(int statusStatus) {
        this.statusStatus = statusStatus;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public boolean isContainImage() {
        return isContainImage;
    }

    public void setContainImage(boolean isContainImage) {
        this.isContainImage = isContainImage;
    }

    /**
     * 通过imageUrl数组是否为空判断是否包含图片
     */
    public void setContainImageFromImageUrl() {
        this.isContainImage = (imageUrl != null && imageUrl.length > 0);
    }

    public String[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isContainVideo() {
        return isContainVideo;
    }

    public void setContainVideo(boolean isContainVideo) {
        this.isContainVideo = isContainVideo;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl;
    }

    public String getVideoPlayerUrl() {
        return videoPlayerUrl;
    }

    public void setVideoPlayerUrl(String videoPlayerUrl) {
        this.videoPlayerUrl = videoPlayerUrl;
    }

    public String getVideoActualUrl() {
        return videoActualUrl;
    }

    public void setVideoActualUrl(String videoActualUrl) {
        this.videoActualUrl = videoActualUrl;
    }

    public String getVideoShortUrl() {
        return videoShortUrl;
    }

    public void setVideoShortUrl(String videoShortUrl) {
        this.videoShortUrl = videoShortUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public boolean isContainMusic() {
        return isContainMusic;
    }

    public void setContainMusic(boolean isContainMusic) {
        this.isContainMusic = isContainMusic;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public boolean isContainSource() {
        return isContainSource;
    }

    public void setContainSource(boolean isRepost) {
        this.isContainSource = isRepost;
    }

    public int getRepostCount() {
        return repostCount;
    }

    public void setRepostCount(int repostCount) {
        this.repostCount = repostCount;
    }

    public QqTStatus getSourceStatus() {
        return sourceStatus;
    }

    public void setSourceStatus(QqTStatus sourceStatus) {
        this.sourceStatus = sourceStatus;
    }

    public long getColloctNum() {
        return colloctNum;
    }

    public void setColloctNum(long colloctNum) {
        this.colloctNum = colloctNum;
    }

    public long getTweetNum() {
        return tweetNum;
    }

    public void setTweetNum(long tweetNum) {
        this.tweetNum = tweetNum;
    }
}
