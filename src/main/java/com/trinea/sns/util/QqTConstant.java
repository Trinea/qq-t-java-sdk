package com.trinea.sns.util;

public class QqTConstant {

    /** 消息句柄部分 **/
    public final static int    UPDATE_STATUS_SUCC_WHAT               = 70;
    public final static int    UPDATE_STATUS_FAIL_WHAT               = -70;
    public final static int    COMMENT_STATUS_SUCC_WHAT              = 71;
    public final static int    COMMENT_STATUS_FAIL_WHAT              = -71;
    public final static int    REPOST_STATUS_SUCC_WHAT               = 72;
    public final static int    REPOST_STATUS_FAIL_WHAT               = -72;
    public static String       OPERATOR_FAIL_REASON                  = "";

    /** OAuth认证部分 **/
    public final static String GET_REQUEST_TOKEN_URL                 = "http://open.t.qq.com/cgi-bin/request_token";
    public final static String GET_AUTHORIZATION_URL                 = "http://open.t.qq.com/cgi-bin/authorize";
    public final static String GET_ACCESS_TOKEN_URL                  = "http://open.t.qq.com/cgi-bin/access_token";

    /** 每页状态的个数 **/
    public static int          STATUS_COUNT_PER_PAGE                 = 20;

    /** api使用时的标准参数 **/
    public static String       PARA_OAUTH_CONSUMER_KEY               = "oauth_consumer_key";
    public static String       PARA_OAUTH_NONCE                      = "oauth_nonce";
    public static String       PARA_OAUTH_SIGNATURE                  = "oauth_signature";
    public static String       PARA_OAUTH_SIGNATURE_METHOD           = "oauth_signature_method";
    public static String       PARA_OAUTH_TIMESTAMP                  = "oauth_timestamp";
    public static String       PARA_OAUTH_TOKEN                      = "oauth_token";
    public static String       PARA_OAUTH_VERSION                    = "oauth_version";

    /** api使用的部分标准参数值 **/
    public static String       VALUE_OAUTH_VERSION                   = "1.0";
    public static String       VALUE_OAUTH_SIGNATURE_METHOD          = "HMAC-SHA1";

    /** api使用时的其他参数 **/
    public static String       PARA_OAUTH_VERIFIER                   = "oauth_verifier";
    public static String       PARA_OAUTH_TOKEN_SECRET               = "oauth_token_secret";
    public static String       PARA_OAUTH_CALLBACK                   = "oauth_callback";
    public static String       PARA_FORMAT                           = "format";

    /**
     * 微博时间线有关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E6%97%B6%E9%97%B4%E7%BA%BF
     **/
    /** 主页时间线 **/
    public static String       GET_HOME_TL_URL                       = "http://open.t.qq.com/api/statuses/home_timeline";
    /** 广播大厅时间线 **/
    public static String       GET_PUBLIC_TL_URL                     = "http://open.t.qq.com/api/statuses/public_timeline";
    /** 其他用户发表时间线 **/
    public static String       GET_USER_TL_URL                       = "http://open.t.qq.com/api/statuses/user_timeline";
    /** 用户提及时间线 **/
    public static String       GET_MENTIONS_TL_URL                   = "http://open.t.qq.com/api/statuses/mentions_timeline";
    /** 话题时间线 **/
    public static String       GET_TOPIC_TL_URL                      = "http://open.t.qq.com/api/statuses/ht_timeline";
    /** 我发表时间线 **/
    public static String       GET_BROADCAST_TL_URL                  = "http://open.t.qq.com/api/statuses/broadcast_timeline";
    /** 特别收听的人发表时间线 **/
    public static String       GET_SPECIAL_TL_URL                    = "http://open.t.qq.com/api/statuses/special_timeline";
    /** 地区发表时间线 **/
    public static String       GET_AREA_TL_URL                       = "http://open.t.qq.com/api/statuses/area_timeline";
    /** 主页时间线索引 **/
    public static String       GET_HOME_TL_IDS_URL                   = "http://open.t.qq.com/api/statuses/home_timeline_ids";
    /** 其他用户发表时间线索引 **/
    public static String       GET_USER_TL_IDS_URL                   = "http://open.t.qq.com/api/statuses/user_timeline_ids";
    /** 我发表时间线索引 **/
    public static String       GET_BROADCAST_TL_IDS_URL              = "http://open.t.qq.com/api/statuses/broadcast_timeline_ids";
    /** 用户提及时间线索引 **/
    public static String       GET_MENTIONS_TL_IDS_URL               = "http://open.t.qq.com/api/statuses/mentions_timeline_ids";
    /** 多用户发表时间线 **/
    public static String       GET_USERS_TL_URL                      = "http://open.t.qq.com/api/statuses/users_timeline";
    /** 多用户发表时间线索引 **/
    public static String       GET_USERS_TL_IDS_URL                  = "http://open.t.qq.com/api/statuses/users_timeline_ids";
    /** 拉取vip用户发表微博的消息 **/
    public static String       GET_VIP_STATUS_TL_URL                 = "http://open.t.qq.com/api/status/home_timeline_vip";

