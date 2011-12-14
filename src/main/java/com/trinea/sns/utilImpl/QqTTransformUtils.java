package com.trinea.sns.utilImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.trinea.java.common.HttpUtils;
import com.trinea.java.common.JSONUtils;
import com.trinea.java.common.ListUtils;
import com.trinea.java.common.MapUtils;
import com.trinea.java.common.StringUtils;
import com.trinea.sns.entity.QqTIdAndTime;
import com.trinea.sns.entity.QqTListData;
import com.trinea.sns.entity.QqTResponse;
import com.trinea.sns.entity.QqTStatus;
import com.trinea.sns.entity.QqTTopicSimple;
import com.trinea.sns.entity.QqTUpdateNumInfo;
import com.trinea.sns.entity.QqTUser;
import com.trinea.sns.entity.QqTUserEduInfo;
import com.trinea.sns.entity.QqTUserRelation;
import com.trinea.sns.entity.QqTVideoInfo;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博转换函数
 * 
 * @author Trinea 2011-10-27 上午12:09:37
 */
public class QqTTransformUtils {

    /**
     * 将从服务器返回的信息转换成QqTResponse
     * <ul>
     * <li>注意：不包含主体data的解析，需要自己set</li>
     * </ul>
     * 
     * @param responseObj
     * @return
     */
    public static QqTResponse transResponse(JSONObject responseObj) {
        if (responseObj == null) {
            return null;
        }

        QqTResponse qqTResponse = new QqTResponse();
        qqTResponse.setReturnStatus(JSONUtils.getInt(responseObj, "ret", -1));
        qqTResponse.setErrorCode(JSONUtils.getInt(responseObj, "errcode", -1));
        qqTResponse.setMessage(JSONUtils.getString(responseObj, "msg", ""));
        return qqTResponse;
    }

    /**
     * 将从服务器返回的信息转换成QqTResponse
     * 
     * @param responseStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transResponse(JSONObject)}</li>
     *         </ul>
     */
    public static QqTResponse transResponse(String responseStr) {
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }

