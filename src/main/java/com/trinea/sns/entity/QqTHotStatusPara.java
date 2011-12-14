package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.trinea.java.common.MapUtils;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博热度、趋势信息参数
 * http://wiki.open.t.qq.com/index.php/%E7%83%AD%E5%BA%A6%EF%BC%8C%E8%B6%8B%E5%8A%BF/%E8%AF%9D%E9%A2%98%E7%83%AD%E6%A6%9
 * C
 * 
 * @author Trinea 2011-11-5 下午07:36:12
 */
public class QqTHotStatusPara implements Serializable {

    private static final long serialVersionUID    = -989824436462485204L;

    /** 返回数据的格式 **/
    private String            format;

    /**
     * 请求类型
     * 对于话题而言 1 话题名，2 搜索关键字 3 两种类型都有
     * 对于转播热榜而言 0x1-带文本 0x2-带链接 0x4图片 0x8-带视频
     * 如需拉取多个类型请使用|，如(0x1|0x2)得到3，此时type=3即可，填零表示拉取所有类型
     **/
    private String            type;

    /** 请求个数（最多20） **/
    private int               reqNum;

    /** 请求位置，第一次请求时填0，继续填上次返回的pos **/
    private int               lastPosition;

    /** 默认值 **/
    private static String     defaultFormat       = "";
    private static String     defaultType         = "";
    private static int        defaultReqNum       = -1;
    private static int        defaultLastPosition = -1;

    public QqTHotStatusPara(){
        super();

        this.format = defaultFormat;
        this.type = defaultType;
        this.reqNum = defaultReqNum;
        this.lastPosition = defaultLastPosition;
    }

    /**
     * 将热度、趋势信息参数对象转换为api需要的map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        Map<String, String> parasMap = new HashMap<String, String>();
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_HOT_SEARCH_TYPE, type);
        if (reqNum >= 0) {
            parasMap.put(QqTConstant.PARA_REQ_NUMBER, Integer.toString(reqNum));
        }
        if (lastPosition >= 0) {
            parasMap.put(QqTConstant.PARA_LAST_POSITION, Integer.toString(lastPosition));
        }
        return parasMap;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReqNum() {
        return reqNum;
    }

    public void setReqNum(int reqNum) {
        this.reqNum = reqNum;
    }

    public int getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }
}