    /**
     * 微博时间线有关api使用时的部分参数
     **/
    /** 分页标识（0：第一页，1：向下翻页，2向上翻页） **/
    public static String       PARA_PAGE_FLAG                        = "pageflag";
    /** 本页起始时间（第一页 时填0，继续翻页：填上一次请求返回的最后一条记录时间） **/
    public static String       PARA_PAGE_TIME                        = "pagetime";
    /** 第一页 时填0,继续向下翻页，填上一次请求返回的最后一条记录id，翻页用 **/
    public static String       PARA_LAST_ID                          = "lastid";
    /** 需要读取的用户用户名或私信接收者 **/
    public static String       PARA_USER_NAME                        = "name";
    /** 需要读取的一批用户用户名 **/
    public static String       PARA_USER_NAMES                       = "names";
    /** 需要读取的用户open id **/
    public static String       PARA_USER_OPEN_ID                     = "fopenid";
    /** 需要读取的一批用户open id **/
    public static String       PARA_USER_OPEN_IDS                    = "fopenids";
    /** 每次请求记录的条数（1-70条） **/
    public static String       PARA_PAGE_REQ_NUM                     = "reqnum";
    /** 拉取类型, 0x1 原创发表 0x2 转载 0x8 回复 0x10 空回 0x20 提及 0x40 点评 , 如需拉取多个类型请|上(0x1|0x2) 得到3，type=3即可,填零表示拉取所有类型 **/
    public static String       PARA_STATUS_TYPE                      = "type";
    /** 内容过滤 填零表示所有类型 1-带文本 2-带链接 4图片 8-带视频 0x10-带音频 **/
    public static String       PARA_CONTENT_TYPE                     = "contenttype";
    /** 权限标识 1 表示只显示我发表的 **/
    public static String       PARA_ACCESS_LEVEL                     = "accesslevel";
    /** 记录的起始位置（第一次请求是填0，继续请求进填上次返回的pos） **/
    public static String       PARA_POSITION                         = "pos";
    /** 标识0 转播列表，1点评列表 2 点评与转播列表 **/
    public static String       PARA_REPOST_OR_COMMENT_FLAG           = "flag";
    /** 转发或者回复根结点id（源微博id） **/
    public static String       PARA_ROOT_ID                          = "rootid";
    /** 1-100条填0,继续向下翻页，填上一次请求返回的最后一条记录id，翻页用 **/
    public static String       PARA_TWITTER_ID                       = "twitterid";
    /** 获取收藏的微博列表时使用，向下翻页起始时间（第一页 时填0，继续翻页：填上一次请求返回的nexttime时间） **/
    public static String       PARA_NEXT_TIME                        = "nexttime";
    /** 获取收藏的微博列表时使用，向下翻 **/
    public static String       PARA_PREV_TIME                        = "prevtime";

