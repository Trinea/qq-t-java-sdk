package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博话题简单信息
 * 
 * @author Trinea 2011-11-7 上午11:50:09
 */
public class QqTTopicSimple implements Serializable {

    private static final long serialVersionUID = -3327396691040485066L;

    /** 话题关键字 **/
    private String            name;
    /** 0用话题接口拉数据 1用搜索接口拉数据 **/
    private int               type;
    /** 搜索关键字 **/
    private String            keyWords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
