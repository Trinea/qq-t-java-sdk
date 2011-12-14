package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.trinea.java.common.MapUtils;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博时间线相关api的参数，对于一个api不一定能使用到所有参数
 * <ul>
 * <li>为了方便读取及写入，很多long或int类型都用String表示</li>
 * </ul>
 * 
 * @author gengxin.wugx 2011-9-29 下午20:02:43
 */
public class QqTTimelinePara implements Serializable {

    private static final long serialVersionUID           = 4318704342139880029L;

    /** 返回数据的格式 **/
    private String            format;

    /** 分页标识（0：第一页，1：向下翻页，2向上翻页） **/
    private int               pageFlag;

    /** 本页起始时间（第一页 时填0，继续翻页：填上一次请求返回的最后一条记录时间），以秒为单位 **/
    private long              pageTime;

    /** 第一页 时填0,继续向下翻页，填上一次请求返回的最后一条记录id，翻页用 **/
    private long              lastId;

    /** 需要读取的用户用户名或私信接收者 **/
    private String            userName;

    /** 需要读取的用户open id **/
    private String            userOpenId;

    /** 每次请求记录的条数（1-70条） **/
    private int               pageReqNum;

    /** 拉取类型, 0x1 原创发表 0x2 转载 0x8 回复 0x10 空回 0x20 提及 0x40 点评 , 如需拉取多个类型请|上(0x1|0x2) 得到3，type=3即可,填零表示拉取所有类型 **/
    private int               statusType;

    /** 内容过滤 填零表示所有类型 1-带文本 2-带链接 4图片 8-带视频 0x10-带音频 **/
    private int               contentType;

    /** 权限标识 1 表示只显示我发表的 **/
    private int               accessLevel;

    /** 记录的起始位置（第一次请求是填0，继续请求进填上次返回的pos） **/
    private long              position;

    /** 标识0 转播列表，1点评列表 2 点评与转播列表 **/
    private int               repostOrCommentFlag;

    /** 转发或者回复根结点id（源微博id） **/
    private long              rootId;

    /** 1-100条填0,继续向下翻页，填上一次请求返回的最后一条记录id，翻页用 **/
    private long              twitterId;

    /** 获取收藏的微博列表时使用，向下翻页起始时间（第一页 时填0，继续翻页：填上一次请求返回的nexttime时间） **/
    private long              nextTime;

    /** 获取收藏的微博列表时使用，向下翻 **/
    private long              prevTime;

    /** 默认值 **/
    private static String     defaultFormat              = "";
    private static int        defaultPageFlag            = -1;
    private static long       defaultPageTime            = -1;
    private static long       defaultLastId              = -1;
    private static String     defaultUsername            = "";
    private static String     defaultUserOpenId          = "";
    private static int        defaultPageReqNum          = -1;
    private static int        defaultStatusType          = -1;
    private static int        defaultContentType         = -1;
    private static long       defaultPosiition           = -1;
    private static int        defaultAccessLevel         = -1;
    private static int        defaultRepostOrCommentFlag = -1;
    private static long       defaultRootId              = -1;
    private static long       defaultTwitterId           = -1;
    private static long       defaultNextTime            = -1;
    private static long       defaultPrevTime            = -1;

    public QqTTimelinePara(){
        super();

        this.format = defaultFormat;
        this.pageFlag = defaultPageFlag;
        this.pageTime = defaultPageTime;
        this.lastId = defaultLastId;
        this.userName = defaultUsername;
        this.userOpenId = defaultUserOpenId;
        this.pageReqNum = defaultPageReqNum;
        this.statusType = defaultStatusType;
        this.contentType = defaultContentType;
        this.accessLevel = defaultAccessLevel;
        this.position = defaultPosiition;
        this.repostOrCommentFlag = defaultRepostOrCommentFlag;
        this.rootId = defaultRootId;
        this.twitterId = defaultTwitterId;
        this.nextTime = defaultNextTime;
        this.prevTime = defaultPrevTime;
    }

    /**
     * 将页数转换为pageFlag，默认页数大于1表示向下翻页
     * 
     * @param page 页数
     * @return
     */
    public int transformPageToPageFlag(int page) {
        return transformPageToPageFlag(page, true);
    }

    /**
     * 将页数转换为pageFlag
     * 
     * @param page 页数
     * @param pageDown 是否向下翻页
     * @return
     *         <ul>
     *         <li>page 小于等于0，返回首页标志</li>
     *         <li>若page大于0，pageDown为true， page等于1，返回首页标志，否则返回下页标志</li>
     *         <li>若page大于0，pageDown为false， page等于1，返回首页标志，否则返回上页标志</li>
     *         </ul>
     */
    public int transformPageToPageFlag(int page, boolean pageDown) {
        if (page <= 0) {
            return QqTConstant.VALUE_FIRST_PAGE;
        }
        if (pageDown) {
            return (page == 1) ? QqTConstant.VALUE_FIRST_PAGE : QqTConstant.VALUE_NEXT_PAGE;
        } else {
            return (page == 1) ? QqTConstant.VALUE_FIRST_PAGE : QqTConstant.VALUE_LAST_PAGE;
        }
    }