    /**
     * 微博时间线有关api使用时的部分参数值
     **/
    /** {@link QqTConstant#GET_COMMENTS_URL} flag:标识0 转播列表，1点评列表 2 点评与转播列表 **/
    public static int          VALUE_REPOST_FLAG                     = 0;
    public static int          VALUE_COMMENT_FLAG                    = 1;
    public static int          VALUE_REPOST_AND_COMMENT_FLAG         = 2;
    public static int          VALUE_PAGE_REQ_NUM                    = 20;
    public static int          VALUE_FIRST_PAGE                      = 0;
    public static int          VALUE_NEXT_PAGE                       = 1;
    public static int          VALUE_LAST_PAGE                       = 2;

    /**
     * 微博时间线有关api使用时的部分参数值
     **/
    /** 拉取类型, 0x0 拉取所有类型 **/
    public static int          VALUE_STATUS_TYPE_TL_ALL              = 0x0;
    /** 拉取类型, 0x1 原创发表 **/
    public static int          VALUE_STATUS_TYPE_TL_ORIGINAL         = 0x1;
    /** 拉取类型, 0x2 转载 **/
    public static int          VALUE_STATUS_TYPE_TL_REPOST           = 0x2;
    /** 拉取类型, 0x8 回复 **/
    public static int          VALUE_STATUS_TYPE_TL_REPLY            = 0x8;
    /** 拉取类型, 0x10 空回 **/
    public static int          VALUE_STATUS_TYPE_TL_NULL_COMMENT     = 0x10;
    /** 拉取类型, 0x20 提及 **/
    public static int          VALUE_STATUS_TYPE_TL_Mention          = 0x20;
    /** 拉取类型, 0x40 点评 **/
    public static int          VALUE_STATUS_TYPE_TL_COMMENT          = 0x40;

    /**
     * 内容过滤类型 填零表示所有类型 1-带文本 2-带链接 4图片 8-带视频 0x10-带音频
     */
    /** 内容过滤类型, 0x0 拉取所有类型 **/
    public static int          VALUE_CONTENT_TYPE_TL_ALL             = 0x0;
    /** 内容过滤类型, 0x1 带文本 **/
    public static int          VALUE_CONTENT_TYPE_TL_TEXT            = 0x1;
    /** 内容过滤类型, 0x2 带链接 **/
    public static int          VALUE_CONTENT_TYPE_TL_LINK            = 0x2;
    /** 内容过滤类型, 0x4 带图片 **/
    public static int          VALUE_CONTENT_TYPE_TL_PICTURE         = 0x4;
    /** 内容过滤类型, 0x8 带视频 **/
    public static int          VALUE_CONTENT_TYPE_TL_VIDEO           = 0x8;
    /** 内容过滤类型, 0x10 带音频 **/
    public static int          VALUE_CONTENT_TYPE_TL_MUSIC           = 0x10;
    /** 权限标识 1 表示只显示我发表的 **/
    public static int          VALUE_ACCESS_LEVEL_TL_MINE            = 1;

