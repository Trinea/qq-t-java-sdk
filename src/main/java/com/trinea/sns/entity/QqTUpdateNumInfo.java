package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博数据更新条数信息
 * 
 * @author Trinea 2011-10-8 下午11:45:09
 */
public class QqTUpdateNumInfo implements Serializable {

    private static final long serialVersionUID = -1884964385784308153L;

    /** 首页更新数 **/
    private int               home;
    /** 私信更新数 **/
    private int               privateMessage;
    /** 听众更新数 **/
    private int               fans;
    /** 提及我的 **/
    private int               mentions;
    /** 首页广播（原创）更新数 **/
    private int               create;

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getPrivateMessage() {
        return privateMessage;
    }

    public void setPrivateMessage(int privateMessage) {
        this.privateMessage = privateMessage;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getMentions() {
        return mentions;
    }

    public void setMentions(int mentions) {
        this.mentions = mentions;
    }

    public int getCreate() {
        return create;
    }

    public void setCreate(int create) {
        this.create = create;
    }
}
