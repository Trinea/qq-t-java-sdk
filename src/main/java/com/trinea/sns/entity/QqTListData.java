package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 腾讯微博api，时间线、用户列表等api返回结果中的data部分
 * 
 * @author Trinea 2011-11-13 下午11:34:35
 */
public class QqTListData implements Serializable {

    private static final long   serialVersionUID = -7545241973832906747L;

    /** 服务器时间戳，不能用于翻页 **/
    private long                timeStamp;

    /**
     * 是否还有内容可以拉取，0表示还有微博可拉取 ，1已拉取完毕
     * 对话题时间线api 2表示不能往上翻 1 表示不能往下翻，0表示两边都可以翻 3表示两边都不能翻了
     **/
    private int                 hasNext;

    /**
     * 信息列表
     * 对时间线api表示微博列表
     * 对用户信息api表示用户列表
     **/
    private List<?>             info;

    /** 时间线api 记录的起始位置（第一次请求是填0，继续请求进填上次返回的pos） **/
    private long                position;

    /** 互听关系链列表api 起始位置（第一次请求是填0，继续请求进填上次返回的nextstartpos） **/
    private long                positionForMutualList;

    /** 时间线api 所有记录的总数 **/
    private long                totalNumber;

    /** 话题时间线api 分页标识（第一页 填空，继续翻页：填上上次返回的 pageinfo） **/
    private String              pageInfo;

    /** 话题时间线api 是否收藏 ，1是 0否 **/
    private boolean             isColloct;

    /** 话题时间线api 话题id **/
    private long                topicId;

    /** 收藏的微博列表 api 向下翻页起始时间（第一页 时填0，继续翻页：填上一次请求返回的nexttime时间） **/
    private long                nextTime;

    /** 收藏的微博列表 api 向上翻页起始时间（第一页 时填0，继续翻页：填上一次请求返回的prevTime时间） **/
    private long                prevTime;

    /** 对于搜索微博api，表示搜索花费的时间 **/
    private long                costTime;

    /** 时间线api返回的数据涉及到的用户的帐号与昵称映射 **/
    private Map<String, String> relatedUser;

    /** 是否还有信息可以拉取 **/
    public boolean hastNext() {
        return this.hasNext == 0;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getHasNext() {
        return hasNext;
    }

    public void setHasNext(int hasnext) {
        this.hasNext = hasnext;
    }

    public List<?> getInfo() {
        return info;
    }

    public void setInfo(List<?> info) {
        this.info = info;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public void setPositionForMutualList(long positionForMutualList) {
        this.positionForMutualList = positionForMutualList;
    }

    public long getPositionForMutualList() {
        return positionForMutualList;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public boolean isColloct() {
        return isColloct;
    }

    public void setColloct(boolean isColloct) {
        this.isColloct = isColloct;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getNextTime() {
        return nextTime;
    }

    public void setNextTime(long nextTime) {
        this.nextTime = nextTime;
    }

    public long getPrevTime() {
        return prevTime;
    }

    public void setPrevTime(long prevTime) {
        this.prevTime = prevTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setRelatedUser(Map<String, String> relatedUser) {
        this.relatedUser = relatedUser;
    }

    public Map<String, String> getRelatedUser() {
        return relatedUser;
    }
}
