package com.trinea.sns.entity;

import java.io.Serializable;

import com.trinea.java.common.StringUtils;

/**
 * 腾讯微博 应用和token实体类，主要用在api中
 * 
 * @author Trinea 2011-9-25 下午11:41:38
 */
public class QqTAppAndToken implements Serializable {

    private static final long serialVersionUID = 5951645915037611059L;

    /** 应用key **/
    private String            appKey;
    /** 应用密码 **/
    private String            appSecret;
    /** access token **/
    private String            accessToken;
    /** token 密码 ，可为空 **/
    private String            tokenSecret;

    /**
     * 检验是否合法
     * 
     * @return
     */
    public boolean isValid() {
        return !(StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret) || StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(tokenSecret));
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }
}
