package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 腾讯微博用户信息
 * http://open.t.qq.com/resource.php?i=1,1#9_30
 * 
 * @author Trinea 2011-10-8 下午11:44:53
 */
public class QqTUser implements Serializable {

    private static final long    serialVersionUID = 3298635316340763420L;

    private long                 userId;                                 // 用户id
    private String               userName;                               // 用户名
    private String               userScreenName;                         // 用户昵称
    private String               userDescription;                        // 个人介绍
    private String               iconUrl;                                // 头像图片地址

    /** 用户性别 1男 2 女 0未知 **/
    private String               sex;
    private String               birthYear;                              // 出生年
    private String               birthMonth;                             // 出生月
    private String               birthDay;                               // 出生日

    private long                 followersCount;                         // 听众数
    private long                 friendsCount;                           // 收听的人数
    private long                 statusesCount;                          // 微博数

    private Map<String, String>  tagMap;                                 // 个人标签，key为标签id，name为标签名
    private List<QqTUserEduInfo> EduInfoList;                            // 学历信息

    private String               location;                               // 发表者所在地
    private String               countryCode;                            // 国家码(其他时间线一样)
    private String               provinceCode;                           // 省份码(其他时间线一样)
    private String               cityCode;                               // 城市码(其他时间线一样)

    private boolean              isMyInterested;                         // 是否是我收听的
    private boolean              isVip;                                  // 是否认证用户
    private boolean              isEnt;                                  // 是否企业机构
    private String               verifyInfo;                             // 认证信息

    private List<QqTStatus>      latestStatusList;                       // 用户最近微博列表

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 用户性别 1男， 2女， 其他表示未知
     * 
     * @param sex 表示性别的整数
     *            <ul>
     *            <li>其他暂时用女表示</li>
     *            </ul>
     */
    public void setSex(int sex) {
        if (sex == 1) {
            this.sex = "男";
        } else if (sex == 2) {
            this.sex = "女";
        } else {
            this.sex = "未知";
        }
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(long friendsCount) {
        this.friendsCount = friendsCount;
    }

    public long getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(long statusesCount) {
        this.statusesCount = statusesCount;
    }

    public Map<String, String> getTagMap() {
        return tagMap;
    }

    public void setTagMap(Map<String, String> tagMap) {
        this.tagMap = tagMap;
    }

    public List<QqTUserEduInfo> getEduInfoList() {
        return EduInfoList;
    }

    public void setEduInfoList(List<QqTUserEduInfo> eduInfoList) {
        EduInfoList = eduInfoList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setMyInterested(boolean isMyInterested) {
        this.isMyInterested = isMyInterested;
    }

    public boolean isMyInterested() {
        return isMyInterested;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }

    public boolean isEnt() {
        return isEnt;
    }

    public void setEnt(boolean isEnt) {
        this.isEnt = isEnt;
    }

    public String getVerifyInfo() {
        return verifyInfo;
    }

    public void setVerifyInfo(String verifyInfo) {
        this.verifyInfo = verifyInfo;
    }

    public void setLatestStatusList(List<QqTStatus> latestStatusList) {
        this.latestStatusList = latestStatusList;
    }

    public List<QqTStatus> getLatestStatusList() {
        return latestStatusList;
    }
}
