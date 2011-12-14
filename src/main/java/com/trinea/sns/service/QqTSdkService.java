package com.trinea.sns.service;

import java.util.List;
import java.util.Map;

import com.trinea.sns.entity.QqTAppAndToken;
import com.trinea.sns.entity.QqTHotStatusPara;
import com.trinea.sns.entity.QqTResponse;
import com.trinea.sns.entity.QqTSearchPara;
import com.trinea.sns.entity.QqTStatus;
import com.trinea.sns.entity.QqTStatusInfoPara;
import com.trinea.sns.entity.QqTTimelinePara;
import com.trinea.sns.entity.QqTTopicSimple;
import com.trinea.sns.entity.QqTUpdateNumInfo;
import com.trinea.sns.entity.QqTUser;
import com.trinea.sns.entity.QqTUserEduPara;
import com.trinea.sns.entity.QqTUserPara;
import com.trinea.sns.entity.QqTUserRelation;
import com.trinea.sns.entity.QqTUserRelationPara;
import com.trinea.sns.entity.QqTVideoInfo;
import com.trinea.sns.util.QqTConstant;

public interface QqTSdkService {

    /**
     * 得到应用和用户相关信息
     * 
     * @return
     */
    public QqTAppAndToken getQqTAppAndToken();

    /**
     * 设置应用和用户相关信息
     * 
     * @param qqTAppAndToken
     */
    public void setQqTAppAndToken(QqTAppAndToken qqTAppAndToken);

    /**
     * 时间线通用api返回，字符串返回
     * <ul>
     * <li>{@link QqTTimelinePara#setFormat(String)}可取值有{@link QqTConstant#VALUE_FORMAT_JSON}以及
     * {@link QqTConstant#VALUE_FORMAT_XML}</li>
     * <li>{@link QqTTimelinePara#setStatusType(int)}可取值有{@link QqTConstant#VALUE_STATUS_TYPE_TL_ALL}，
     * {@link QqTConstant#VALUE_STATUS_TYPE_TL_COMMENT}以及QqTConstant中其他{@code VALUE_STATUS_TYPE_TL_×}，以及其|运算的到的数值</li>
     * <li>{@link QqTTimelinePara#setContentType(int)}可取值有{@link QqTConstant#VALUE_CONTENT_TYPE_TL_ALL}，
     * {@link QqTConstant#VALUE_CONTENT_TYPE_TL_MUSIC}以及QqTConstant中其他{@code VALUE_CONTENT_TYPE_TL_×}</li>
     * </ul>
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getTimeLineCommonStr(String url, QqTTimelinePara qqTTimelinePara);

    /**
     * 时间线通用api返回，QqTStatus对象列表返回
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @param qq@return 以对象list的形式返回
     *            <ul>
     *            <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *            {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *            <li>调用{@link QqTSdkService#getTimeLineCommonStr(String, QqTTimelinePara)}后转换为对象</li>
     *            </ul>
     */
    public List<QqTStatus> getTimeLineCommon(String url, QqTTimelinePara qqTTimelinePara);

    /**
     * 时间线通用api返回，QqTResponse对象返回
     * 
     * @param url 请求的url
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getTimeLineCommonStr(String, QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getTimeLineCommonRes(String url, QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，表示获取微博列表，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_14">腾讯微博<strong>主页时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getHomeTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，表示获取微博列表，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getHomeTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getHomeTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线，返回QqTResponse，可以通过对type，contenttype及其它设置获取不同的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getHomeTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getHomeTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_15">腾讯微博<strong>广播大厅时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getPublicTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getPublicTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getPublicTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 广播大厅时间线，表示广播大厅中微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getPublicTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getPublicTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_16">腾讯微博<strong>其他用户发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUserTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getUserTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线，表示获取其他用户的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getUserTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_17">腾讯微博<strong>用户提及时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getMentionsTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getMentionsTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getMentionsTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线，表示获取提及到自己的微博，及@
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getMentionsTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getMentionsTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_18">腾讯微博<strong>话题时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getTopicTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getTopicTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getTopicTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 话题时间线，表示获取相关话题的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getTopicTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getTopicTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_19">腾讯微博<strong>我发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getBroadcastTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getBroadcastTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getBroadcastTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getBroadcastTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getBroadcastTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_20">腾讯微博<strong>特别收听的人发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getSpecialTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getSpecialTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getSpecialTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 特别收听的人发表时间线，表示获取我特别接收的用户发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getSpecialTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getSpecialTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 地区发表时间线，表示获取某个地区发表的微博信息<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_72">腾讯微博<strong>地区发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getAreaTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getAreaTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getAreaTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线，表示获取我发表的微博信息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getAreaTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getAreaTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_77">腾讯微博<strong>主页时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getHomeTLIdsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getHomeTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getHomeTLIds(QqTTimelinePara qqTTimelinePara);

    /**
     * 主页时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getHomeTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getHomeTLIdsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_79">腾讯微博<strong>其他用户发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUserTLIdsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getUserTLIds(QqTTimelinePara qqTTimelinePara);

    /**
     * 其他用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getUserTLIdsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_76">腾讯微博<strong>我发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getBroadcastTLIdsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getBroadcastTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getBroadcastTLIds(QqTTimelinePara qqTTimelinePara);

    /**
     * 我发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getBroadcastTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getBroadcastTLIdsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_78">腾讯微博<strong>用户提及时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getMentionsTLIdsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getMentionsTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getMentionsTLIds(QqTTimelinePara qqTTimelinePara);

    /**
     * 用户提及时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getMentionsTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getMentionsTLIdsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_73">腾讯微博<strong>多用户发表时间线</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUsersTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUsersTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getUsersTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUsersTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getUsersTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 具体参数见<a href="http://open.t.qq.com/resource.php?i=1,1#7_80">腾讯微博<strong>多用户发表时间线索引</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getUsersTLIdsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUsersTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getUsersTLIds(QqTTimelinePara qqTTimelinePara);

    /**
     * 多用户发表时间线索引<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUsersTLIdsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getUsersTLIdsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 具体参数见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E6%97%B6%E9%97%B4%E7%BA%BF/%E6%8B%89%E5%8F%96vip%E7%94%A8%E6%88%B7%E5%8F%91%E8%A1%A8%E5%BE%AE%E5%8D%9A%E6%B6%88%E6%81%AF%E6%8E%A5%E5%8F%A3"
     * >腾讯微博<strong>拉取vip用户发表微博消息</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getVipStatusTLStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getVipStatusTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getVipStatusTL(QqTTimelinePara qqTTimelinePara);

    /**
     * 拉取vip用户发表微博消息<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getVipStatusTLStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getVipStatusTLRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 得到某条微博的具体信息，字符串返回
     * 
     * @param format 返回信息格式
     * @param statusId 微博id
     * @return
     */
    public String getStatus(String format, long statusId);

