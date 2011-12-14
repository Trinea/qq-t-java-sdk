package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博api，新增、删除等api返回结果中的data部分
 * 
 * @author Trinea 2011-11-14 上午12:06:25
 */
public class QqTIdAndTime implements Serializable {

    private static final long serialVersionUID = -2007975028984227555L;

    /**
     * 对于微博相关api，表示微博id
     * 对于标签相关api，表示标签id
     * 对于私信相关api，表示私信id
     **/
    private long              id;

    /** 操作完成时间 **/
    private long              timeStamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