        try {
            return transResponse(new JSONObject(responseStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将时间线、用户列表等api返回结果中的data部分转换成QqTListData
     * <ul>
     * <li>注意：不包含主体info的解析，需要自己set</li>
     * </ul>
     * 
     * @param responseObj
     * @return
     */
    public static QqTListData transQqTListData(JSONObject responseObj) {
        if (responseObj == null) {
            return null;
        }

        JSONObject qqTListDataObj;
        try {
            qqTListDataObj = responseObj.getJSONObject("data");
            QqTListData qqTListData = new QqTListData();
            qqTListData.setTimeStamp(JSONUtils.getLong(qqTListDataObj, "timestamp", -1));
            qqTListData.setHasNext(JSONUtils.getInt(qqTListDataObj, "hasnext", -1));
            qqTListData.setPosition(JSONUtils.getLong(qqTListDataObj, "pos", -1));
            qqTListData.setPositionForMutualList(JSONUtils.getLong(qqTListDataObj, "nextstartpos", -1));
            qqTListData.setTotalNumber(JSONUtils.getLong(qqTListDataObj, "totalnum", -1));
            qqTListData.setPageInfo(JSONUtils.getString(qqTListDataObj, "pageinfo", ""));
            qqTListData.setColloct((JSONUtils.getInt(qqTListDataObj, "isfav", 0) == 0));
            qqTListData.setTopicId(JSONUtils.getLong(qqTListDataObj, "id", -1));
            qqTListData.setNextTime(JSONUtils.getLong(qqTListDataObj, "nexttime", -1));
            qqTListData.setPrevTime(JSONUtils.getLong(qqTListDataObj, "prevtime", -1));
            qqTListData.setCostTime(JSONUtils.getLong(qqTListDataObj, "costtime", -1));
            return qqTListData;
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将时间线、用户列表等api返回结果中的data部分转换成QqTListData
     * 
     * @param responseStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transQqTListData(JSONObject)}</li>
     *         </ul>
     */
    public static QqTListData transQqTListData(String responseStr) {
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }

        try {
            return transQqTListData(new JSONObject(responseStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将新增、删除等api返回结果中的data部分转换成QqTIdAndTime
     * 
     * @param responseObj
     * @return
     */
    public static QqTIdAndTime transQqTIdAndTime(JSONObject responseObj) {
        if (responseObj == null) {
            return null;
        }

        JSONObject qqTListDataObj;
        try {
            qqTListDataObj = responseObj.getJSONObject("data");
            QqTIdAndTime qqTIdAndTime = new QqTIdAndTime();
            qqTIdAndTime.setId(JSONUtils.getLong(qqTListDataObj, "id", -1));
            qqTIdAndTime.setTimeStamp(JSONUtils.getLong(qqTListDataObj, "timestamp", -1));
            return qqTIdAndTime;
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将新增、删除等api返回结果中的data部分转换成QqTIdAndTime
     * 
     * @param responseStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transQqTIdAndTime(JSONObject)}</li>
     *         </ul>
     */
    public static QqTIdAndTime transQqTIdAndTime(String responseStr) {
        if (StringUtils.isEmpty(responseStr)) {
            return null;
        }

        try {
            return transQqTIdAndTime(new JSONObject(responseStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将时间线api从服务器返回的信息转换成QqTStatus lilst
     * 
     * @param statusesObj
     * @return
     *         <ul>
     *         <li>1、获得data</li>
     *         <li>2、解析data得到info数组</li>
     *         <li>3、调用{@link QqTTransformUtils#transStatus(JSONObject)}解析info数组中的每一条微博</li>
     *         </ul>
     */
    public static List<QqTStatus> transTLStatusesToList(JSONObject statusesObj) {
        if (statusesObj != null) {
            try {
                JSONObject dataObj = statusesObj.getJSONObject("data");
                if (dataObj != null) {
                    JSONArray statusArray = dataObj.getJSONArray("info");
                    if (statusArray != null && statusArray.length() > 0) {
                        List<QqTStatus> qqTStatusList = new ArrayList<QqTStatus>();
                        for (int i = 0; i < statusArray.length(); i++) {
                            ListUtils.addListNotNullValue(qqTStatusList, transStatus(statusArray.optJSONObject(i)));
                        }
                        return qqTStatusList;
                    }
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将时间线api从服务器返回的信息转换成QqTStatus lilst
     * 
     * @param statusesJsonStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transTLStatusesToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTStatus> transTLStatusesToList(String statusesJsonStr) {
        if (StringUtils.isEmpty(statusesJsonStr)) {
            return null;
        }

        try {
            return transTLStatusesToList(new JSONObject(statusesJsonStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将JSONArray形式微博列表信息转换成QqTStatus lilst
     * 
     * @param statusArray status jsonArray
     * @return
     *         <ul>
     *         <li>3、调用{@link QqTTransformUtils#transStatus(JSONObject)}解析statusArray中的每一条微博</li>
     *         </ul>
     */
    public static List<QqTStatus> transStatusesToList(JSONArray statusArray) {
        if (statusArray == null || statusArray.length() == 0) {
            return null;
        }

        List<QqTStatus> qqTStatusList = new ArrayList<QqTStatus>();
        for (int i = 0; i < statusArray.length(); i++) {
            ListUtils.addListNotNullValue(qqTStatusList, transStatus(statusArray.optJSONObject(i)));
        }
        return qqTStatusList;
    }

    /**
     * 将可转换成JSONArray形式的字符串转换成QqTStatus lilst
     * 
     * @param statusesJsonStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONArray</li>
     *         <li>2、调用{@link QqTTransformUtils#transStatusesToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTStatus> transStatusesToList(String statusesJsonStr) {
        if (StringUtils.isEmpty(statusesJsonStr)) {
            return null;
        }

        try {
            return transStatusesToList(new JSONArray(statusesJsonStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将一条微博的信息转换成对应的QqTStatus
     * 
     * @param statusObj 微博信息JsonObject
     * @return
     */
    public static QqTStatus transStatus(JSONObject statusObj) {
        if (statusObj == null) {
            return null;
        }

        QqTStatus qqTStatus = new QqTStatus();
        qqTStatus.setTime(JSONUtils.getLong(statusObj, "timestamp", (new Date()).getTime() / 1000));
        qqTStatus.setStatusId(JSONUtils.getLong(statusObj, "id", 0));
        qqTStatus.setStatusContent(StringUtils.htmlEscapeCharsToString(JSONUtils.getString(statusObj, "text", "")));
        qqTStatus.setStatusOrigiContent(StringUtils.htmlEscapeCharsToString(JSONUtils.getString(statusObj, "origtext",
                                                                                                "")));
        qqTStatus.setCommentCount(JSONUtils.getInt(statusObj, "mcount", 0));
        qqTStatus.setSourceType(JSONUtils.getString(statusObj, "from", "腾讯微博"));
        qqTStatus.setRepostCount(JSONUtils.getInt(statusObj, "count", 0));
        qqTStatus.setImageUrl(JSONUtils.getStringArray(statusObj, "image", null));
        qqTStatus.setContainImageFromImageUrl();
        transVideoInfo(qqTStatus, statusObj);
        transMucisInfo(qqTStatus, statusObj);
        qqTStatus.setUser(transUserInfo(statusObj));
        qqTStatus.setStatusType(JSONUtils.getInt(statusObj, "type", QqTConstant.VALUE_STATUS_TYPE_ORIGINAL));
        qqTStatus.setSourceStatus(transStatus(JSONUtils.getJSONObject(statusObj, "source", null)));
        qqTStatus.setContainSource((qqTStatus.getSourceStatus() != null));
        if (qqTStatus.getStatusType() == QqTConstant.VALUE_STATUS_TYPE_REPOST) {
            qqTStatus.setStatusOrigiContent("转播:" + qqTStatus.getStatusOrigiContent());
        }
        qqTStatus.setColloctNum(JSONUtils.getLong(statusObj, "favnum", 0));
        qqTStatus.setTweetNum(JSONUtils.getLong(statusObj, "tweetnum", 0));
        return qqTStatus;
    }

    /**
     * 将一条微博的信息转换成对应的QqTStatus
     * 
     * @param statusStr 微博信息字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transStatus(JSONObject)}</li>
     *         </ul>
     */
    public static QqTStatus transStatus(String statusStr) {
        if (StringUtils.isEmpty(statusStr)) {
            return null;
        }

        try {
            return transStatus(new JSONObject(statusStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 设置微博中的video信息
     * 
     * @param qqTStatus
     * @param videoInfoObj
     * @return
     */
    public static boolean transVideoInfo(QqTStatus qqTStatus, JSONObject videoInfoObj) {
        JSONObject video = JSONUtils.getJSONObject(videoInfoObj, "video", null);
        if (video != null) {
            qqTStatus.setVideoActualUrl(JSONUtils.getString(video, "realurl", ""));
            qqTStatus.setVideoImageUrl(JSONUtils.getString(video, "picurl", ""));
            qqTStatus.setVideoPlayerUrl(JSONUtils.getString(video, "player", ""));
            qqTStatus.setVideoShortUrl(JSONUtils.getString(video, "shorturl", ""));
            qqTStatus.setVideoTitle(JSONUtils.getString(video, "title", ""));
            qqTStatus.setContainVideo(true);
        } else {
            qqTStatus.setContainVideo(false);
        }
        return qqTStatus.isContainVideo();
    }

    /**
     * 设置微博中的mudic信息
     * 
     * @param qqTStatus
     * @param musicInfoObj
     * @return
     */
    public static boolean transMucisInfo(QqTStatus qqTStatus, JSONObject musicInfoObj) {
        JSONObject music = JSONUtils.getJSONObject(musicInfoObj, "music", null);
        if (music != null) {
            qqTStatus.setMusicAuthor(JSONUtils.getString(music, "author", ""));
            qqTStatus.setMusicTitle(JSONUtils.getString(music, "title", ""));
            qqTStatus.setMusicUrl(JSONUtils.getString(music, "url", ""));
            qqTStatus.setContainMusic(true);
        } else {
            qqTStatus.setContainMusic(false);
        }
        return qqTStatus.isContainMusic();
    }

    /**
     * 将从服务器返回的用户列表信息转换成QqTUser lilst
     * 
     * @param useresObj
     * @return
     *         <ul>
     *         <li>1、获得data</li>
     *         <li>2、解析data得到info数组</li>
     *         <li>3、调用{@link QqTTransformUtils#transUserInfo(JSONObject)}解析info数组中的每一条用户</li>
     *         </ul>
     */
    public static List<QqTUser> transUsersToList(JSONObject useresObj) {
        if (useresObj != null) {
            try {
                JSONObject dataObj = useresObj.getJSONObject("data");
                if (dataObj != null) {
                    JSONArray userArray = dataObj.getJSONArray("info");
                    if (userArray != null && userArray.length() > 0) {
                        List<QqTUser> qqTUserList = new ArrayList<QqTUser>();
                        for (int i = 0; i < userArray.length(); i++) {
                            ListUtils.addListNotNullValue(qqTUserList, transUserInfo(userArray.optJSONObject(i)));
                        }
                        return qqTUserList;
                    }
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将从服务器返回的用户列表信息转换成QqTUser lilst
     * 
     * @param useresJsonStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUsersToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTUser> transUsersToList(String useresJsonStr) {
        if (StringUtils.isEmpty(useresJsonStr)) {
            return null;
        }

        try {
            return transUsersToList(new JSONObject(useresJsonStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将从服务器返回的用户姓名列表信息转换成QqTUser lilst
     * 
     * @param userNamesObj
     * @return
     *         <ul>
     *         <li>1、获得data</li>
     *         <li>2、解析data得到info数组</li>
     *         <li>3、解析info数组中的每一条用户姓名</li>
     *         </ul>
     */
    public static List<String> transUserNamesToList(JSONObject userNamesObj) {
        if (userNamesObj != null) {
            try {
                JSONObject dataObj = userNamesObj.getJSONObject("data");
                if (dataObj != null) {
                    JSONArray userArray = dataObj.getJSONArray("info");
                    if (userArray != null && userArray.length() > 0) {
                        List<String> qqTUserNameList = new ArrayList<String>();
                        for (int i = 0; i < userArray.length(); i++) {
                            JSONObject userNameObj = userArray.optJSONObject(i);
                            ListUtils.addListNotNullValue(qqTUserNameList, JSONUtils.getString(userNameObj, "name", ""));
                        }
                        return qqTUserNameList;
                    }
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将从服务器返回的用户姓名列表信息转换成String lilst
     * 
     * @param userNameJsonStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserNamesToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<String> transUserNamesToList(String userNameJsonStr) {
        if (StringUtils.isEmpty(userNameJsonStr)) {
            return null;
        }

        try {
            return transUserNamesToList(new JSONObject(userNameJsonStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户信息转换为对应的QqTUser
     * 
     * @param userInfoObj 用户信息JsonObject
     * @return
     */
    public static QqTUser transUserInfo(JSONObject userInfoObj) {
        if (userInfoObj == null) {
            return null;
        }

        QqTUser user = new QqTUser();
        user.setUserName(JSONUtils.getString(userInfoObj, "name", ""));
        user.setUserScreenName(JSONUtils.getString(userInfoObj, "nick", ""));
        user.setUserId(JSONUtils.getLong(userInfoObj, "openid", -1));
        /**
         * 头像图片地址先 从head中找，不存在则从url中找
         * 对于头像图片需要在得到的url后加上/size拼接成完整路径，腾讯规定
         **/
        user.setIconUrl(JSONUtils.getString(userInfoObj, "head", ""));
        if (StringUtils.isEmpty(user.getIconUrl())) {
            user.setIconUrl(JSONUtils.getString(userInfoObj, "url", ""));
        }
        if (!StringUtils.isEmpty(user.getIconUrl())) {
            user.setIconUrl(user.getIconUrl() + HttpUtils.PATHS_SEPARATOR + QqTConstant.HEAD_ICON_SIZE_50);
        }
        user.setMyInterested(JSONUtils.getBoolean(userInfoObj, "isidol", false));
        user.setVip(JSONUtils.getInt(userInfoObj, "isvip", 0) != 0);
        user.setEnt(JSONUtils.getInt(userInfoObj, "isent", 0) != 0);
        user.setVerifyInfo(JSONUtils.getString(userInfoObj, "verifyinfo", ""));
        user.setBirthYear(JSONUtils.getString(userInfoObj, "birth_year", ""));
        user.setBirthMonth(JSONUtils.getString(userInfoObj, "birth_month", ""));
        user.setBirthDay(JSONUtils.getString(userInfoObj, "birth_day", ""));
        user.setUserDescription(JSONUtils.getString(userInfoObj, "introduction", ""));
        user.setCountryCode(JSONUtils.getString(userInfoObj, "country_code", ""));
        user.setCityCode(JSONUtils.getString(userInfoObj, "city_code", ""));
        user.setProvinceCode(JSONUtils.getString(userInfoObj, "province_code", ""));
        user.setLocation(JSONUtils.getString(userInfoObj, "location", ""));
        user.setSex(JSONUtils.getInt(userInfoObj, "sex", 0));
        user.setStatusesCount(JSONUtils.getLong(userInfoObj, "tweetnum", -1));
        user.setFollowersCount(JSONUtils.getLong(userInfoObj, "fansnum", -1));
        user.setFriendsCount(JSONUtils.getLong(userInfoObj, "idolnum", -1));
        user.setTagMap(transUserTagInfoToMap(userInfoObj));
        user.setEduInfoList(transUserEduInfoToList(userInfoObj));
        user.setLatestStatusList(transStatusesToList(JSONUtils.getJSONArray(userInfoObj, "tweet", null)));
        return user;
    }

    /**
     * 将用户信息转换为对应的QqTUser
     * 
     * @param userInfoStr 用户信息字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserInfo(JSONObject)}</li>
     *         </ul>
     */
    public static QqTUser transUserInfo(String userInfoStr) {
        if (StringUtils.isEmpty(userInfoStr)) {
            return null;
        }

        try {
            return transUserInfo(new JSONObject(userInfoStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户标签转换为对应的map，key为标签id，name为标签名
     * 
     * @param userTagInfoObj 用户标签信息JsonObject
     * @return
     */
    public static Map<String, String> transUserTagInfoToMap(JSONObject userTagInfoObj) {
        if (userTagInfoObj != null) {
            try {
                JSONArray userTagInfoArray = userTagInfoObj.getJSONArray("tag");
                if (userTagInfoArray != null) {
                    Map<String, String> tagInfoMap = new HashMap<String, String>();
                    for (int i = 0; i < userTagInfoArray.length(); i++) {
                        JSONObject userTagInfo = userTagInfoArray.optJSONObject(i);
                        tagInfoMap.put(JSONUtils.getString(userTagInfo, "id", ""),
                                       JSONUtils.getString(userTagInfo, "name", ""));
                    }
                    return tagInfoMap;
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将用户标签转换为对应的map，key为标签id，name为标签名
     * 
     * @param userTagInfoStr 用户标签信息字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserTagInfoToMap(JSONObject)}</li>
     *         </ul>
     */
    public static Map<String, String> transUserTagInfoToMap(String userTagInfoStr) {
        if (StringUtils.isEmpty(userTagInfoStr)) {
            return null;
        }

        try {
            return transUserTagInfoToMap(new JSONObject(userTagInfoStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户教育信息转换成QqTUserEduInfo lilst
     * 
     * @param userEduInfoObj
     * @return
     *         <ul>
     *         <li>1、获得data</li>
     *         <li>2、解析data得到edu数组</li>
     *         <li>3、调用{@link QqTTransformUtils#transUserEduInfo(JSONObject)}解析edu数组中的每一条教育信息</li>
     *         </ul>
     */
    public static List<QqTUserEduInfo> transUserEduInfoToList(JSONObject userEduInfoObj) {
        if (userEduInfoObj != null) {
            JSONArray userEduInfoArray;
            try {
                userEduInfoArray = userEduInfoObj.getJSONArray("edu");
                if (userEduInfoArray != null) {
                    List<QqTUserEduInfo> userEduInfoList = new ArrayList<QqTUserEduInfo>();
                    for (int i = 0; i < userEduInfoArray.length(); i++) {
                        ListUtils.addListNotNullValue(userEduInfoList,
                                                      transUserEduInfo(userEduInfoArray.optJSONObject(i)));
                    }
                    return userEduInfoList;
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将用户教育信息转换成QqTUserEduInfo lilst
     * 
     * @param userEduInfoStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserEduInfoToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTUserEduInfo> transUserEduInfoToList(String userEduInfoStr) {
        if (StringUtils.isEmpty(userEduInfoStr)) {
            return null;
        }

        try {
            return transUserEduInfoToList(new JSONObject(userEduInfoStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户教育信息转换成QqTUserEduInfo
     * 
     * @param userEduInfoObj
     * @return
     */
    public static QqTUserEduInfo transUserEduInfo(JSONObject userEduInfoObj) {
        if (userEduInfoObj == null) {
            return null;
        }

        QqTUserEduInfo qqTUserEduInfo = new QqTUserEduInfo();
        qqTUserEduInfo.setId(JSONUtils.getLong(userEduInfoObj, "id", -1));
        qqTUserEduInfo.setYear(JSONUtils.getString(userEduInfoObj, "year", ""));
        qqTUserEduInfo.setSchoolId(JSONUtils.getLong(userEduInfoObj, "schoolid", -1));
        qqTUserEduInfo.setDepartmentId(JSONUtils.getLong(userEduInfoObj, "departmentid", -1));
        qqTUserEduInfo.setLevel(JSONUtils.getInt(userEduInfoObj, "level", -1));
        return qqTUserEduInfo;
    }

    /**
     * 将用户教育信息转换成QqTUserEduInfo
     * 
     * @param userEduInfoStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserEduInfo(JSONObject)}</li>
     *         </ul>
     */
    public static QqTUserEduInfo transUserEduInfo(String userEduInfoStr) {
        if (StringUtils.isEmpty(userEduInfoStr)) {
            return null;
        }

        try {
            return transUserEduInfo(new JSONObject(userEduInfoStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将转播数或点评数转换为对应的map，key为状态id，name为转播或点评数
     * 
     * @param statusesReCountObj 转播数或点评数JsonObject
     * @return
     */
    public static Map<Long, Integer> transStatusesReCountToMap(JSONObject statusesReCountObj) {
        if (statusesReCountObj != null) {
            try {
                JSONArray statusesReCountArray = statusesReCountObj.getJSONArray("data");
                if (statusesReCountArray != null) {
                    Map<Long, Integer> statusesReCountMap = new HashMap<Long, Integer>();
                    String statusReCountInfo;
                    int seperator;
                    for (int i = 0; i < statusesReCountArray.length(); i++) {
                        statusReCountInfo = statusesReCountArray.toString();
                        if (!StringUtils.isEmpty(statusReCountInfo)) {
                            seperator = statusReCountInfo.indexOf(":");
                            if (seperator != -1 && seperator < statusReCountInfo.length()) {
                                try {
                                    statusesReCountMap.put(Long.parseLong(statusReCountInfo.substring("\"".length(),
                                                                                                      seperator - 1)),
                                                           Integer.parseInt(statusReCountInfo.substring(seperator + 1)));
                                } catch (NumberFormatException e) {
                                }
                            }
                        }
                    }
                    return statusesReCountMap;
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将转播数或点评数转换为对应的map，key为状态id，name为转播或点评数
     * 
     * @param statusesReCountStr 转播数或点评数字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserTagInfoToMap(JSONObject)}</li>
     *         </ul>
     */
    public static Map<Long, Integer> transStatusesReCountToMap(String statusesReCountStr) {
        if (StringUtils.isEmpty(statusesReCountStr)) {
            return null;
        }

        try {
            return transStatusesReCountToMap(new JSONObject(statusesReCountStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将commentCountMap转换为简单的QqTStatus List，QqTStatus List中每个QqTStatus包含statusId和commentCount
     * 
     * @param commentCountMap key为状态id，name为点评数
     * @return
     */
    public static List<QqTStatus> transCommentCountMapToList(Map<Long, Integer> commentCountMap) {
        if (MapUtils.isEmpty(commentCountMap)) {
            return null;
        }

        List<QqTStatus> qqTStatusList = new ArrayList<QqTStatus>();
        Iterator<Map.Entry<Long, Integer>> iterator = commentCountMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>)iterator.next();
            QqTStatus qqTStatus = new QqTStatus();
            qqTStatus.setStatusId(entry.getKey());
            qqTStatus.setCommentCount(entry.getValue());
            qqTStatusList.add(qqTStatus);
        }
        return qqTStatusList;
    }

    /**
     * 将repostCountMap转换为简单的QqTStatus List，QqTStatus List中每个QqTStatus包含statusId和repostCount
     * 
     * @param repostCountMap key为状态id，name为转播数
     * @return
     */
    public static List<QqTStatus> transRepostCountMapToList(Map<Long, Integer> repostCountMap) {
        if (MapUtils.isEmpty(repostCountMap)) {
            return null;
        }

        List<QqTStatus> qqTStatusList = new ArrayList<QqTStatus>();
        Iterator<Map.Entry<Long, Integer>> iterator = repostCountMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>)iterator.next();
            QqTStatus qqTStatus = new QqTStatus();
            qqTStatus.setStatusId(entry.getKey());
            qqTStatus.setRepostCount(entry.getValue());
            qqTStatusList.add(qqTStatus);
        }
        return qqTStatusList;
    }

    /**
     * 将转播数或点评数转换为对应的QqTStatus List，QqTStatus List中每个QqTStatus包含statusId、commentCount、repostCount
     * 
     * @param statusesReCountObj 转播数和点评数JsonObject
     * @return
     */
    public static List<QqTStatus> transStatusesReCountToList(JSONObject statusesReCountObj) {
        if (statusesReCountObj != null) {
            try {
                JSONArray statusesReCountArray = statusesReCountObj.getJSONArray("data");
                if (statusesReCountArray != null) {
                    List<QqTStatus> qqTStatusList = new ArrayList<QqTStatus>();
                    String statusReCountInfo, countInfo;
                    int seperator;
                    for (int i = 0; i < statusesReCountArray.length(); i++) {
                        statusReCountInfo = statusesReCountArray.toString();
                        seperator = statusReCountInfo.indexOf(":");
                        try {
                            countInfo = statusReCountInfo.substring(seperator + 1);
                            JSONObject countInfoObj = new JSONObject(countInfo);

                            QqTStatus qqTStatus = new QqTStatus();
                            qqTStatus.setStatusId(Long.parseLong(statusReCountInfo.substring("\"".length(),
                                                                                             seperator - 1)));
                            qqTStatus.setCommentCount(Integer.parseInt(countInfoObj.getString("count")));
                            qqTStatus.setRepostCount(Integer.parseInt(countInfoObj.getString("mcount")));
                            qqTStatusList.add(qqTStatus);
                        } catch (NumberFormatException e) {
                        } catch (Exception e) {
                        }
                    }
                    return qqTStatusList;
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将转播数或点评数转换为对应的QqTStatus List，QqTStatus List中每个QqTStatus包含statusId、commentCount、repostCount
     * 
     * @param statusesReCountStr 转播数和点评数字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transStatusesReCountToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTStatus> transStatusesReCountToList(String statusesReCountStr) {
        if (StringUtils.isEmpty(statusesReCountStr)) {
            return null;
        }

        try {
            return transStatusesReCountToList(new JSONObject(statusesReCountStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将视频信息转换为对应的对象
     * 
     * @param videoInfo 视频信息字符串
     * @return
     */
    public static QqTVideoInfo transVideoInfo(String videoInfo) {
        if (StringUtils.isEmpty(videoInfo)) {
            return null;
        }

        try {
            return transVideoInfo(new JSONObject(videoInfo));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将视频信息转换为对应的对象
     * 
     * @param videoInfoObj 视频信息JSONObject
     * @return
     */
    public static QqTVideoInfo transVideoInfo(JSONObject videoInfoObj) {
        QqTVideoInfo qqTVideoInfo = new QqTVideoInfo();
        qqTVideoInfo.setMiniPicUrl(JSONUtils.getString(videoInfoObj, "minipic", ""));
        qqTVideoInfo.setPlayerUrl(JSONUtils.getString(videoInfoObj, "player", ""));
        qqTVideoInfo.setRealUrl(JSONUtils.getString(videoInfoObj, "real", ""));
        qqTVideoInfo.setShortUrl(JSONUtils.getString(videoInfoObj, "short", ""));
        qqTVideoInfo.setTitle(JSONUtils.getString(videoInfoObj, "title", ""));
        return qqTVideoInfo;
    }

    /**
     * 将用户的关系转换为对应的map，key为用户名，value为true或false，表示是否是听众或收听的人
     * 
     * @param userRelationObj 用户关系JsonObject
     * @return
     */
    public static Map<String, Boolean> transUserRelationToMap(JSONObject userRelationObj) {
        if (userRelationObj != null) {
            try {
                JSONArray userRelationArray = userRelationObj.getJSONArray("data");
                if (userRelationArray != null) {
                    Map<String, Boolean> userRelationMap = new HashMap<String, Boolean>();
                    String userRelationInfo;
                    int seperator;
                    for (int i = 0; i < userRelationArray.length(); i++) {
                        userRelationInfo = userRelationArray.toString();
                        seperator = userRelationInfo.indexOf(":");
                        try {
                            userRelationMap.put(userRelationInfo.substring(":".length(), seperator - 1),
                                                StringUtils.isEquals(userRelationInfo.substring(seperator + 1), "true"));
                        } catch (NumberFormatException e) {
                        }
                    }
                    return userRelationMap;
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将用户的关系转换为对应的map，key为用户名，value为true或false，表示是否是听众或收听的人
     * 
     * @param userRelationStr 用户关系字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserRelationToMap(JSONObject)}</li>
     *         </ul>
     */
    public static Map<String, Boolean> transUserRelationToMap(String userRelationStr) {
        if (StringUtils.isEmpty(userRelationStr)) {
            return null;
        }

        try {
            return transUserRelationToMap(new JSONObject(userRelationStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户的关系转换为对应的list
     * 
     * @param userRelationObj 用户关系JsonObject
     * @return
     */
    public static List<QqTUserRelation> transUserRelationToList(JSONObject userRelationObj) {
        if (userRelationObj == null) {
            return null;
        }

        try {
            JSONArray userRelationArray = userRelationObj.getJSONArray("data");
            if (userRelationArray == null) {
                return null;
            }

            List<QqTUserRelation> userRelationList = new ArrayList<QqTUserRelation>();
            String userRelationInfo, relationInfo;
            int seperator;
            for (int i = 0; i < userRelationArray.length(); i++) {
                userRelationInfo = userRelationArray.toString();

                seperator = userRelationInfo.indexOf(":");
                try {
                    relationInfo = userRelationInfo.substring(seperator + 1);
                    JSONObject relationInfoObj = new JSONObject(relationInfo);

                    QqTUserRelation userRelation = new QqTUserRelation();
                    userRelation.setUserName(userRelationInfo.substring(":".length(), seperator - 1));
                    userRelation.setFan(StringUtils.isEquals(relationInfoObj.getString("isidol"), "true"));
                    userRelation.setInterested(StringUtils.isEquals(relationInfoObj.getString("isfans"), "true"));
                    userRelationList.add(userRelation);
                } catch (NumberFormatException e) {
                } catch (Exception e) {
                }

            }
            return userRelationList;
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将用户的关系转换为对应的list
     * 
     * @param userRelationStr 用户关系字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserRelationToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTUserRelation> transUserRelationToList(String userRelationStr) {
        if (StringUtils.isEmpty(userRelationStr)) {
            return null;
        }

        try {
            return transUserRelationToList(new JSONObject(userRelationStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将一条主题的简单信息转换成对应的QqTTopicSimple
     * 
     * @param topicObj 主题信息JsonObject
     * @return
     */
    public static QqTTopicSimple transTopic(JSONObject topicObj) {
        if (topicObj == null) {
            return null;
        }

        QqTTopicSimple qqTTopicSimple = new QqTTopicSimple();
        qqTTopicSimple.setName(JSONUtils.getString(topicObj, "name", ""));
        qqTTopicSimple.setKeyWords(JSONUtils.getString(topicObj, "keywords", ""));
        qqTTopicSimple.setType(JSONUtils.getInt(topicObj, "type", 0));

        return qqTTopicSimple;
    }

    /**
     * 将从服务器返回的微博话题简单信息转换成QqTTopicSimple lilst
     * 
     * @param topicsObj
     * @return
     *         <ul>
     *         <li>1、获得data</li>
     *         <li>2、解析data得到info数组</li>
     *         <li>3、调用{@link QqTTransformUtils#transTopic(JSONObject)}解析info数组中的每一条主题</li>
     *         </ul>
     */
    public static List<QqTTopicSimple> transTopicsToList(JSONObject topicsObj) {
        if (topicsObj != null) {
            try {
                JSONObject dataObj = topicsObj.getJSONObject("data");
                if (dataObj != null) {
                    JSONArray topicArray = dataObj.getJSONArray("info");
                    if (topicArray != null && topicArray.length() > 0) {
                        List<QqTTopicSimple> qqTTopicSimpleList = new ArrayList<QqTTopicSimple>();
                        for (int i = 0; i < topicArray.length(); i++) {
                            ListUtils.addListNotNullValue(qqTTopicSimpleList, transTopic(topicArray.optJSONObject(i)));
                        }
                        return qqTTopicSimpleList;
                    }
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将从服务器返回的微博话题简单信息转换成QqTTopicSimple lilst
     * 
     * @param topicsJsonStr
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transTopicsToList(JSONObject)}</li>
     *         </ul>
     */
    public static List<QqTTopicSimple> transTopicsToList(String topicsJsonStr) {
        if (StringUtils.isEmpty(topicsJsonStr)) {
            return null;
        }

        try {
            return transTopicsToList(new JSONObject(topicsJsonStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将一条数据更新信息转换成对应的QqTUpdateNumInfo
     * 
     * @param updateNumInfoObj 数据更新信息JsonObject
     * @return
     */
    public static QqTUpdateNumInfo transQqTUpdateNumInfo(JSONObject updateNumInfoObj) {
        if (updateNumInfoObj == null) {
            return null;
        }

        JSONObject dataObj = JSONUtils.getJSONObject(updateNumInfoObj, "data", null);
        if (dataObj == null) {
            return null;
        }
        QqTUpdateNumInfo qqTUpdateNumInfo = new QqTUpdateNumInfo();
        qqTUpdateNumInfo.setHome(JSONUtils.getInt(dataObj, "home", 0));
        qqTUpdateNumInfo.setPrivateMessage(JSONUtils.getInt(dataObj, "private", 0));
        qqTUpdateNumInfo.setFans(JSONUtils.getInt(dataObj, "fans", 0));
        qqTUpdateNumInfo.setMentions(JSONUtils.getInt(dataObj, "mentions", 0));
        qqTUpdateNumInfo.setCreate(JSONUtils.getInt(dataObj, "create", 0));

        return qqTUpdateNumInfo;
    }

    /**
     * 将一条数据更新信息转换成对应的QqTUpdateNumInfo
     * 
     * @param updateNumInfo 数据更新信息字符串
     * @return
     */
    public static QqTUpdateNumInfo transQqTUpdateNumInfo(String updateNumInfo) {
        if (StringUtils.isEmpty(updateNumInfo)) {
            return null;
        }

        try {
            return transQqTUpdateNumInfo(new JSONObject(updateNumInfo));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将验证帐号api返回的结果转换成boolean
     * 
     * @param verifyResultInfoObj 验证信息
     * @return
     */
    public static boolean transVerifyResult(JSONObject verifyResultInfoObj) {
        if (verifyResultInfoObj == null) {
            return false;
        }
        return JSONUtils.getBoolean(verifyResultInfoObj, "verify", false);
    }

    /**
     * 将验证帐号api返回的结果转换成boolean
     * 
     * @param verifyResultInfo 验证信息
     * @return
     */
    public static boolean transVerifyResult(String verifyResultInfo) {
        if (StringUtils.isEmpty(verifyResultInfo)) {
            return false;
        }

        try {
            return transVerifyResult(new JSONObject(verifyResultInfo));
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 将话题id和name转换为对应的map，key为话题id，name为话题名
     * 
     * @param topicInfoObj 话题信息JsonObject
     * @return
     */
    public static Map<String, String> transTopicInfoToMap(JSONObject topicInfoObj) {
        if (topicInfoObj == null) {
            return null;
        }
        JSONObject dataObj = JSONUtils.getJSONObject(topicInfoObj, "data", null);
        if (dataObj == null) {
            return null;
        }
        JSONArray topicInfoArray = JSONUtils.getJSONArray(dataObj, "info", null);
        if (topicInfoArray == null) {
            return null;
        }
        Map<String, String> topicInfoMap = new HashMap<String, String>();
        for (int i = 0; i < topicInfoArray.length(); i++) {
            JSONObject topicInfo = topicInfoArray.optJSONObject(i);
            topicInfoMap.put(JSONUtils.getString(topicInfo, "id", ""), JSONUtils.getString(topicInfo, "text", ""));
        }
        return topicInfoMap;
    }

    /**
     * 将话题id和name转换为对应的map，key为话题id，name为话题名
     * 
     * @param topicInfoStr 话题信息字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transTopicInfoToMap(JSONObject)}</li>
     *         </ul>
     */
    public static Map<String, String> transTopicInfoIntoMap(String topicInfoStr) {
        if (StringUtils.isEmpty(topicInfoStr)) {
            return null;
        }

        try {
            return transTopicInfoToMap(new JSONObject(topicInfoStr));
        } catch (JSONException e) {
            return null;
        }
    }

    /**
     * 将时间线api关联的用户帐户和显示名信息转换为对应的map，key为用户帐户名，name为用户显示名
     * 
     * @param responseObj 用户帐户和显示名信息JsonObject
     * @return
     */
    public static Map<String, String> transQqTrelatedUser(JSONObject responseObj) {
        if (responseObj != null) {
            try {
                JSONObject dataObj = responseObj.getJSONObject("data");
                if (dataObj != null) {
                    JSONObject relatedUserInfoObj = dataObj.getJSONObject("user");
                    if (relatedUserInfoObj != null) {
                        return JSONUtils.parseKeyAndValueToMap(relatedUserInfoObj);
                    }
                }
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 将时间线api关联的用户帐户和显示名信息转换为对应的map，key为用户帐户名，name为用户显示名
     * 
     * @param responseInfo 用户帐户和显示名信息字符串
     * @return
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTTransformUtils#transQqTrelatedUser(JSONObject)}</li>
     *         </ul>
     */
    public static Map<String, String> transQqTrelatedUser(String responseInfo) {
        if (StringUtils.isEmpty(responseInfo)) {
            return null;
        }

        try {
            return transQqTrelatedUser(new JSONObject(responseInfo));
        } catch (JSONException e) {
            return null;
        }
    }

}