    /**
     * 得到某条微博的具体信息，状态返回
     * 
     * @param statusId 微博id
     * @return
     */
    public QqTStatus getStatus(long statusId);

    /**
     * 得到某条微博的具体信息，QqTResponse返回
     * 
     * @param statusId 微博id
     * @return
     */
    public QqTResponse getStatusRes(long statusId);

    /**
     * 新增状态通用api，返回字符串
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public String addStatusCommonStr(String addStatusUrl, QqTStatusInfoPara status);

    /**
     * 新增状态通用api，返回是否新增成功
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public boolean addStatusCommon(String addStatusUrl, QqTStatusInfoPara status);

    /**
     * 新增状态通用api，返回QqTResponse
     * 
     * @param addStatusUrl 新增状态的url
     * @param status 状态内容
     * @return
     */
    public QqTResponse addStatusCommonRes(String addStatusUrl, QqTStatusInfoPara status);

    /**
     * 发布一条微博，返回字符串
     * 
     * @param status 微博内容信息
     * @return
     */
    public String addStatusStr(QqTStatusInfoPara status);

    /**
     * 发布一条微博，返回是否成功
     * 
     * @param status 微博内容信息
     * @return
     */
    public boolean addStatus(QqTStatusInfoPara status);

    /**
     * 发布一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息
     * @return
     */
    public QqTResponse addStatusRes(QqTStatusInfoPara status);

    /**
     * 发布一条简单微博，返回字符串
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public String addStatusStr(String content, String imagePath);

    /**
     * 发布一条简单微博，返回是否成功
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public boolean addStatus(String content, String imagePath);

    /**
     * 发布一条简单微博，返回QqTResponse
     * 
     * @param content 微博内容信息
     * @param imagePath 图片路径，若无图片，传null
     * @return
     */
    public QqTResponse addStatusRes(String content, String imagePath);

    /**
     * 转发一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String repostStr(QqTStatusInfoPara status);

    /**
     * 转发一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return
     */
    public boolean repost(QqTStatusInfoPara status);

    /**
     * 转发一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public QqTResponse repostRes(QqTStatusInfoPara status);

    /**
     * 回复一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String replyStr(QqTStatusInfoPara status);

    /**
     * 回复一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 是否成功回复
     */
    public boolean reply(QqTStatusInfoPara status);

    /**
     * 回复一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public QqTResponse replyRes(QqTStatusInfoPara status);

    /**
     * 评论一条微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String commentStr(QqTStatusInfoPara status);

    /**
     * 评论一条微博，返回是否成功
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 是否成功评论
     */
    public boolean comment(QqTStatusInfoPara status);

    /**
     * 评论一条微博，返回QqTResponse
     * 
     * @param status 微博内容信息，包含带转发微博的id
     * @return 返回QqTResponse
     */
    public QqTResponse commentRes(QqTStatusInfoPara status);

    /**
     * 发表音乐微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String addMusicStatusStr(QqTStatusInfoPara status);

    /**
     * 发表音乐微博，返回是否发表成功
     * 
     * @param status 微博内容
     * @return 返回是否发表成功
     */
    public boolean addMusicStatus(QqTStatusInfoPara status);

    /**
     * 发表音乐微博，返回QqTResponse
     * 
     * @param status 微博内容
     * @return 返回QqTResponse
     */
    public QqTResponse addMusicStatusRes(QqTStatusInfoPara status);

    /**
     * 发表视频微博，根据format返回字符串
     * 
     * @param status 微博内容
     * @return
     */
    public String addVideoStatusStr(QqTStatusInfoPara status);

    /**
     * 发表视频微博，返回是否发表成功
     * 
     * @param status 微博内容
     * @return 返回是否发表成功
     */
    public boolean addVideoStatus(QqTStatusInfoPara status);

    /**
     * 发表视频微博，返回QqTResponse
     * 
     * @param status 微博内容
     * @return 返回QqTResponse
     */
    public QqTResponse addVideoStatusRes(QqTStatusInfoPara status);