    /**
     * 微博相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    /** 获取一条微博数据 **/
    public static String       GET_STATUS_URL                        = "http://open.t.qq.com/api/t/show";
    /** 发表一条微博　 **/
    public static String       ADD_STATUS_URL                        = "http://open.t.qq.com/api/t/add";
    /** 删除一条微博 **/
    public static String       DELETE_STATUS_URL                     = "http://open.t.qq.com/api/t/del";
    /** 转播一条微博 **/
    public static String       REPOST_STATUS_URL                     = "http://open.t.qq.com/api/t/re_add";
    /** 回复一条微博 **/
    public static String       REPLY_STATUS_URL                      = "http://open.t.qq.com/api/t/reply";
    /** 发表一条带图片的微博 **/
    public static String       ADD_STATUS_WITH_PIC_URL               = "http://open.t.qq.com/api/t/add_pic";
    /** 转播数或点评数 **/
    public static String       GET_REPOST_AND_COMMENT_COUNT_URL      = "http://open.t.qq.com/api/t/re_count";
    /** 获取单条微博的转发或点评列表 **/
    public static String       GET_COMMENTS_URL                      = "http://open.t.qq.com/api/t/re_list";
    /** 点评一条微博 **/
    public static String       COMMENT_STATUS_URL                    = "http://open.t.qq.com/api/t/comment";
    /** 发表音乐微博 **/
    public static String       ADD_MUSIC_STATUS_URL                  = "http://open.t.qq.com/api/t/add_music";
    /** 发表视频微博 **/
    public static String       ADD_VIDEO_STATUS_URL                  = "http://open.t.qq.com/api/t/add_video";
    /** 获取视频信息 **/
    public static String       GET_VIDEO_INFO_URL                    = "http://open.t.qq.com/api/t/getvideoinfo";
    /** 根据微博id批量获取微博内容 **/
    public static String       GET_STATUS_BY_IDS_URL                 = "http://open.t.qq.com/api/t/list";
    /** 获取转播的再次转播数 **/
    public static String       GET_RE_REPOST_COUNT_URL               = "http://open.t.qq.com/api/t/sub_re_count";
    /** 发表心情帖子 **/
    public static String       ADD_EMOTION_STATUS_URL                = "http://open.t.qq.com/api/t/add_emotion";

    /**
     * 微博相关api使用时的部分参数
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    public static String       PARA_CONTENT                          = "content";
    public static String       PARA_LONGITUDE                        = "jing";
    public static String       PARA_LATITUDE                         = "wei";
    public static String       PARA_CLIENT_IP                        = "clientip";
    public static String       PARA_MUSIC_URL                        = "url";
    public static String       PARA_MUSIC_TITLE                      = "title";
    public static String       PARA_MUSIC_AUTHOR                     = "author";
    public static String       PARA_VIDEO_URL                        = "url";
    public static String       PARA_REPLY_ID                         = "reid";
    public static String       PARA_PICTURE                          = "pic";
    public static String       PARA_RE_COUNTIDS                      = "ids";
    public static String       PARA_RE_COUNT_FLAG                    = "flag";
    public static String       PARA_STATUS_IDS                       = "ids";
    public static String       PARA_SIGN_TYPE                        = "signtype";

    /**
     * 微博相关api使用时的部分参数值
     * http://wiki.open.t.qq.com/index.php/%E5%BE%AE%E5%8D%9A%E7%9B%B8%E5%85%B3
     */
    /** 转播数或点评数api,0获取转发计数，1点评计数, 2两者都取 **/
    public static int          VALUE_RE_COUNT_FLAG_REPOST            = 0;
    public static int          VALUE_RE_COUNT_FLAG_COMMENT           = 1;
    public static int          VALUE_RE_COUNT_FLAG_ALL               = 2;

    /** 发表微博api使用时的部分参数值 **/
    public static String       VALUE_FORMAT_JSON                     = "json";
    public static String       VALUE_FORMAT_XML                      = "xml";
    public static String       VALUE_CLIENT_IP                       = "127.0.0.1";

    public static String       PARA_STATUS_ID                        = "id";

    /**
     * 微博相关api返回的json key
     */
    public static String       JSON_VIDEO_MINIPIC                    = "minipic";
    public static String       JSON_VIDEO_PLAYER                     = "player";
    public static String       JSON_VIDEO_REAL                       = "real";
    public static String       JSON_VIDEO_SHORT                      = "short";
    public static String       JSON_VIDEO_TITLE                      = "title";

