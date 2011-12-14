package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博用户和自己的关系
 * 
 * @author Trinea 2011-11-4 下午11:46:04
 */
public class QqTUserRelation implements Serializable {

    private static final long serialVersionUID = 7154885505952051486L;

    /** 用户帐户名 **/
    private String            userName;
    /** 是否关注了自己 **/
    private boolean           isFan;
    /** 是否被自己关注 **/
    private boolean           isInterested;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isFan() {
        return isFan;
    }

    public void setFan(boolean isFan) {
        this.isFan = isFan;
    }

    public boolean isInterested() {
        return isInterested;
    }

    public void setInterested(boolean isInterested) {
        this.isInterested = isInterested;
    }
}