    /**
     * 获得某条微博的评论或转发信息通用api，String返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link QqTTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link QqTSdkService#getTimeLineCommonStr(String, QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public String getStatusCommentsCommonStr(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论或转发信息通用api，QqTStatus list返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link QqTTimelinePara#setFormat(String)}为 {@link QqTConstant#VALUE_FORMAT_JSON}<br/>
     *         设置{@link QqTTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link QqTSdkService#getTimeLineCommon(String, QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getStatusCommentsCommon(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论或转发信息通用api，QqTResponse返回
     * 
     * @param repostOrCommentFlag 点评还是转播标识
     * @param qqTTimelinePara 时间线参数
     * @return 以QqTResponse对象形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara<br/>
     *         设置{@link QqTTimelinePara#setFormat(String)}为 {@link QqTConstant#VALUE_FORMAT_JSON}<br/>
     *         设置{@link QqTTimelinePara#setRepostOrCommentFlag(int)}为 repostOrCommentFlag</li>
     *         <li>调用 {@link QqTSdkService#getTimeLineCommonRes(String, QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getStatusCommentsCommonRes(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusCommentsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<QqTStatus> getStatusComments(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public QqTResponse getStatusCommentsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusRepostsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<QqTStatus> getStatusReposts(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的转发信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public QqTResponse getStatusRepostsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回字符串
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public String getStatusCommentsAndRepostsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回状态list
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public List<QqTStatus> getStatusCommentsAndReposts(QqTTimelinePara qqTTimelinePara);

    /**
     * 获得某条微博的评论和转发信息，返回QqTResponse
     * 
     * @param qqTTimelinePara 时间线参数
     * @return
     */
    public QqTResponse getStatusCommentsAndRepostsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 获取视频信息，以字符串形式返回
     * 
     * @param format 返回的数据格式
     * @param videoUrl 视频url
     * @return
     */
    public String getVideoInfo(String format, String videoUrl);

    /**
     * 获取视频信息，以QqTVideoInfo对象形式返回
     * 
     * @param videoUrl 视频url
     * @return
     */
    public QqTVideoInfo getVideoInfo(String videoUrl);

    /**
     * 获取视频信息，以QqTResponse对象形式返回
     * 
     * @param videoUrl 视频url
     * @return
     */
    public QqTResponse getVideoInfoRes(String videoUrl);

    /**
     * 根据微博id批量获取微博内容，返回字符串
     * 
     * @param format 返回数据格式
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public String getStatusByIdsStr(String format, String ids);

    /**
     * 根据微博id批量获取微博内容
     * 
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public List<QqTStatus> getStatusByIds(String ids);

    /**
     * 根据微博id批量获取微博内容，返回QqTResponse
     * 
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public QqTResponse getStatusByIdsRes(String ids);

    /**
     * 根据微博id批量获取转播的再次转播数，返回字符串
     * 
     * @param format 返回数据格式
     * @param ids 微博id，以逗号分隔
     * @return
     */
    public String getReRepostCountByIdsStr(String format, String ids);

    /**
     * 根据微博id批量获取转播的再次转播数
     * 
     * @param ids 微博id，以逗号分隔
     * @return key为微博id，value为再次转播数
     */
    public Map<Long, Integer> getReRepostCountByIds(String ids);

    /**
     * 根据微博id批量获取转播的再次转播数，返回QqTResponse
     * 
     * @param ids 微博id，以逗号分隔
     * @return key为微博id，value为再次转播数
     */
    public QqTResponse getReRepostCountByIdsRes(String ids);

    /**
     * 发表心情帖子，返回字符串
     * 
     * @param status 心情帖子信息
     * @return
     */
    public String addEmotionStr(QqTStatusInfoPara status);

    /**
     * 发表心情帖子，返回是否成功
     * 
     * @param status 心情帖子信息
     * @return
     */
    public boolean addEmotion(QqTStatusInfoPara status);

    /**
     * 发表心情帖子，返回QqTResponse
     * 
     * @param status 心情帖子信息
     * @return
     */
    public QqTResponse addEmotionRes(QqTStatusInfoPara status);

    /**
     * 操作单条状态（类似收藏、删除）通用api，返回字符串
     * 
     * @param url 操作的url
     * @param format 返回数据格式
     * @param statusId 微博id
     * @return
     */
    public String operateStatusCommonStr(String url, String format, long statusId);

    /**
     * 操作单条状态通用api，返回是否操作成功
     * 
     * @param url 操作的url
     * @param statusId 微博id
     * @return
     */
    public boolean operateStatusCommon(String url, long statusId);

    /**
     * 操作单条状态通用api，返回QqTResponse
     * 
     * @param url 操作的url
     * @param statusId 微博id
     * @return
     */
    public QqTResponse operateStatusCommonRes(String url, long statusId);

    /**
     * 删除一条微博
     * 
     * @param statusId 微博id
     * @return 是否成功删除
     */
    public boolean delete(long statusId);

    /**
     * 删除一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public QqTResponse deleteRes(long statusId);

    /**
     * 转播数或点评数，返回字符串
     * 
     * @param format 返回信息格式
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return
     */
    public String getRepostAndCommentCount(String format, String statusIds, int flag);

