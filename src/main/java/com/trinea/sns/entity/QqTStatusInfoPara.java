package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.trinea.java.common.MapUtils;
import com.trinea.java.common.StringUtils;
import com.trinea.sns.util.QqTConstant;

/**
 * 发布、转发、评论微博时的对象
 * 
 * @author Trinea 2011-9-23 上午01:37:07
 */
public class QqTStatusInfoPara implements Serializable {

    private static final long serialVersionUID     = -177267939556171256L;

    /** 返回数据的格式 **/
    private String            format;
    /** 发布内容，若isForward为true，则表示转发评论 **/
    private String            statusContent;
    /** 图片路径 **/
    private String            imageFilePath;
    /** 经度，有效范围：-180.0到+180.0，+表示东经。 **/
    private double            longitude;
    /** 纬度，有效范围：-90.0到+90.0，+表示北纬。 **/
    private double            latitude;
    /** 客户端ip **/
    private String            clientIp;
    /** 原微博id，发布一条新微博时为空 **/
    private long              sourceId;
    /** 音乐地址 **/
    private String            musicUrl;
    /** 音乐名 **/
    private String            musicTitle;
    /** 演唱者 **/
    private String            musicAuthor;
    /** 视频地址 **/
    private String            videoUrl;
    /** 心情类型（0，1，2，3，4） **/
    private int               signType;

    /** 默认值 **/
    private static String     defaultFormat        = "";
    private static String     defaultStatusContent = "";
    private static String     defaultImageFilePath = "";
    private static double     defaultLongitude     = 360;
    private static double     defaultLatitude      = 360;
    private static String     defaultClientIp      = "127.0.0.1";
    private static String     defaultMusicUrl      = "";
    private static String     defaultMusicTitle    = "";
    private static String     defaultMusicAuthor   = "";
    private static String     defaultVideoUrl      = "";
    private static long       defaultSourceId      = -1;
    private static int        defaultSignType      = -1;

    public QqTStatusInfoPara(){
        super();

        format = defaultFormat;
        statusContent = defaultStatusContent;
        imageFilePath = defaultImageFilePath;
        longitude = defaultLongitude;
        latitude = defaultLatitude;
        clientIp = defaultClientIp;
        musicUrl = defaultMusicUrl;
        musicTitle = defaultMusicTitle;
        musicAuthor = defaultMusicAuthor;
        videoUrl = defaultVideoUrl;
        sourceId = defaultSourceId;
        signType = defaultSignType;
    }

    /**
     * 将微博对象转换为api需要的map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        Map<String, String> parasMap = new HashMap<String, String>();
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_CONTENT, statusContent, "");
        // MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_PICTURE, imageFilePath);
        if (longitude <= 180 && longitude >= -180) {
            parasMap.put(QqTConstant.PARA_LONGITUDE, Double.toString(longitude));
        }
        if (latitude <= 90 && latitude >= -90) {
            parasMap.put(QqTConstant.PARA_LATITUDE, Double.toString(latitude));
        }
        if (sourceId >= 0) {
            parasMap.put(QqTConstant.PARA_REPLY_ID, Long.toString(sourceId));
        }
        if (signType >= 0) {
            parasMap.put(QqTConstant.PARA_SIGN_TYPE, Integer.toString(signType));
        }
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_CLIENT_IP, clientIp);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_MUSIC_URL, musicUrl);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_MUSIC_TITLE, musicTitle);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_MUSIC_AUTHOR, musicAuthor);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_VIDEO_URL, videoUrl);
        return parasMap;
    }

    /**
     * 对于发布新微博是否合法
     * 
     * @return
     */
    public boolean isNewValid() {
        return !StringUtils.isEmpty(statusContent);
    }

    /**
     * 对于转发或评论微博是否合法
     * 
     * @return
     */
    public boolean isRepostOrCommentValid() {
        return !(StringUtils.isEmpty(statusContent) || sourceId < 0);
    }

    /**
     * 是否包含图片，根据imageFilePath来判断
     * 
     * @return
     *         <ul>
     *         <li>若imageFilePath为null或空字符串，则不包含，否则包含</li>
     *         </ul>
     */
    public boolean isContainImage() {
        return !StringUtils.isEmpty(imageFilePath);
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getStatusContent() {
        return statusContent;
    }

    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientIp() {
        return clientIp;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
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

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getSignType() {
        return signType;
    }

    public void setSignType(int signType) {
        this.signType = signType;
    }
}
