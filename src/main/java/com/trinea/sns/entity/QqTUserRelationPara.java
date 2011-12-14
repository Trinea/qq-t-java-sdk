package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.trinea.java.common.MapUtils;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博关系链相关参数
 * http://wiki.open.t.qq.com/index.php/%E5%85%B3%E7%B3%BB%E9%93%BE%E7%9B%B8%E5%85%B3
 * 
 * @author Trinea 2011-10-29 下午05:02:15
 */
public class QqTUserRelationPara implements Serializable {

    private static final long serialVersionUID  = 3298635316340763420L;

    /** 返回数据的格式 **/
    private String            format;
    /** 用户帐户名 **/
    private String            userName;
    /** 用户open id **/
    private String            userOpenId;
    /** 请求个数 **/
    private int               reqNumber;
    /** 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1)) **/
    private int               startIndex;

    /** 默认值 **/
    private static String     defaultFormat     = "";
    private static String     defaultUserName   = "";
    private static String     defaultUserOpenId = "";
    private static int        defaultReqNumber  = -1;
    private static int        defaultStartIndex = -1;

    public QqTUserRelationPara(){
        super();

        this.format = defaultFormat;
        this.userName = defaultUserName;
        this.userOpenId = defaultUserOpenId;
        this.reqNumber = defaultReqNumber;
        this.startIndex = defaultStartIndex;
    }

    /**
     * 将关系链相关参数对象转换为api需要的map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        Map<String, String> parasMap = new HashMap<String, String>();
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_ID, userOpenId);
        if (reqNumber >= 0) {
            parasMap.put(QqTConstant.PARA_REQ_NUM, Integer.toString(reqNumber));
        }
        if (startIndex >= 0) {
            parasMap.put(QqTConstant.PARA_START_INDEX, Integer.toString(startIndex));
        }
        return parasMap;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public int getReqNumber() {
        return reqNumber;
    }

    public void setReqNumber(int reqNumber) {
        this.reqNumber = reqNumber;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