    /**
     * 转播数或点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记 {@link QqTConstant#VALUE_RE_COUNT_FLAG_ALL}表示转播数和点评数，
     *            {@link QqTConstant#VALUE_RE_COUNT_FLAG_REPOST}表示转播数， {@link QqTConstant#VALUE_RE_COUNT_FLAG_COMMENT}
     *            表示点评数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId以及commentCount、repostCount之一或全部，根据flag设置</li>
     *         </ul>
     */
    public List<QqTStatus> getRepostAndCommentCount(String statusIds, int flag);

    /**
     * 转播数或点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记 {@link QqTConstant#VALUE_RE_COUNT_FLAG_ALL}表示转播数和点评数，
     *            {@link QqTConstant#VALUE_RE_COUNT_FLAG_REPOST}表示转播数， {@link QqTConstant#VALUE_RE_COUNT_FLAG_COMMENT}
     *            表示点评数
     * @return 以QqTResponse的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId以及commentCount、repostCount之一或全部，根据flag设置</li>
     *         </ul>
     */
    public QqTResponse getRepostAndCommentCountRes(String statusIds, int flag);

    /**
     * 转播数和点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId、commentCount和repostCount</li>
     *         </ul>
     */
    public List<QqTStatus> getRepostAndCommentCount(String statusIds);

    /**
     * 转播数和点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>返回的对象只包含statusId、commentCount和repostCount</li>
     *         </ul>
     */
    public QqTResponse getRepostAndCommentCountRes(String statusIds);

    /**
     * 转播数或点评数
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以map的形式返回, key为状态id，name为点评数或转播数
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>解析字符串得到id和点评数或转播数信息</li>
     *         </ul>
     */
    public Map<Long, Integer> getRepostOrCommentCount(String statusIds, int flag);

    /**
     * 转播数或点评数，以QqTResponse返回
     * 
     * @param statusIds 微博id，以逗号分隔
     * @param flag 标记
     * @return 以map的形式返回, key为状态id，name为点评数或转播数
     *         <ul>
     *         <li>调用{@link QqTSdkService#getRepostAndCommentCount(String, String, int)}后转换为对象</li>
     *         <li>解析字符串得到id和点评数或转播数信息</li>
     *         </ul>
     */
    public QqTResponse getRepostOrCommentCountRes(String statusIds, int flag);

    /**
     * 获取自己的详细资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E8%87%AA%E5%B7%B1%E7%9A%84%E8%AF%A6%E7%BB%86%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取自己的详细资料</strong>api</a>
     * 
     * @param format 返回信息格式
     * @return
     */
    public String getSelfInfo(String format);

    /**
     * 获取自己的详细资料，转换为QqTUser
     * 
     * @return
     */
    public QqTUser getSelfInfo();

    /**
     * 获取自己的详细资料，转换为QqTResponse
     * 
     * @return
     */
    public QqTResponse getSelfInfoRes();

    /**
     * 更新用户信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户信息</strong>api</a>
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public String updateSelfInfoStr(QqTUserPara qqTUserPara);

    /**
     * 更新用户信息
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public boolean updateSelfInfo(QqTUserPara qqTUserPara);

    /**
     * 更新用户信息，返回QqTResponse
     * 
     * @param qqTUserPara 用户信息
     * @return
     */
    public QqTResponse updateSelfInfoRes(QqTUserPara qqTUserPara);

    /**
     * 更新用户头像信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E5%A4%B4%E5%83%8F%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户头像信息</strong>api</a>
     * 
     * @param format 返回数据格式
     * @param headImagePath 头像图片路径
     * @return
     */
    public String updateSelfHeadStr(String format, String headImagePath);

    /**
     * 更新用户头像信息，返回是否操作成功
     * 
     * @param headImagePath 头像图片路径
     * @return
     */
    public boolean updateSelfHead(String headImagePath);

    /**
     * 更新用户头像信息，返回QqTResponse
     * 
     * @param headImagePath 头像图片路径
     * @return
     */
    public QqTResponse updateSelfHeadRes(String headImagePath);

    /**
     * 更新用户教育信息，返回字符串
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E6%95%99%E8%82%B2%E4%BF%A1%E6%81%AF"
     * >腾讯微博<strong>更新用户教育信息</strong>api</a>
     * <ul>
     * <li>添加教育信息, {@link QqTUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public String updateSelfEduInfoStr(QqTUserEduPara qqTUserEduPara);

    /**
     * 更新用户教育信息
     * <ul>
     * <li>添加教育信息, {@link QqTUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public boolean updateSelfEduInfo(QqTUserEduPara qqTUserEduPara);

    /**
     * 更新用户教育信息，返回QqTResponse
     * <ul>
     * <li>添加教育信息, {@link QqTUserEduPara#setFeildId(long)} feildId=1</li>
     * <li>修改教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId</li>
     * <li>删除教育信息，{@link QqTUserEduPara#setFeildId(long)} 填返回的feildId，其余参数除format外为空</li>
     * </ul>
     * 
     * @param qqTUserEduPara 用户教育信息
     * @return
     */
    public QqTResponse updateSelfEduInfoRes(QqTUserEduPara qqTUserEduPara);