    /**
     * 微博帐户相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3
     */
    /** 获取自己的详细资料 **/
    public static String       GET_SELF_INFO_URL                     = "http://open.t.qq.com/api/user/info";
    /** 更新用户信息 **/
    public static String       UPDATE_USER_INFO_URL                  = "http://open.t.qq.com/api/user/update";
    /** 更新用户头像信息 **/
    public static String       UPDATE_USER_HEAD_INFO_URL             = "http://open.t.qq.com/api/user/update_head";
    /** 更新用户教育信息 **/
    public static String       UPDATE_USER_EDU_INFO_URL              = "http://open.t.qq.com/api/user/update_edu";
    /** 获取其他人资料 **/
    public static String       GET_OTHER_USER_INFO_URL               = "http://open.t.qq.com/api/user/other_info";
    /** 获取一批人的简单资料 **/
    public static String       GET_OTHER_USERS_INFO_URL              = "http://open.t.qq.com/api/user/infos";
    /** 获取一批人的简单资料 **/
    public static String       GET_SEVERAL_USER_INFOS_URL            = "http://open.t.qq.com/api/user/infos";
    /** 验证账户是否合法 **/
    public static String       VERIFY_ACCOUNT_URL                    = "http://open.t.qq.com/api/user/verify";

    /** 微博帐户相关api使用时的部分参数 **/
    public static String       PARA_NICK                             = "nick";
    public static String       PARA_SEX                              = "sex";
    public static String       PARA_BIRTH_YEAR                       = "year";
    public static String       PARA_BIRTH_MONTH                      = "month";
    public static String       PARA_BIRTH_DAY                        = "day";
    public static String       PARA_COUNTRY_CODE                     = "countrycode";
    public static String       PARA_PROVINCE_CODE                    = "provincecode";
    public static String       PARA_CITY_CODE                        = "citycode";
    public static String       PARA_INTRODUCTION                     = "introduction";
    public static String       PARA_USER_ICON                        = "pic";
    public static String       PARA_USER_EDU_FEILD_ID                = "feildid";
    public static String       PARA_USER_EDU_YEAR                    = "year";
    public static String       PARA_USER_EDU_SCHOOL_ID               = "schoolid";
    public static String       PARA_USER_EDU_DEPARTMENT_ID           = "departmentid";
    public static String       PARA_USER_EDU_LEVEL                   = "level";
    public static String       PARA_VERIFY_ACCOUNT_NAME              = "name";
    public static String       PARA_VERIFY_ACCOUNT_ID                = "fopenid";

    /**
     * 微博关系链相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E5%85%B3%E7%B3%BB%E9%93%BE%E7%9B%B8%E5%85%B3
     */
    /** 我的听众列表 **/
    public static String       GET_SELF_FANS_URL                     = "http://open.t.qq.com/api/friends/fanslist";
    /** 我的听众姓名列表 **/
    public static String       GET_SELF_FANS_NAMES_URL               = "http://open.t.qq.com/api/friends/fanslist_name";
    /** 我收听的人列表 **/
    public static String       GET_SELF_INTERESTED_URL               = "http://open.t.qq.com/api/friends/idollist";
    /** 我收听的人姓名列表 **/
    public static String       GET_SELF_INTERESTED_NAMES_URL         = "http://open.t.qq.com/api/friends/idollist_name";
    /** 黑名单列表 **/
    public static String       GET_SELF_BLACK_LIST_URL               = "http://open.t.qq.com/api/friends/blacklist";
    /** 我的听众列表，简单信息（200个） **/
    public static String       GET_SELF_FANS_SIMPLE_URL              = "http://open.t.qq.com/api/friends/fanslist_s";
    /** 我的收听列表，简单信息（200个） **/
    public static String       GET_SELF_INTERESTED_SIMPLE_URL        = "http://open.t.qq.com/api/friends/idollist_s";
    /** 特别收听列表 **/
    public static String       GET_SELF_SPECIAL_INTERESTED_URL       = "http://open.t.qq.com/api/friends/speciallist";
    /** 收听某个用户 **/
    public static String       ADD_FRIEND_URL                        = "http://open.t.qq.com/api/friends/add";
    /** 取消收听某个用户 **/
    public static String       DELETE_FRIEND_URL                     = "http://open.t.qq.com/api/friends/del";
    /** 特别收听某个用户 **/
    public static String       ADD_SPECIAL_FRIEND_URL                = "http://open.t.qq.com/api/friends/addspecial";
    /** 取消特别收听某个用户 **/
    public static String       DELETE_SPECIAL_FRIEND_URL             = "http://open.t.qq.com/api/friends/delspecial";
    /** 添加某个用户到黑名单 **/
    public static String       ADD_OTHER_TO_BLACK_LIST_URL           = "http://open.t.qq.com/api/friends/addblacklist";
    /** 从黑名单中删除某个用户 **/
    public static String       DELETE_OTHER_FROM_BLACK_LIST_URL      = "http://open.t.qq.com/api/friends/delblacklist";
    /** 检测是否我的听众或收听的人 **/
    public static String       CHECK_RELATION_WITH_SELF_URL          = "http://open.t.qq.com/api/friends/check";
    /** 其他帐户听众列表 **/
    public static String       GET_OTHER_USER_FANS_URL               = "http://open.t.qq.com/api/friends/user_fanslist";
    /** 其他帐户收听的人列表 **/
    public static String       GET_OTHER_USER_INTERESTED_URL         = "http://open.t.qq.com/api/friends/user_idollist";
    /** 其他帐户特别收听的人列表 **/
    public static String       GET_OTHER_USER_SPECIAL_INTERESTED_URL = "http://open.t.qq.com/api/friends/user_speciallist";
    /** 互听关系链列表 **/
    public static String       GET_Mutual_INTERESTED_URL             = "http://open.t.qq.com/api/friends/mutual_list";