    /**
     * 得到复合类型的statusType
     * multiStatusType({@link QqTConstant#VALUE_STATUS_TYPE_COMMENT}, {@link QqTConstant#VALUE_STATUS_TYPE_Mention})
     * 
     * @param statusType 可以传入多个type
     * @return
     */
    public String multiStatusType(int... statusType) {
        int totalType = 0;
        for (int type : statusType) {
            totalType |= type;
        }
        return Integer.toString(totalType);
    }

    /**
     * 复制对象
     * 
     * @param source 源对象
     * @return
     */
    public QqTTimelinePara copy(QqTTimelinePara source) {
        QqTTimelinePara destin = new QqTTimelinePara();
        destin.format = source.format;
        destin.pageFlag = source.pageFlag;
        destin.pageTime = source.pageTime;
        destin.lastId = source.lastId;
        destin.userName = source.userName;
        destin.userOpenId = source.userOpenId;
        destin.pageReqNum = source.pageReqNum;
        destin.statusType = source.statusType;
        destin.contentType = source.contentType;
        destin.accessLevel = source.accessLevel;
        destin.position = source.position;
        destin.rootId = source.rootId;
        destin.twitterId = source.twitterId;
        destin.nextTime = source.nextTime;
        destin.prevTime = source.prevTime;
        return destin;
    }

    /**
     * 将时间线对象转换为api需要的map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        Map<String, String> parasMap = new HashMap<String, String>();
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_FORMAT, format);
        if (pageFlag >= 0) {
            parasMap.put(QqTConstant.PARA_PAGE_FLAG, Integer.toString(pageFlag));
        }
        if (pageTime >= 0) {
            parasMap.put(QqTConstant.PARA_PAGE_TIME, Long.toString(pageTime));
        }
        if (lastId >= 0) {
            parasMap.put(QqTConstant.PARA_LAST_ID, Long.toString(lastId));
        }
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_OPEN_ID, userOpenId);
        if (pageReqNum >= 0) {
            parasMap.put(QqTConstant.PARA_PAGE_REQ_NUM, Integer.toString(pageReqNum));
        }
        if (statusType >= 0) {
            parasMap.put(QqTConstant.PARA_STATUS_TYPE, Integer.toString(statusType));
        }
        if (contentType >= 0) {
            parasMap.put(QqTConstant.PARA_CONTENT_TYPE, Integer.toString(contentType));
        }
        if (accessLevel >= 0) {
            parasMap.put(QqTConstant.PARA_ACCESS_LEVEL, Integer.toString(accessLevel));
        }
        if (position >= 0) {
            parasMap.put(QqTConstant.PARA_POSITION, Long.toString(position));
        }
        if (repostOrCommentFlag >= 0) {
            parasMap.put(QqTConstant.PARA_REPOST_OR_COMMENT_FLAG, Long.toString(repostOrCommentFlag));
        }
        if (rootId >= 0) {
            parasMap.put(QqTConstant.PARA_ROOT_ID, Long.toString(rootId));
        }
        if (twitterId >= 0) {
            parasMap.put(QqTConstant.PARA_TWITTER_ID, Long.toString(twitterId));
        }
        if (nextTime >= 0) {
            parasMap.put(QqTConstant.PARA_NEXT_TIME, Long.toString(nextTime));
        }
        if (prevTime >= 0) {
            parasMap.put(QqTConstant.PARA_PREV_TIME, Long.toString(prevTime));
        }
        return parasMap;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPageFlag() {
        return pageFlag;
    }

    public void setPageFlag(int pageFlag) {
        this.pageFlag = pageFlag;
    }

    public void setPageFlagByPage(int page) {
        this.pageFlag = transformPageToPageFlag(page);
    }

    public long getPageTime() {
        return pageTime;
    }

    public void setPageTime(long pageTime) {
        this.pageTime = pageTime;
    }

    public long getLastId() {
        return lastId;
    }

    public void setLastId(long lastId) {
        this.lastId = lastId;
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

    public int getPageReqNum() {
        return pageReqNum;
    }

    public void setPageReqNum(int pageReqNum) {
        this.pageReqNum = pageReqNum;
    }

    public int getStatusType() {
        return statusType;
    }

    public void setStatusType(int statusType) {
        this.statusType = statusType;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public void setRepostOrCommentFlag(int repostOrCommentFlag) {
        this.repostOrCommentFlag = repostOrCommentFlag;
    }

    public int getRepostOrCommentFlag() {
        return repostOrCommentFlag;
    }

    public long getRootId() {
        return rootId;
    }

    public void setRootId(long rootId) {
        this.rootId = rootId;
    }

    public long getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(long twitterId) {
        this.twitterId = twitterId;
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
}