    /**
     * 获取其他人资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E5%85%B6%E4%BB%96%E4%BA%BA%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取其他人资料</strong>api</a>
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String getOtherUserInfo(String format, String userName, String userOpenId);

    /**
     * 获取其他人资料，转换为QqTUser
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTUser getOtherUserInfo(String userName, String userOpenId);

    /**
     * 获取其他人资料，转换为QqTResponse
     * <ul>
     * <li>只需根据userName获取信息，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId获取信息，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse getOtherUserInfoRes(String userName, String userOpenId);

    /**
     * 获取一批人的简单资料
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E8%8E%B7%E5%8F%96%E4%B8%80%E6%89%B9%E4%BA%BA%E7%9A%84%E7%AE%80%E5%8D%95%E8%B5%84%E6%96%99"
     * >腾讯微博<strong>获取一批人的简单资料</strong>api</a>
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public String getOtherUsersInfo(String format, String userNames, String userOpenIds);

    /**
     * 获取一批人的简单资料，转换为QqTUser list
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public List<QqTUser> getOtherUsersInfo(String userNames, String userOpenIds);

    /**
     * 获取一批人的简单资料，转换为QqTResponse
     * <ul>
     * <li>只需根据userNames获取信息，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds获取信息，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public QqTResponse getOtherUsersInfoRes(String userNames, String userOpenIds);

    /**
     * 验证账户是否合法，返回字符串
     * <ul>
     * <li>只需按照userName验证，则userId传入{@code null}或者空字符串</li>
     * <li>只需按照userId验证，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 详细参见<a href=
     * "http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E9%AA%8C%E8%AF%81%E8%B4%A6%E6%88%B7%E6%98%AF%E5%90%A6%E5%90%88%E6%B3%95"
     * >腾讯微博<strong>验证账户是否合法</strong>api</a>
     * 
     * @param format 返回的数据格式
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     */
    public String verifyAccountStr(String format, String userName, String userId);

    /**
     * 验证账户是否合法
     * 
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     *         <ul>
     *         <li>调用{@link QqTSdkService#verifyAccountStr(String, String, String)}后进行判断</li>
     *         <li>当发送的请求返回错误或是用户不存在皆会返回false</li>
     *         <li>用户存在返回true</li>
     *         </ul>
     */
    public boolean verifyAccount(String userName, String userId);

    /**
     * 验证账户是否合法，返回QqTResponse
     * 
     * @param userName 用户名
     * @param userId 用户Id
     * @return
     *         <ul>
     *         <li>调用{@link QqTSdkService#verifyAccountStr(String, String, String)}</li>
     *         </ul>
     */
    public QqTResponse verifyAccountRes(String userName, String userId);