    /** 微博关系链相关api使用时的部分参数 **/
    /** 请求个数 **/
    public static String       PARA_REQ_NUM                          = "reqnum";
    /** 起始位置(第一页填0，继续向下翻页，填：[reqnum*(page-1)]) **/
    public static String       PARA_START_INDEX                      = "startindex";
    /** 用户帐户名（可选） **/
    public static String       PARA_RELATION_USER_NAMES              = "names";
    /** 用户openid(可选),name和fopenid至少选一个，若同时存在则以name值为主 **/
    public static String       PARA_RELATION_USER_OPEN_ID            = "fopenid";
    /** 用户openids(可选),name和fopenids至少选一个，若同时存在则以name值为主 **/
    public static String       PARA_RELATION_USER_OPEN_IDS           = "fopenids";
    /** **/
    public static String       PARA_RELATION_FLAG                    = "flag";

    /** 微博关系链相关api使用时的部分参数 值 **/
    /** 检测听众标志 **/
    public static int          VALUE_FANS_RELATION_FLAG              = 0;
    /** 检测收听的人标志 **/
    public static int          VALUE_INTERESTED_RELATION_FLAG        = 1;
    /** 两种关系都检测标志 **/
    public static int          VALUE_BOTH_RELATION_FLAG              = 2;

    /**
     * 微博私信相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3
     */
    /** 发私信 **/
    public static String       SEND_MESSAGE_URL                      = "http://open.t.qq.com/api/private/add";
    /** 删除一条私信 **/
    public static String       DELETE_MESSAGE_URL                    = "http://open.t.qq.com/api/private/del";
    /** 收件箱 **/
    public static String       GET_RECEIVE_MESSAGES_URL              = "http://open.t.qq.com/api/private/recv";
    /** 发件箱 **/
    public static String       GET_SEND_MESSAGES_URL                 = "http://open.t.qq.com/api/private/send";

    /**
     * 微博搜索相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E6%90%9C%E7%B4%A2%E7%9B%B8%E5%85%B3
     */
    /** 搜索用户 **/
    public static String       SEARCH_USER_URL                       = "http://open.t.qq.com/api/search/user";
    /** 搜索微博 **/
    public static String       SEARCH_STATUS_URL                     = "http://open.t.qq.com/api/search/t";
    /** 通过标签搜索用户 **/
    public static String       SEARCH_USER_BY_TAG_URL                = "http://open.t.qq.com/api/search/userbytag";