    /**
     * 得到和某人有关系的用户信息通用api，返回字符串
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return
     */
    public String getUserRelationsCommonStr(String url, QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户信息通用api，返回QqTUser list
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link QqTUserRelationPara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserRelationsCommonStr(String, QqTUserRelationPara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTUser> getUserRelationsCommon(String url, QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户信息通用api，返回QqTResponse
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link QqTUserRelationPara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserRelationsCommonStr(String, QqTUserRelationPara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getUserRelationsCommonRes(String url, QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户姓名信息通用api，返回String list
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link QqTUserRelationPara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserRelationsCommonStr(String, QqTUserRelationPara)} 后转换为String List</li>
     *         </ul>
     */
    public List<String> getUserRelationsNameCommon(String url, QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到和某人有关系的用户姓名信息通用api，返回QqTResponse
     * 
     * @param url 获取关系的url
     * @param qqTUserRelationPara 获取关系的参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变QqTUserRelationPara，设置{@link QqTUserRelationPara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getUserRelationsCommonStr(String, QqTUserRelationPara)} 后转换为String List</li>
     *         </ul>
     */
    public QqTResponse getUserRelationsNameCommonRes(String url, QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfFans(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfFansStrRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfFans(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfFansRes(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansNamesStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以String list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<String> getSelfFansNames(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfFansNamesRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户姓名信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansNamesStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以String list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<String> getSelfFansNames(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfFansNamesRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfInterested(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfInterestedRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfInterested(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfInterestedRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedNamesStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以String list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<String> getSelfInterestedNames(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfInterestedNamesRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户姓名信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedNamesStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以String list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<String> getSelfInterestedNames(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户姓名信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfInterestedNamesRes(int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfBlackListStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfBlackList(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以QqTResponse形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfBlackListRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己黑名单中的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfBlackListStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfBlackList(int reqNumber, int startIndex);

    /**
     * 得到自己黑名单中的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfBlackListRes(int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfSpecialInterestedStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfSpecialInterested(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfSpecialInterestedRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己特别关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfSpecialInterestedStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以对象list形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfSpecialInterested(int reqNumber, int startIndex);

    /**
     * 得到自己特别关注的用户信息，以QqTResponse对象形式返回
     * 
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfSpecialInterestedRes(int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserFansStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getOtherUserFans(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以QqTResponse对象返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getOtherUserFansRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户的粉丝信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserFansStr(String format, String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getOtherUserFans(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户的粉丝信息，以QqTResponse对象返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getOtherUserFansRes(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserInterestedStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getOtherUserInterested(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getOtherUserInterestedRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户关注的用户信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                            int startIndex);

    /**
     * 得到其他用户关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getOtherUserInterested(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getOtherUserInterestedRes(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getOtherUserSpecialInterestedStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getOtherUserSpecialInterested(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getOtherUserSpecialInterestedRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到其他用户特别关注的用户信息，以字符串形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getOtherUserSpecialInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                                   int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以对象list形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getOtherUserSpecialInterested(String userName, String userOpenId, int reqNumber, int startIndex);

    /**
     * 得到其他用户特别关注的用户信息，以QqTResponse对象形式返回
     * <ul>
     * <li>userName和userOpenId至少选一个，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getOtherUserSpecialInterestedRes(String userName, String userOpenId, int reqNumber,
                                                        int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfFansSimpleInfoStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfFansSimpleInfo(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfFansSimpleInfoRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到关注自己的用户的简单信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfFansSimpleInfoStr(String format, int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以对象list形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfFansSimpleInfo(int reqNumber, int startIndex);

    /**
     * 得到关注自己的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfFansSimpleInfoRes(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getSelfInterestedSimpleInfoStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getSelfInterestedSimpleInfo(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getSelfInterestedSimpleInfoRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到自己关注的用户的简单信息，以字符串形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getSelfInterestedSimpleInfoStr(String format, int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以对象list形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getSelfInterestedSimpleInfo(int reqNumber, int startIndex);

    /**
     * 得到自己关注的用户的简单信息，以QqTResponse对象形式返回
     * 
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getSelfInterestedSimpleInfoRes(int reqNumber, int startIndex);

    /**
     * 得到互听关系链列表，以字符串形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public String getMutualInterestedStr(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以对象list形式返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public List<QqTUser> getMutualInterested(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以QqTResponse对象返回
     * 
     * @param qqTUserRelationPara
     * @return
     */
    public QqTResponse getMutualInterestedRes(QqTUserRelationPara qqTUserRelationPara);

    /**
     * 得到互听关系链列表，以字符串形式返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public String getMutualInterestedStr(String format, String userName, int reqNumber, int startIndex);

    /**
     * 得到互听关系链列表，以对象list形式返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public List<QqTUser> getMutualInterested(int reqNumber, String userName, int startIndex);

    /**
     * 得到互听关系链列表，以QqTResponse对象返回
     * 
     * @param userName 用户名
     * @param format 返回信息格式
     * @param reqNumber 请求个数(1-30)
     * @param startIndex 起始位置(第一页填0，继续向下翻页：填:reqnum*(page-1))
     * @return
     */
    public QqTResponse getMutualInterestedRes(int reqNumber, String userName, int startIndex);

    /**
     * 和某人建立或取消某种关系通用api，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回信息格式
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String relationWithOtherCommonStr(String format, String url, String userName, String userOpenId);

    /**
     * 和某人建立或取消某种关系通用api，返回是否操作成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return 是否操作成功
     *         <ul>
     *         <li>调用{@link QqTSdkService#relationWithOtherCommonStr(String, String, String, String)}</li>
     *         </ul>
     */
    public boolean relationWithOtherCommon(String url, String userName, String userOpenId);

    /**
     * 和某人建立或取消某种关系通用api，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param url 操作关系的url
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return 是否操作成功
     *         <ul>
     *         <li>调用{@link QqTSdkService#relationWithOtherCommonStr(String, String, String, String)}</li>
     *         </ul>
     */
    public QqTResponse relationWithOtherCommonRes(String url, String userName, String userOpenId);

    /**
     * 收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userNames建立关系，则userOpenIds传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenIds建立关系，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public String interestedInOther(String format, String userNames, String userOpenIds);

    /**
     * 收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userOpenIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public boolean interestedInOther(String userNames, String userOpenIds);

    /**
     * 收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userOpenIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userOpenIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public QqTResponse interestedInOtherRes(String userNames, String userOpenIds);

    /**
     * 取消收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String cancelInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 取消收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean cancelInterestedInOther(String userName, String userOpenId);

    /**
     * 取消收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse cancelInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String specialInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean specialInterestedInOther(String userName, String userOpenId);

    /**
     * 特别收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse specialInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String cancelSpecialInterestedInOther(String format, String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean cancelSpecialInterestedInOther(String userName, String userOpenId);

    /**
     * 取消特别收听(关注)某人，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse cancelSpecialInterestedInOtherRes(String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String addOtherToBlackList(String format, String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean addOtherToBlackList(String userName, String userOpenId);

    /**
     * 添加某个用户到黑名单，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse addOtherToBlackListRes(String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回字符串
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public String deleteFromBlackList(String format, String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回操作是否成功
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public boolean deleteFromBlackList(String userName, String userOpenId);

    /**
     * 从黑名单中删除某个用户，返回QqTResponse
     * <ul>
     * <li>只需根据userName建立关系，则userOpenId传入{@code null}或者空字符串</li>
     * <li>只需根据userOpenId建立关系，则userName传入{@code null}或者空字符串</li>
     * <li>userName和userOpenId至少有一个不为空，若同时存在则以userName值为主</li>
     * </ul>
     * 
     * @param userName 用户名
     * @param userOpenId 用户openid
     * @return
     */
    public QqTResponse deleteFromBlackListRes(String userName, String userOpenId);

    /**
     * 检测是否我的听众或收听的人，返回字符串
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param format 返回数据格式
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @param flag 关系标记
     * @return
     */
    public String checkRelationWithSelf(String format, String userNames, String userOpenIds, int flag);

    /**
     * 检测是否我的听众或收听的人，返回用户和自己的关系
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public List<QqTUserRelation> getIsFanAndInterested(String userNames, String userOpenIds);

    /**
     * 检测是否我的听众或收听的人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public QqTResponse getIsFanAndInterestedRes(String userNames, String userOpenIds);

    /**
     * 检测是否我的听众或收听的人，返回map，key为用户名，value为true或false，表示是否是听众或收听的人
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public Map<String, Boolean> getIsFanOrInterested(String userNames, String userOpenIds, int flag);

    /**
     * 检测是否我的听众或收听的人，返回QqTResponse
     * <ul>
     * <li>只需按照userNames验证，则userIds传入{@code null}或者空字符串</li>
     * <li>只需按照userIds验证，则userNames传入{@code null}或者空字符串</li>
     * <li>userNames和userIds至少有一个不为空，若同时存在则以userNames值为主</li>
     * </ul>
     * 
     * @param userNames 用户名帐户名列表，若多个则用","隔开
     * @param userOpenIds 用户openid列表，若多个则用"_"隔开
     * @return
     */
    public QqTResponse getIsFanOrInterestedRes(String userNames, String userOpenIds, int flag);

    /**
     * 发私信，根据format返回字符串
     * 
     * @param message 私信内容
     * @return
     */
    public String sendMessageStr(QqTStatusInfoPara message);

    /**
     * 发私信，返回是否发表成功
     * 
     * @param message 私信内容
     * @return 返回是否发表成功
     *         <ul>
     *         <li>此函数会改变message，设置{@link QqTStatusInfoPara#setFormat(String)}为 {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#sendMessageStr(QqTStatusInfoPara)}后转换为对象</li>
     *         </ul>
     */
    public boolean sendMessage(QqTStatusInfoPara message);

    /**
     * 发私信，返回QqTResponse
     * 
     * @param message 私信内容
     * @return 返回QqTResponse
     *         <ul>
     *         <li>此函数会改变message，设置{@link QqTStatusInfoPara#setFormat(String)}为 {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#sendMessageStr(QqTStatusInfoPara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse sendMessageRes(QqTStatusInfoPara message);

    /**
     * 删除一条私信
     * 
     * @param messageId 私信id
     * @return 是否成功评论
     */
    public boolean deleteMessage(long messageId);

    /**
     * 删除一条私信，返回QqTResponse
     * 
     * @param messageId 私信id
     * @return
     */
    public QqTResponse deleteMessageRes(long messageId);

    /**
     * 收件箱，表示收到的私信列表
     * 具体参数见<a
     * href="http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3/%E6%94%B6%E4%BB%B6%E7%AE%B1"
     * >腾讯微博<strong>私信收件箱</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getReceiveMessagesStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 收件箱，表示收到的私信列表
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getReceiveMessagesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getReceiveMessages(QqTTimelinePara qqTTimelinePara);

    /**
     * 收件箱，表示收到的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getReceiveMessagesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getReceiveMessagesRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 具体参数见<a
     * href="http://wiki.open.t.qq.com/index.php/%E7%A7%81%E4%BF%A1%E7%9B%B8%E5%85%B3/%E5%8F%91%E4%BB%B6%E7%AE%B1"
     * >腾讯微博<strong>私信发件箱</strong>api</a>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getSendMessagesStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getSendMessagesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getSendMessages(QqTTimelinePara qqTTimelinePara);

    /**
     * 发件箱，表示发出的私信列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getSendMessagesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getSendMessagesRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 搜索通用api，返回字符串
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchCommonStr(String url, QqTSearchPara qqTSearchPara);

    /**
     * 搜索用户通用api，返回用户列表
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<QqTUser> searchUserCommon(String url, QqTSearchPara qqTSearchPara);

    /**
     * 搜索用户通用api，返回QqTResponse
     * 
     * @param url 搜索url
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public QqTResponse searchUserCommonRes(String url, QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchUserStr(QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回用户列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<QqTUser> searchUser(QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索用户api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public QqTResponse searchUserRes(QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchStatusStr(QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回微博列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<QqTStatus> searchStatus(QqTSearchPara qqTSearchPara);

    /**
     * 根据关键字搜索微博api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public QqTResponse searchStatusRes(QqTSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回字符串
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public String searchUserByTagStr(QqTSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回用户列表
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public List<QqTUser> searchUserByTag(QqTSearchPara qqTSearchPara);

    /**
     * 根据标签搜索用户api，返回QqTResponse
     * 
     * @param qqTSearchPara 搜索参数
     * @return
     */
    public QqTResponse searchUserByTagRes(QqTSearchPara qqTSearchPara);

    /**
     * 热榜通用api，返回字符串
     * 
     * @param url 链接地址
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotCommonStr(String url, QqTHotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回字符串
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotTopicsStr(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回QqTTopicSimple list
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public List<QqTTopicSimple> getHotTopics(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 话题热榜，返回QqTResponse
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public QqTResponse getHotTopicsRes(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回字符串
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public String getHotRepostsStr(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回QqTStatus List
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public List<QqTStatus> getHotReposts(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 转播热榜，返回QqTResponse
     * 
     * @param qqTHotStatusPara 参数
     * @return
     */
    public QqTResponse getHotRepostsRes(QqTHotStatusPara qqTHotStatusPara);

    /**
     * 获得数据更新条数，返回字符串
     * 
     * @param format 数据返回格式
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public String getUpdateInfoNumStr(String format, boolean isClear, int clearType);

    /**
     * 获得数据更新条数，返回QqTUpdateNumInfo
     * 
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public QqTUpdateNumInfo getUpdateInfoNum(boolean isClear, int clearType);

    /**
     * 获得数据更新条数，返回QqTResponse
     * 
     * @param isClear 是否在查看数据后，清除更新数
     * @param clearType 在上面为true时，设置清空的更新数的类型
     * @return
     */
    public QqTResponse getUpdateInfoNumRes(boolean isClear, int clearType);

    /**
     * 收藏一条微博，是否成功收藏
     * 
     * @param statusId 微博id
     * @return
     */
    public boolean collect(long statusId);

    /**
     * 收藏一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public QqTResponse collectRes(long statusId);

    /**
     * 取消收藏一条微博，是否成功取消
     * 
     * @param statusId 微博id
     * @return
     */
    public boolean unCollect(long statusId);

    /**
     * 取消收藏一条微博，返回QqTResponse
     * 
     * @param statusId 微博id
     * @return
     */
    public QqTResponse unCollectRes(long statusId);

    /**
     * 订阅话题，是否成功订阅
     * 
     * @param topicId 话题id
     * @return
     */
    public boolean subscribeTopic(long topicId);

    /**
     * 订阅话题，返回QqTResponse
     * 
     * @param topicId 话题id
     * @return
     */
    public QqTResponse subscribeTopicRes(long topicId);

    /**
     * 取消订阅话题，是否成功取消
     * 
     * @param topicId 话题id
     * @return
     */
    public boolean unSubscribeTopic(long topicId);

    /**
     * 取消订阅话题，返回QqTResponse
     * 
     * @param topicId 话题id
     * @return
     */
    public QqTResponse unSubscribeTopicRes(long topicId);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getCollectStatusesStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getCollectStatusesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getCollectStatuses(QqTTimelinePara qqTTimelinePara);

    /**
     * 获取收藏的微博列表<br/>
     * 
     * @param qqTTimelinePara
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getCollectStatusesStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getCollectStatusesRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 根据话题名称查询话题id<br/>
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 以字符串的形式返回
     */
    public String getTopicIdByNamesStr(String format, String names);

    /**
     * 根据话题名称查询话题id，返回Map
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 以map返回，key为id，value为name
     */
    public Map<String, String> getTopicIdByNames(String names);

    /**
     * 根据话题名称查询话题id，返回QqTResponse
     * 
     * @param format 返回数据格式
     * @param names 话题名字列表，以逗号分隔，如abc,efg
     * @return 返回QqTResponse，data为map，key为id，value为name
     */
    public QqTResponse getTopicIdByNamesRes(String names);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param format 返回数据格式
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以字符串的形式返回
     */
    public String getTopicInfoByIdsStr(String format, String ids);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getTopicInfoByIdsStr(String, String)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getTopicInfoByIds(String ids);

    /**
     * 根据话题id获取话题相关信息<br/>
     * 
     * @param ids 话题id列表，以逗号分隔，如12345,12345最多15个
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>调用{@link QqTSdkService#getTopicInfoByIdsStr(String, String)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getTopicInfoByIdsRes(String ids);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以字符串的形式返回
     */
    public String getCollectTopicsStr(QqTTimelinePara qqTTimelinePara);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以对象list的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getCollectTopicsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public List<QqTStatus> getCollectTopics(QqTTimelinePara qqTTimelinePara);

    /**
     * 获取已订阅话题列表<br/>
     * 
     * @param qqTTimelinePara 时间线参数
     * @return 以QqTResponse对象的形式返回
     *         <ul>
     *         <li>此函数会改变qqTTimelinePara，设置{@link QqTTimelinePara#setFormat(String)}为
     *         {@link QqTConstant#VALUE_FORMAT_JSON}</li>
     *         <li>调用{@link QqTSdkService#getCollectTopicsStr(QqTTimelinePara)}后转换为对象</li>
     *         </ul>
     */
    public QqTResponse getCollectTopicsRes(QqTTimelinePara qqTTimelinePara);

    /**
     * 添加标签，返回字符串
     * 
     * @param format 返回的数据格式
     * @param tagName 标签名
     * @return
     */
    public String addTag(String format, String tagName);

    /**
     * 添加标签，返回是否添加成功
     * 
     * @param tagName 标签名
     * @return
     */
    public boolean addTag(String tagName);

    /**
     * 添加标签，返回QqTResponse
     * 
     * @param tagName 标签名
     * @return
     */
    public QqTResponse addTagRes(String tagName);

    /**
     * 删除标签，返回字符串
     * 
     * @param format 返回的数据格式
     * @param tagId 标签id
     * @return
     */
    public String deleteTag(String format, String tagId);

    /**
     * 删除标签，返回是否删除成功
     * 
     * @param tagId 标签id
     * @return
     */
    public boolean deleteTag(String tagId);

    /**
     * 删除标签，返回QqTResponse
     * 
     * @param tagId 标签id
     * @return
     */
    public QqTResponse deleteTagRes(String tagId);

    /**
     * 得到未授权的request token
     * 
     * @param callBackUrl
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_token_secret, oauth_callback_confirmed</li>
     *         </ul>
     */
    public Map<String, String> getUnAuthorizedRequestToken(String callBackUrl);

    /**
     * 得到授权的request token
     * 
     * @param String query url的query部分
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_verifier</li>
     *         </ul>
     */
    public Map<String, String> getAuthorizedRequestToken(String query);

    /**
     * 得到access token
     * 
     * @param oauthToken 获得的oauth token
     * @param oauthVerifier 获得的oauth verifier
     * @param requestTokenSecret 获得临时request token时的token secret
     * @return
     *         <ul>
     *         <li>map包含oauth_token, oauth_token_secret</li>
     *         </ul>
     */
    public Map<String, String> getAccessToken(String oauthToken, String oauthVerifier, String requestTokenSecret);
}