    /**
     * 微博搜索相关api使用时的部分参数
     **/
    /** 搜索关键字 **/
    public static String       PARA_KEYWORD                          = "keyword";
    /** 每页大小 **/
    public static String       PARA_PAGE_SIZE                        = "pagesize";
    /** 页码 **/
    public static String       PARA_PAGE                             = "page";

    /**
     * 微博热度，趋势相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E7%83%AD%E5%BA%A6%EF%BC%8C%E8%B6%8B%E5%8A%BF
     */
    /** 话题热榜 **/
    public static String       GET_HOT_TOPICS_URL                    = "http://open.t.qq.com/api/trends/ht";
    /** 转播热榜 **/
    public static String       GET_HOT_REPOSTS_URL                   = "http://open.t.qq.com/api/trends/t";

    /**
     * 微博热度，趋势相关api使用时的部分参数
     **/
    /** 请求类型 1 话题名，2 搜索关键字 3 两种类型都有 **/
    public static String       PARA_HOT_SEARCH_TYPE                  = "type";
    /** 请求个数 **/
    public static String       PARA_REQ_NUMBER                       = "reqnum";
    /** 请求位置，第一次请求时填0，继续填上次返回的pos **/
    public static String       PARA_LAST_POSITION                    = "pos";

    /**
     * 微博数据更新相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E6%95%B0%E6%8D%AE%E6%9B%B4%E6%96%B0%E7%9B%B8%E5%85%B3/%E6%9F%A5%E7%9C%8B%E6%
     * 95%B0%E6%8D%AE%E6%9B%B4%E6%96%B0%E6%9D%A1%E6%95%B0
     */
    /** 查看数据更新条数 **/
    public static String       GET_UPDATE_INFO_NUM_URL               = "http://open.t.qq.com/api/info/update";

    /**
     * 微博数据更新相关api使用时的部分参数
     **/
    /** 请求类型 0：只请求更新数，不清除更新数，1：请求更新数，并对更新数清零 **/
    public static String       PARA_REQ_TYPE                         = "op";
    /** 5 首页未读消息记数，61-100条记数 7 私信页消息计数 8 新增听众数 9 首页广播数（原创的） **/
    public static String       PARA_CLEAR_TYPE                       = "type";

    /** 微博数据更新相关api使用时的部分参数值 **/
    /**
     * 5-首页未读消息计数，6-@页未读消息计数，7-私信页消息计数，8-新增听众数，9-首页广播数（原创的）
     */
    /** 微博数据更新 5-首页未读消息计数 **/
    public static int          VALUE_CLEAR_TYPE_HOME_PAGE            = 5;
    /** 微博数据更新 6-@页未读消息计数 **/
    public static int          VALUE_CLEAR_TYPE_AT                   = 6;
    /** 微博数据更新 7-私信页消息计数 **/
    public static int          VALUE_CLEAR_TYPE_PRIVATE_MSG          = 7;
    /** 微博数据更新 8-新增听众数 **/
    public static int          VALUE_CLEAR_TYPE_NEW_FANS             = 8;
    /** 微博数据更新 9-首页广播数（原创的） **/
    public static int          VALUE_CLEAR_TYPE_HOME_BROADCAST       = 9;

    /**
     * 微博数据收藏相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E6%95%B0%E6%8D%AE%E6%94%B6%E8%97%8F
     */
    /** 收藏一条微博 **/
    public static String       COLLECT_STATUS_URL                    = "http://open.t.qq.com/api/fav/addt";
    /** 取消收藏一条微博 **/
    public static String       UNCOLLECT_STATUS_URL                  = "http://open.t.qq.com/api/fav/delt";
    /** 收藏的微博列表 **/
    public static String       GET_COLLECT_STATUS_URL                = "http://open.t.qq.com/api/fav/list_t";
    /** 订阅话题 **/
    public static String       SUBSCRIBE_TOPIC_URL                   = "http://open.t.qq.com/api/fav/addht";
    /** 取消订阅话题 **/
    public static String       UNSUBSCRIBE_TOPIC_URL                 = "http://open.t.qq.com/api/fav/delht";
    /** 获取已订阅话题列表 **/
    public static String       GET_SUBSCRIBE_TOPICS_URL              = "http://open.t.qq.com/api/fav/list_ht";

    /**
     * 微博话题相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E8%AF%9D%E9%A2%98%E7%9B%B8%E5%85%B3
     */
    /** 根据话题名称查询话题id **/
    public static String       GET_TOPIC_ID_URL                      = "http://open.t.qq.com/api/ht/ids";
    /** 根据话题id获取话题相关信息 **/
    public static String       GET_TOPIC_INFO_URL                    = "http://open.t.qq.com/api/ht/info";

    /**
     * 微博话题相关api使用时的部分参数
     **/
    /** 话题名字列表（abc,efg,） **/
    public static String       PARA_TOPIC_NAMES                      = "httexts";
    /** 话题id列表，以逗号分隔，如12345,12345 **/
    public static String       PARA_TOPIC_IDS                        = "ids";

    /**
     * 微博标签相关api使用时的url
     * http://wiki.open.t.qq.com/index.php/%E8%AF%9D%E9%A2%98%E7%9B%B8%E5%85%B3
     */
    /** 添加标签 **/
    public static String       ADD_TAG_URL                           = "http://open.t.qq.com/api/tag/add";
    /** 删除标签 **/
    public static String       DELETE_TAG_URL                        = "http://open.t.qq.com/api/tag/del";

    /**
     * 微博标签相关api使用时的部分参数
     **/
    /** 标签内容 **/
    public static String       PARA_TAG_NAME                         = "tag";
    /** 标签id **/
    public static String       PARA_TAG_ID                           = "tagid";

    /** mac 编码时的算法 **/
    public static String       MAC_ALGORITHM                         = "HmacSHA1";
    /** 编码时的encoding字符集 **/
    public static String       MAC_ENCODING                          = "US-ASCII";

    /** api 返回的部分参数 **/
    public static String       RET_PARA_MSG                          = "msg";
    public static String       RET_PARA_RET                          = "ret";

    /** api 返回的部分参数正常值 **/
    public static String       RET_VALUE_MSG                         = "ok";
    public static int          RET_VALUE_RET                         = 0;

    /** api 返回的json传中的字段 **/

    /** 返回头像图片大小限制， 包括20、30、40、50、100，见http://open.t.qq.com/resource.php?i=2,1#faq_common 第5条 **/
    public static int          HEAD_ICON_SIZE_20                     = 20;
    public static int          HEAD_ICON_SIZE_30                     = 30;
    public static int          HEAD_ICON_SIZE_40                     = 40;
    public static int          HEAD_ICON_SIZE_50                     = 50;
    public static int          HEAD_ICON_SIZE_100                    = 100;

    /** 返回图片的大小限制，包括120、160、460、2000，见http://open.t.qq.com/resource.php?i=2,1#faq_common 第6条 **/
    public static int          IMAGE_SIZE_60                         = 60;
    public static int          IMAGE_SIZE_120                        = 120;
    public static int          IMAGE_SIZE_240                        = 240;
    public static int          IMAGE_SIZE_460                        = 460;
    public static int          IMAGE_SIZE_2000                       = 2000;

    /**
     * api返回的状态类型
     * 1-原创发表、2-转载、3-私信 4-回复 5-空回 6-提及 7-评论
     **/
    public static int          VALUE_STATUS_TYPE_ORIGINAL            = 1;
    public static int          VALUE_STATUS_TYPE_REPOST              = 2;
    public static int          VALUE_STATUS_TYPE_PRIVATE_MSG         = 3;
    public static int          VALUE_STATUS_TYPE_REPLY               = 4;
    public static int          VALUE_STATUS_TYPE_NULL_COMMENT        = 5;
    public static int          VALUE_STATUS_TYPE_Mention             = 6;
    public static int          VALUE_STATUS_TYPE_COMMENT             = 7;
}
