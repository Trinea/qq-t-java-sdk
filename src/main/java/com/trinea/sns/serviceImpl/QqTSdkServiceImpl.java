package com.trinea.sns.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trinea.java.common.HttpUtils;
import com.trinea.java.common.JSONUtils;
import com.trinea.java.common.MapUtils;
import com.trinea.java.common.StringUtils;
import com.trinea.sns.entity.QqTAppAndToken;
import com.trinea.sns.entity.QqTHotStatusPara;
import com.trinea.sns.entity.QqTListData;
import com.trinea.sns.entity.QqTResponse;
import com.trinea.sns.entity.QqTSearchPara;
import com.trinea.sns.entity.QqTSign;
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
import com.trinea.sns.service.QqTSdkService;
import com.trinea.sns.util.QqTConstant;
import com.trinea.sns.utilImpl.QqTCheckAndTransUtils;
import com.trinea.sns.utilImpl.QqTParaMapUtils;
import com.trinea.sns.utilImpl.QqTSignAndHttpUtils;
import com.trinea.sns.utilImpl.QqTTransformUtils;

public class QqTSdkServiceImpl implements QqTSdkService {

    /** 应用和用户相关信息 **/
    private QqTAppAndToken qqTAppAndToken;

    @Override
    public QqTAppAndToken getQqTAppAndToken() {
        return qqTAppAndToken;
    }

    @Override
    public void setQqTAppAndToken(QqTAppAndToken qqTAppAndToken) {
        this.qqTAppAndToken = qqTAppAndToken;
    }

    @Override
    public String getTimeLineCommonStr(String url, QqTTimelinePara qqTTimelinePara) {
        if (StringUtils.isEmpty(url) || qqTTimelinePara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTTLParaMap(qqTAppAndToken.getAppKey(),
                                                                             qqTAppAndToken.getAccessToken(),
                                                                             qqTTimelinePara);

        return QqTSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTStatus> getTimeLineCommon(String url, QqTTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transStatusesToList(getTimeLineCommonStr(url, qqTTimelinePara));
    }

    @Override
    public QqTResponse getTimeLineCommonRes(String url, QqTTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = getTimeLineCommonStr(url, qqTTimelinePara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
                qqTListData.setRelatedUser(QqTTransformUtils.transQqTrelatedUser(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public String getHomeTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getHomeTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getHomeTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getPublicTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getPublicTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getPublicTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_PUBLIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUserTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getUserTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getUserTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_USER_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getMentionsTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getMentionsTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getMentionsTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_MENTIONS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getTopicTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getTopicTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getTopicTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_TOPIC_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getBroadcastTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getBroadcastTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getBroadcastTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_BROADCAST_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getSpecialTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getSpecialTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getSpecialTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_SPECIAL_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getAreaTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getAreaTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getAreaTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_AREA_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getHomeTLIdsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getHomeTLIds(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getHomeTLIdsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_HOME_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUserTLIdsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getUserTLIds(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getUserTLIdsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getBroadcastTLIdsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getBroadcastTLIds(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getBroadcastTLIdsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_BROADCAST_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getMentionsTLIdsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getMentionsTLIds(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getMentionsTLIdsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_MENTIONS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getUsersTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getUsersTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getUsersTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_USERS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getUsersTLIdsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getUsersTLIds(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getUsersTLIdsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_USERS_TL_IDS_URL, qqTTimelinePara);
    }

    @Override
    public String getVipStatusTLStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getVipStatusTL(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getVipStatusTLRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_VIP_STATUS_TL_URL, qqTTimelinePara);
    }

    @Override
    public String getStatus(String format, long statusId) {
        if (statusId < 0 || StringUtils.isEmpty(format) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_STATUS_ID, Long.toString(statusId));

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_STATUS_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public QqTStatus getStatus(long statusId) {
        String status = getStatus(QqTConstant.VALUE_FORMAT_JSON, statusId);
        if (!StringUtils.isEmpty(status) && QqTCheckAndTransUtils.checkModifyResult(status)) {
            return QqTTransformUtils.transStatus(JSONUtils.getJSONObject(status, "data", null));
        }
        return null;
    }

    @Override
    public QqTResponse getStatusRes(long statusId) {
        String response = getStatus(QqTConstant.VALUE_FORMAT_JSON, statusId);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transStatus(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String addStatusCommonStr(String addStatusUrl, QqTStatusInfoPara status) {
        if (status == null || qqTAppAndToken == null || !qqTAppAndToken.isValid() || StringUtils.isEmpty(addStatusUrl)) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTSIParaMap(qqTAppAndToken.getAppKey(),
                                                                             qqTAppAndToken.getAccessToken(), status);
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }

        if (status.isContainImage()) {
            Map<String, String> filePathMap = new HashMap<String, String>();
            filePathMap.put(QqTConstant.PARA_PICTURE, status.getImageFilePath());
            return QqTSignAndHttpUtils.signAndHttpPostWithFile(addStatusUrl, filePathMap, parasMap, qqTAppAndToken);
        } else {
            return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(addStatusUrl, parasMap, qqTAppAndToken);
        }
    }

    @Override
    public boolean addStatusCommon(String addStatusUrl, QqTStatusInfoPara status) {
        if (status == null) {
            return false;
        }

        status.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.checkModifyResult(addStatusCommonStr(addStatusUrl, status));
    }

    @Override
    public QqTResponse addStatusCommonRes(String addStatusUrl, QqTStatusInfoPara status) {
        if (status == null) {
            return null;
        }

        status.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = addStatusCommonStr(addStatusUrl, status);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public String addStatusStr(QqTStatusInfoPara status) {
        if (status == null) {
            return null;
        }
        return addStatusCommonStr((status.isContainImage() ? QqTConstant.ADD_STATUS_WITH_PIC_URL : QqTConstant.ADD_STATUS_URL),
                                  status);

    }

    @Override
    public boolean addStatus(QqTStatusInfoPara status) {
        if (status == null) {
            return false;
        }

        return addStatusCommon((status.isContainImage() ? QqTConstant.ADD_STATUS_WITH_PIC_URL : QqTConstant.ADD_STATUS_URL),
                               status);
    }

    @Override
    public QqTResponse addStatusRes(QqTStatusInfoPara status) {
        if (status == null) {
            return null;
        }

        return addStatusCommonRes((status.isContainImage() ? QqTConstant.ADD_STATUS_WITH_PIC_URL : QqTConstant.ADD_STATUS_URL),
                                  status);
    }

    @Override
    public String addStatusStr(String content, String imagePath) {
        QqTStatusInfoPara status = new QqTStatusInfoPara();
        status.setStatusContent(content);
        if (StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatusStr(status);
    }

    @Override
    public boolean addStatus(String content, String imagePath) {
        QqTStatusInfoPara status = new QqTStatusInfoPara();
        status.setStatusContent(content);
        if (!StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatus(status);
    }

    @Override
    public QqTResponse addStatusRes(String content, String imagePath) {
        QqTStatusInfoPara status = new QqTStatusInfoPara();
        status.setStatusContent(content);
        if (StringUtils.isEmpty(imagePath)) {
            status.setImageFilePath(imagePath);
        }
        return addStatusRes(status);
    }

    @Override
    public String repostStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public boolean repost(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public QqTResponse repostRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.REPOST_STATUS_URL, status);
    }

    @Override
    public String replyStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public boolean reply(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public QqTResponse replyRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.REPLY_STATUS_URL, status);
    }

    @Override
    public String commentStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public boolean comment(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public QqTResponse commentRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.COMMENT_STATUS_URL, status);
    }

    @Override
    public String addMusicStatusStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public boolean addMusicStatus(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public QqTResponse addMusicStatusRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.ADD_MUSIC_STATUS_URL, status);
    }

    @Override
    public String addVideoStatusStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public boolean addVideoStatus(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public QqTResponse addVideoStatusRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.ADD_VIDEO_STATUS_URL, status);
    }

    @Override
    public String getStatusCommentsCommonStr(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommonStr(QqTConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getStatusCommentsCommon(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommon(QqTConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getStatusCommentsCommonRes(int repostOrCommentFlag, QqTTimelinePara qqTTimelinePara) {
        if (qqTTimelinePara == null) {
            return null;
        }

        qqTTimelinePara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        qqTTimelinePara.setRepostOrCommentFlag(repostOrCommentFlag);
        return getTimeLineCommonRes(QqTConstant.GET_COMMENTS_URL, qqTTimelinePara);
    }

    @Override
    public String getStatusCommentsStr(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(QqTConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getStatusComments(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(QqTConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public QqTResponse getStatusCommentsRes(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(QqTConstant.VALUE_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public String getStatusRepostsStr(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(QqTConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getStatusReposts(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(QqTConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public QqTResponse getStatusRepostsRes(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(QqTConstant.VALUE_REPOST_FLAG, qqTTimelinePara);
    }

    @Override
    public String getStatusCommentsAndRepostsStr(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonStr(QqTConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getStatusCommentsAndReposts(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommon(QqTConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public QqTResponse getStatusCommentsAndRepostsRes(QqTTimelinePara qqTTimelinePara) {
        return getStatusCommentsCommonRes(QqTConstant.VALUE_REPOST_AND_COMMENT_FLAG, qqTTimelinePara);
    }

    @Override
    public String getVideoInfo(String format, String videoUrl) {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(videoUrl) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_VIDEO_URL, videoUrl);

        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(QqTConstant.GET_VIDEO_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public QqTVideoInfo getVideoInfo(String videoUrl) {
        String videoInfo = getVideoInfo(QqTConstant.VALUE_FORMAT_JSON, videoUrl);
        if (StringUtils.isEmpty(videoInfo) || !QqTCheckAndTransUtils.checkModifyResult(videoInfo)) {
            return null;
        }
        return QqTTransformUtils.transVideoInfo(JSONUtils.getJSONObject(videoInfo, "data", null));
    }

    @Override
    public QqTResponse getVideoInfoRes(String videoUrl) {
        String response = getVideoInfo(QqTConstant.VALUE_FORMAT_JSON, videoUrl);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transVideoInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getStatusByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_STATUS_IDS, ids);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_STATUS_BY_IDS_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTStatus> getStatusByIds(String ids) {
        return QqTCheckAndTransUtils.transStatusesToList(getStatusByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids));
    }

    @Override
    public QqTResponse getStatusByIdsRes(String ids) {

        String response = getStatusByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getReRepostCountByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_STATUS_IDS, ids);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_RE_REPOST_COUNT_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public Map<Long, Integer> getReRepostCountByIds(String ids) {
        return QqTTransformUtils.transStatusesReCountToMap(getReRepostCountByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids));
    }

    public QqTResponse getReRepostCountByIdsRes(String ids) {
        String response = getReRepostCountByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transStatusesReCountToMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String addEmotionStr(QqTStatusInfoPara status) {
        return addStatusCommonStr(QqTConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public boolean addEmotion(QqTStatusInfoPara status) {
        return addStatusCommon(QqTConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public QqTResponse addEmotionRes(QqTStatusInfoPara status) {
        return addStatusCommonRes(QqTConstant.ADD_EMOTION_STATUS_URL, status);
    }

    @Override
    public String operateStatusCommonStr(String url, String format, long statusId) {
        if (StringUtils.isEmpty(url) || StringUtils.isEmpty(format) || statusId < 0 || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, QqTConstant.VALUE_FORMAT_JSON);
        parasMap.put(QqTConstant.PARA_STATUS_ID, Long.toString(statusId));

        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(url, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean operateStatusCommon(String url, long statusId) {
        return QqTCheckAndTransUtils.checkModifyResult(operateStatusCommonStr(url, QqTConstant.VALUE_FORMAT_JSON,
                                                                              statusId));
    }

    @Override
    public QqTResponse operateStatusCommonRes(String url, long statusId) {
        String response = operateStatusCommonStr(url, QqTConstant.VALUE_FORMAT_JSON, statusId);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public boolean delete(long statusId) {
        return operateStatusCommon(QqTConstant.DELETE_STATUS_URL, statusId);
    }

    @Override
    public QqTResponse deleteRes(long statusId) {
        return operateStatusCommonRes(QqTConstant.DELETE_STATUS_URL, statusId);
    }

    @Override
    public String getRepostAndCommentCount(String format, String statusIds, int flag) {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(statusIds) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_RE_COUNTIDS, statusIds);
        parasMap.put(QqTConstant.PARA_RE_COUNT_FLAG, Integer.toString(flag));

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_REPOST_AND_COMMENT_COUNT_URL, parasMap,
                                                  qqTAppAndToken);
    }

    @Override
    public List<QqTStatus> getRepostAndCommentCount(String statusIds, int flag) {
        if (QqTConstant.VALUE_RE_COUNT_FLAG_ALL == flag) {
            return getRepostAndCommentCount(statusIds);
        } else if (QqTConstant.VALUE_RE_COUNT_FLAG_REPOST == flag) {
            return QqTTransformUtils.transCommentCountMapToList(getRepostOrCommentCount(statusIds, flag));
        } else if (QqTConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
            return QqTTransformUtils.transRepostCountMapToList(getRepostOrCommentCount(statusIds, flag));
        }
        return null;
    }

    @Override
    public QqTResponse getRepostAndCommentCountRes(String statusIds, int flag) {

        String response = getRepostAndCommentCount(QqTConstant.VALUE_FORMAT_JSON, statusIds, flag);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            if (QqTConstant.VALUE_RE_COUNT_FLAG_ALL == flag) {
                qqTResponse.setData(QqTTransformUtils.transStatusesReCountToList(response));
            } else if (QqTConstant.VALUE_RE_COUNT_FLAG_REPOST == flag
                       || QqTConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
                qqTResponse.setData(QqTTransformUtils.transStatusesReCountToMap(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public List<QqTStatus> getRepostAndCommentCount(String statusIds) {
        String reCount = getRepostAndCommentCount(QqTConstant.VALUE_FORMAT_JSON, statusIds,
                                                  QqTConstant.VALUE_RE_COUNT_FLAG_ALL);
        if (StringUtils.isEmpty(reCount) || !QqTCheckAndTransUtils.checkModifyResult(reCount)) {
            return null;
        }

        return QqTTransformUtils.transStatusesReCountToList(reCount);
    }

    @Override
    public QqTResponse getRepostAndCommentCountRes(String statusIds) {

        String response = getRepostAndCommentCount(QqTConstant.VALUE_FORMAT_JSON, statusIds,
                                                   QqTConstant.VALUE_RE_COUNT_FLAG_ALL);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transStatusesReCountToList(response));
        }
        return qqTResponse;
    }

    @Override
    public Map<Long, Integer> getRepostOrCommentCount(String statusIds, int flag) {

        String reCount = getRepostAndCommentCount(QqTConstant.VALUE_FORMAT_JSON, statusIds, flag);
        if (StringUtils.isEmpty(reCount) || !QqTCheckAndTransUtils.checkModifyResult(reCount)) {
            return null;
        }

        if (QqTConstant.VALUE_RE_COUNT_FLAG_REPOST == flag || QqTConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
            return QqTTransformUtils.transStatusesReCountToMap(reCount);
        }
        return null;
    }

    @Override
    public QqTResponse getRepostOrCommentCountRes(String statusIds, int flag) {

        String response = getRepostAndCommentCount(QqTConstant.VALUE_FORMAT_JSON, statusIds, flag);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            if (QqTConstant.VALUE_RE_COUNT_FLAG_REPOST == flag || QqTConstant.VALUE_RE_COUNT_FLAG_COMMENT == flag) {
                qqTResponse.setData(QqTTransformUtils.transStatusesReCountToMap(response));
            }
        }
        return qqTResponse;
    }

    @Override
    public String getSelfInfo(String format) {
        if (StringUtils.isEmpty(format) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_SELF_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public QqTUser getSelfInfo() {
        String selfInfo = getSelfInfo(QqTConstant.VALUE_FORMAT_JSON);
        if (StringUtils.isEmpty(selfInfo) || !QqTCheckAndTransUtils.checkModifyResult(selfInfo)) {
            return null;
        }
        return QqTTransformUtils.transUserInfo(JSONUtils.getJSONObject(selfInfo, "data", null));
    }

    @Override
    public QqTResponse getSelfInfoRes() {
        String response = getSelfInfo(QqTConstant.VALUE_FORMAT_JSON);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String updateSelfInfoStr(QqTUserPara qqTUserPara) {
        if (qqTUserPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTUserParaMap(qqTAppAndToken.getAppKey(),
                                                                               qqTAppAndToken.getAccessToken(),
                                                                               qqTUserPara);
        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(QqTConstant.UPDATE_USER_INFO_URL, parasMap,
                                                              qqTAppAndToken);
    }

    @Override
    public boolean updateSelfInfo(QqTUserPara qqTUserPara) {
        if (qqTUserPara != null) {
            qqTUserPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        }
        return QqTCheckAndTransUtils.checkModifyResult(updateSelfInfoStr(qqTUserPara));
    }

    @Override
    public QqTResponse updateSelfInfoRes(QqTUserPara qqTUserPara) {
        if (qqTUserPara != null) {
            qqTUserPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        }
        return QqTTransformUtils.transResponse(updateSelfInfoStr(qqTUserPara));
    }

    @Override
    public String updateSelfHeadStr(String format, String headImagePath) {
        if (StringUtils.isEmpty(headImagePath) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);

        Map<String, String> filePathList = new HashMap<String, String>();
        filePathList.put(QqTConstant.PARA_USER_ICON, headImagePath);
        return QqTSignAndHttpUtils.signAndHttpPostWithFile(QqTConstant.UPDATE_USER_HEAD_INFO_URL, filePathList,
                                                           parasMap, qqTAppAndToken);
    }

    @Override
    public boolean updateSelfHead(String headImagePath) {
        return QqTCheckAndTransUtils.checkModifyResult(updateSelfHeadStr(QqTConstant.VALUE_FORMAT_JSON, headImagePath));
    }

    @Override
    public QqTResponse updateSelfHeadRes(String headImagePath) {
        return QqTTransformUtils.transResponse(updateSelfHeadStr(QqTConstant.VALUE_FORMAT_JSON, headImagePath));
    }

    @Override
    public String updateSelfEduInfoStr(QqTUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTUEParaMap(qqTAppAndToken.getAppKey(),
                                                                             qqTAppAndToken.getAccessToken(),
                                                                             qqTUserEduPara);
        return QqTSignAndHttpUtils.signAndHttpPost(QqTConstant.UPDATE_USER_EDU_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean updateSelfEduInfo(QqTUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara != null) {
            qqTUserEduPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        }
        return QqTCheckAndTransUtils.checkModifyResult(updateSelfEduInfoStr(qqTUserEduPara));
    }

    @Override
    public QqTResponse updateSelfEduInfoRes(QqTUserEduPara qqTUserEduPara) {
        if (qqTUserEduPara != null) {
            qqTUserEduPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        }
        return QqTTransformUtils.transResponse(updateSelfEduInfoStr(qqTUserEduPara));
    }

    @Override
    public String getOtherUserInfo(String format, String userName, String userOpenId) {
        if ((StringUtils.isEmpty(userName) && StringUtils.isEmpty(userOpenId)) || StringUtils.isEmpty(format)
            || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (parasMap == null) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_OPEN_ID, userOpenId);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_OTHER_USER_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public QqTUser getOtherUserInfo(String userName, String userOpenId) {
        String selfInfo = getOtherUserInfo(QqTConstant.VALUE_FORMAT_JSON, userName, userOpenId);
        if (StringUtils.isEmpty(selfInfo) || !QqTCheckAndTransUtils.checkModifyResult(selfInfo)) {
            return null;
        }
        return QqTTransformUtils.transUserInfo(JSONUtils.getJSONObject(selfInfo, "data", null));
    }

    @Override
    public QqTResponse getOtherUserInfoRes(String userName, String userOpenId) {
        String response = getOtherUserInfo(QqTConstant.VALUE_FORMAT_JSON, userName, userOpenId);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "data", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getOtherUsersInfo(String format, String userNames, String userOpenIds) {
        if ((StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userOpenIds)) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAMES, userNames);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_OPEN_IDS, userOpenIds);
        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_OTHER_USERS_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTUser> getOtherUsersInfo(String userNames, String userOpenIds) {
        return QqTCheckAndTransUtils.transUsersToList(getOtherUsersInfo(QqTConstant.VALUE_FORMAT_JSON, userNames,
                                                                        userOpenIds));
    }

    @Override
    public QqTResponse getOtherUsersInfoRes(String userNames, String userOpenIds) {
        String response = getOtherUsersInfo(QqTConstant.VALUE_FORMAT_JSON, userNames, userOpenIds);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String verifyAccountStr(String format, String userName, String userId) {
        if ((StringUtils.isEmpty(userName) && StringUtils.isEmpty(userId)) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (parasMap == null) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, QqTConstant.VALUE_FORMAT_JSON);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_VERIFY_ACCOUNT_NAME, userName);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_VERIFY_ACCOUNT_ID, userId);

        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(QqTConstant.VERIFY_ACCOUNT_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean verifyAccount(String userName, String userId) {
        QqTResponse qqTResponse = verifyAccountRes(userName, userId);
        return qqTResponse == null ? null : ((Boolean)qqTResponse.getData()).booleanValue();
    }

    @Override
    public QqTResponse verifyAccountRes(String userName, String userId) {
        String response = verifyAccountStr(QqTConstant.VALUE_FORMAT_JSON, userName, userId);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);

        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transVerifyResult(JSONUtils.getJSONObject(response, "data", null)));
            qqTResponse.setInfo(QqTTransformUtils.transUserInfo(JSONUtils.getJSONObject(response, "info", null)));
        }
        return qqTResponse;
    }

    @Override
    public String getUserRelationsCommonStr(String url, QqTUserRelationPara qqTUserRelationPara) {
        if (StringUtils.isEmpty(url) || qqTUserRelationPara == null || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTURParaMap(qqTAppAndToken.getAppKey(),
                                                                             qqTAppAndToken.getAccessToken(),
                                                                             qqTUserRelationPara);
        return QqTSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTUser> getUserRelationsCommon(String url, QqTUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transUsersToList(getUserRelationsCommonStr(url, qqTUserRelationPara));
    }

    @Override
    public QqTResponse getUserRelationsCommonRes(String url, QqTUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = getUserRelationsCommonStr(url, qqTUserRelationPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public List<String> getUserRelationsNameCommon(String url, QqTUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transUserNamesToList(getUserRelationsCommonStr(url, qqTUserRelationPara));
    }

    @Override
    public QqTResponse getUserRelationsNameCommonRes(String url, QqTUserRelationPara qqTUserRelationPara) {
        if (qqTUserRelationPara == null) {
            return null;
        }

        qqTUserRelationPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = getUserRelationsCommonStr(url, qqTUserRelationPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transUserNamesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getSelfFansStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfFans(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansStrRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfFans(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansNamesStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfFansNames(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommon(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansNamesRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommonRes(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansNamesStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfFansNames(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommon(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansNamesRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommonRes(QqTConstant.GET_SELF_FANS_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfInterested(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfInterested(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedNamesStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfInterestedNames(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommon(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedNamesRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsNameCommonRes(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedNamesStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public List<String> getSelfInterestedNames(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommon(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedNamesRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsNameCommonRes(QqTConstant.GET_SELF_INTERESTED_NAMES_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfBlackListStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfBlackList(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfBlackListRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfBlackListStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfBlackList(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfBlackListRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_BLACK_LIST_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfSpecialInterestedStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfSpecialInterested(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfSpecialInterestedRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfSpecialInterestedStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfSpecialInterested(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfSpecialInterestedRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserFansStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserFans(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserFansRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserFansStr(String format, String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserFans(String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserFansRes(String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_FANS_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserInterestedStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserInterested(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserInterestedRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                            int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserInterested(String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserInterestedRes(String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserSpecialInterestedStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserSpecialInterested(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserSpecialInterestedRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getOtherUserSpecialInterestedStr(String format, String userName, String userOpenId, int reqNumber,
                                                   int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getOtherUserSpecialInterested(String userName, String userOpenId, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getOtherUserSpecialInterestedRes(String userName, String userOpenId, int reqNumber,
                                                        int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setUserOpenId(userOpenId);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_OTHER_USER_SPECIAL_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansSimpleInfoStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfFansSimpleInfo(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansSimpleInfoRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfFansSimpleInfoStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfFansSimpleInfo(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfFansSimpleInfoRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_FANS_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedSimpleInfoStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfInterestedSimpleInfo(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedSimpleInfoRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getSelfInterestedSimpleInfoStr(String format, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getSelfInterestedSimpleInfo(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getSelfInterestedSimpleInfoRes(int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_SELF_INTERESTED_SIMPLE_URL, qqTUserRelationPara);
    }

    @Override
    public String getMutualInterestedStr(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonStr(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getMutualInterested(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommon(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getMutualInterestedRes(QqTUserRelationPara qqTUserRelationPara) {
        return getUserRelationsCommonRes(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String getMutualInterestedStr(String format, String userName, int reqNumber, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setFormat(format);
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonStr(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public List<QqTUser> getMutualInterested(int reqNumber, String userName, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommon(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public QqTResponse getMutualInterestedRes(int reqNumber, String userName, int startIndex) {
        QqTUserRelationPara qqTUserRelationPara = new QqTUserRelationPara();
        qqTUserRelationPara.setUserName(userName);
        qqTUserRelationPara.setReqNumber(reqNumber);
        qqTUserRelationPara.setStartIndex(startIndex);
        return getUserRelationsCommonRes(QqTConstant.GET_Mutual_INTERESTED_URL, qqTUserRelationPara);
    }

    @Override
    public String relationWithOtherCommonStr(String format, String url, String userName, String userOpenId) {
        if (StringUtils.isEmpty(url) || (StringUtils.isEmpty(userName) && StringUtils.isEmpty(userOpenId))
            || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userName);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_ID, userOpenId);
        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(url, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean relationWithOtherCommon(String url, String userName, String userOpenId) {
        return QqTCheckAndTransUtils.checkModifyResult(relationWithOtherCommonStr(QqTConstant.VALUE_FORMAT_JSON, url,
                                                                                  userName, userOpenId));
    }

    @Override
    public QqTResponse relationWithOtherCommonRes(String url, String userName, String userOpenId) {
        return QqTTransformUtils.transResponse(relationWithOtherCommonStr(QqTConstant.VALUE_FORMAT_JSON, url, userName,
                                                                          userOpenId));
    }

    @Override
    public String interestedInOther(String format, String userNames, String userOpenIds) {
        if ((StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userOpenIds)) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_NAME, userNames);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_IDS, userOpenIds);
        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(QqTConstant.ADD_FRIEND_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean interestedInOther(String userNames, String userOpenIds) {
        return QqTCheckAndTransUtils.checkModifyResult(interestedInOther(QqTConstant.VALUE_FORMAT_JSON, userNames,
                                                                         userOpenIds));
    }

    @Override
    public QqTResponse interestedInOtherRes(String userNames, String userOpenIds) {
        return QqTTransformUtils.transResponse(interestedInOther(QqTConstant.VALUE_FORMAT_JSON, userNames, userOpenIds));
    }

    @Override
    public String cancelInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, QqTConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean cancelInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(QqTConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public QqTResponse cancelInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(QqTConstant.DELETE_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String specialInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, QqTConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean specialInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(QqTConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public QqTResponse specialInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(QqTConstant.ADD_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String cancelSpecialInterestedInOther(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, QqTConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public boolean cancelSpecialInterestedInOther(String userName, String userOpenId) {
        return relationWithOtherCommon(QqTConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public QqTResponse cancelSpecialInterestedInOtherRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(QqTConstant.DELETE_SPECIAL_FRIEND_URL, userName, userOpenId);
    }

    @Override
    public String addOtherToBlackList(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, QqTConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public boolean addOtherToBlackList(String userName, String userOpenId) {
        return relationWithOtherCommon(QqTConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public QqTResponse addOtherToBlackListRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(QqTConstant.ADD_OTHER_TO_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public String deleteFromBlackList(String format, String userName, String userOpenId) {
        return relationWithOtherCommonStr(format, QqTConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public boolean deleteFromBlackList(String userName, String userOpenId) {
        return relationWithOtherCommon(QqTConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public QqTResponse deleteFromBlackListRes(String userName, String userOpenId) {
        return relationWithOtherCommonRes(QqTConstant.DELETE_OTHER_FROM_BLACK_LIST_URL, userName, userOpenId);
    }

    @Override
    public String checkRelationWithSelf(String format, String userNames, String userIds, int flag) {
        if (StringUtils.isEmpty(format) || (StringUtils.isEmpty(userNames) && StringUtils.isEmpty(userIds))
            || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        if (MapUtils.isEmpty(parasMap)) {
            return null;
        }
        parasMap.put(QqTConstant.PARA_FORMAT, format);

        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_NAMES, userNames);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_RELATION_USER_OPEN_IDS, userIds);

        parasMap.put(QqTConstant.PARA_RELATION_FLAG, Integer.toString(flag));

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.CHECK_RELATION_WITH_SELF_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTUserRelation> getIsFanAndInterested(String userNames, String userIds) {
        String relationStr = checkRelationWithSelf(QqTConstant.VALUE_FORMAT_JSON, userNames, userIds,
                                                   QqTConstant.VALUE_BOTH_RELATION_FLAG);
        if (StringUtils.isEmpty(relationStr) || !QqTCheckAndTransUtils.checkModifyResult(relationStr)) {
            return null;
        }

        return QqTTransformUtils.transUserRelationToList(relationStr);
    }

    @Override
    public QqTResponse getIsFanAndInterestedRes(String userNames, String userIds) {
        String response = checkRelationWithSelf(QqTConstant.VALUE_FORMAT_JSON, userNames, userIds,
                                                QqTConstant.VALUE_BOTH_RELATION_FLAG);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transUserRelationToList(response));
        }
        return qqTResponse;
    }

    @Override
    public Map<String, Boolean> getIsFanOrInterested(String userNames, String userIds, int flag) {

        String relationStr = checkRelationWithSelf(QqTConstant.VALUE_FORMAT_JSON, userNames, userIds, flag);
        if (StringUtils.isEmpty(relationStr) || !QqTCheckAndTransUtils.checkModifyResult(relationStr)) {
            return null;
        }

        if (QqTConstant.VALUE_FANS_RELATION_FLAG == flag || QqTConstant.VALUE_INTERESTED_RELATION_FLAG == flag) {
            return QqTTransformUtils.transUserRelationToMap(relationStr);
        }
        return null;
    }

    @Override
    public QqTResponse getIsFanOrInterestedRes(String userNames, String userIds, int flag) {
        String response = checkRelationWithSelf(QqTConstant.VALUE_FORMAT_JSON, userNames, userIds, flag);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transUserRelationToMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String sendMessageStr(QqTStatusInfoPara message) {
        return addStatusCommonStr(QqTConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public boolean sendMessage(QqTStatusInfoPara message) {
        return addStatusCommon(QqTConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public QqTResponse sendMessageRes(QqTStatusInfoPara message) {
        return addStatusCommonRes(QqTConstant.SEND_MESSAGE_URL, message);
    }

    @Override
    public boolean deleteMessage(long messageId) {
        return operateStatusCommon(QqTConstant.DELETE_MESSAGE_URL, messageId);
    }

    @Override
    public QqTResponse deleteMessageRes(long messageId) {
        return operateStatusCommonRes(QqTConstant.DELETE_MESSAGE_URL, messageId);
    }

    @Override
    public String getReceiveMessagesStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getReceiveMessages(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getReceiveMessagesRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_RECEIVE_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public String getSendMessagesStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getSendMessages(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getSendMessagesRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_SEND_MESSAGES_URL, qqTTimelinePara);
    }

    @Override
    public String searchCommonStr(String url, QqTSearchPara qqTSearchPara) {
        if (StringUtils.isEmpty(url) || qqTSearchPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTSearchParaMap(qqTAppAndToken.getAppKey(),
                                                                                 qqTAppAndToken.getAccessToken(),
                                                                                 qqTSearchPara);
        return QqTSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTUser> searchUserCommon(String url, QqTSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transUsersToList(searchCommonStr(url, qqTSearchPara));
    }

    @Override
    public QqTResponse searchUserCommonRes(String url, QqTSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = searchCommonStr(url, qqTSearchPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transUsersToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String searchUserStr(QqTSearchPara qqTSearchPara) {
        return searchCommonStr(QqTConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public List<QqTUser> searchUser(QqTSearchPara qqTSearchPara) {
        return searchUserCommon(QqTConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public QqTResponse searchUserRes(QqTSearchPara qqTSearchPara) {
        return searchUserCommonRes(QqTConstant.SEARCH_USER_URL, qqTSearchPara);
    }

    @Override
    public String searchStatusStr(QqTSearchPara qqTSearchPara) {
        return searchCommonStr(QqTConstant.SEARCH_STATUS_URL, qqTSearchPara);
    }

    @Override
    public List<QqTStatus> searchStatus(QqTSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transStatusesToList(searchStatusStr(qqTSearchPara));
    }

    @Override
    public QqTResponse searchStatusRes(QqTSearchPara qqTSearchPara) {
        if (qqTSearchPara == null) {
            return null;
        }

        qqTSearchPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = searchStatusStr(qqTSearchPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String searchUserByTagStr(QqTSearchPara qqTSearchPara) {
        return searchCommonStr(QqTConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public List<QqTUser> searchUserByTag(QqTSearchPara qqTSearchPara) {
        return searchUserCommon(QqTConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public QqTResponse searchUserByTagRes(QqTSearchPara qqTSearchPara) {
        return searchUserCommonRes(QqTConstant.SEARCH_USER_BY_TAG_URL, qqTSearchPara);
    }

    @Override
    public String getHotCommonStr(String url, QqTHotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStdAndQqTHSParaMap(qqTAppAndToken.getAppKey(),
                                                                             qqTAppAndToken.getAccessToken(),
                                                                             qqTHotStatusPara);
        return QqTSignAndHttpUtils.signAndHttpGet(url, parasMap, qqTAppAndToken);

    }

    @Override
    public String getHotTopicsStr(QqTHotStatusPara qqTHotStatusPara) {
        return getHotCommonStr(QqTConstant.GET_HOT_TOPICS_URL, qqTHotStatusPara);
    }

    @Override
    public List<QqTTopicSimple> getHotTopics(QqTHotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transTopicsToList(getHotTopicsStr(qqTHotStatusPara));
    }

    @Override
    public QqTResponse getHotTopicsRes(QqTHotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = getHotTopicsStr(qqTHotStatusPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTopicsToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getHotRepostsStr(QqTHotStatusPara qqTHotStatusPara) {
        return getHotCommonStr(QqTConstant.GET_HOT_REPOSTS_URL, qqTHotStatusPara);
    }

    @Override
    public List<QqTStatus> getHotReposts(QqTHotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        return QqTCheckAndTransUtils.transStatusesToList(getHotRepostsStr(qqTHotStatusPara));
    }

    @Override
    public QqTResponse getHotRepostsRes(QqTHotStatusPara qqTHotStatusPara) {
        if (qqTHotStatusPara == null) {
            return null;
        }

        qqTHotStatusPara.setFormat(QqTConstant.VALUE_FORMAT_JSON);
        String response = getHotRepostsStr(qqTHotStatusPara);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;
    }

    @Override
    public String getUpdateInfoNumStr(String format, boolean isClear, int clearType) {
        if (qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_REQ_TYPE, Integer.toString((isClear ? 1 : 0)));
        parasMap.put(QqTConstant.PARA_CLEAR_TYPE, Integer.toString(clearType));

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_UPDATE_INFO_NUM_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public QqTUpdateNumInfo getUpdateInfoNum(boolean isClear, int clearType) {
        return QqTCheckAndTransUtils.transQqTUpdateNumInfo(getUpdateInfoNumStr(QqTConstant.VALUE_FORMAT_JSON, isClear,
                                                                               clearType));
    }

    @Override
    public QqTResponse getUpdateInfoNumRes(boolean isClear, int clearType) {
        String response = getUpdateInfoNumStr(QqTConstant.VALUE_FORMAT_JSON, isClear, clearType);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transQqTUpdateNumInfo(response));
        }
        return qqTResponse;
    }

    @Override
    public boolean collect(long statusId) {
        return operateStatusCommon(QqTConstant.COLLECT_STATUS_URL, statusId);
    }

    @Override
    public QqTResponse collectRes(long statusId) {
        return operateStatusCommonRes(QqTConstant.COLLECT_STATUS_URL, statusId);
    }

    @Override
    public boolean unCollect(long statusId) {
        return operateStatusCommon(QqTConstant.UNCOLLECT_STATUS_URL, statusId);
    }

    @Override
    public QqTResponse unCollectRes(long statusId) {
        return operateStatusCommonRes(QqTConstant.UNCOLLECT_STATUS_URL, statusId);
    }

    @Override
    public boolean subscribeTopic(long topicId) {
        return operateStatusCommon(QqTConstant.SUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public QqTResponse subscribeTopicRes(long topicId) {
        return operateStatusCommonRes(QqTConstant.SUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public boolean unSubscribeTopic(long topicId) {
        return operateStatusCommon(QqTConstant.UNSUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public QqTResponse unSubscribeTopicRes(long topicId) {
        return operateStatusCommonRes(QqTConstant.UNSUBSCRIBE_TOPIC_URL, topicId);
    }

    @Override
    public String getCollectStatusesStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getCollectStatuses(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getCollectStatusesRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_COLLECT_STATUS_URL, qqTTimelinePara);
    }

    @Override
    public String getCollectTopicsStr(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonStr(QqTConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public List<QqTStatus> getCollectTopics(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommon(QqTConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public QqTResponse getCollectTopicsRes(QqTTimelinePara qqTTimelinePara) {
        return getTimeLineCommonRes(QqTConstant.GET_SUBSCRIBE_TOPICS_URL, qqTTimelinePara);
    }

    @Override
    public String getTopicIdByNamesStr(String format, String names) {
        if (StringUtils.isEmpty(names) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_TOPIC_NAMES, names);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_TOPIC_ID_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public Map<String, String> getTopicIdByNames(String names) {
        String topicStr = getTopicIdByNamesStr(QqTConstant.VALUE_FORMAT_JSON, names);
        if (!QqTCheckAndTransUtils.checkModifyResult(topicStr)) {
            return null;
        }
        return QqTTransformUtils.transTopicInfoIntoMap(topicStr);
    }

    @Override
    public QqTResponse getTopicIdByNamesRes(String names) {

        String response = getTopicIdByNamesStr(QqTConstant.VALUE_FORMAT_JSON, names);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transTopicInfoIntoMap(response));
        }
        return qqTResponse;
    }

    @Override
    public String getTopicInfoByIdsStr(String format, String ids) {
        if (StringUtils.isEmpty(ids) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_TOPIC_IDS, ids);

        return QqTSignAndHttpUtils.signAndHttpGet(QqTConstant.GET_TOPIC_INFO_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public List<QqTStatus> getTopicInfoByIds(String ids) {
        return QqTCheckAndTransUtils.transStatusesToList(getTopicInfoByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids));
    }

    @Override
    public QqTResponse getTopicInfoByIdsRes(String ids) {

        String response = getTopicInfoByIdsStr(QqTConstant.VALUE_FORMAT_JSON, ids);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            QqTListData qqTListData = QqTTransformUtils.transQqTListData(response);
            if (qqTListData != null) {
                qqTListData.setInfo(QqTTransformUtils.transTLStatusesToList(response));
                qqTResponse.setData(qqTListData);
            }
        }
        return qqTResponse;

    }

    @Override
    public String addTag(String format, String tagName) {
        if (StringUtils.isEmpty(tagName) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_TAG_NAME, tagName);

        return QqTSignAndHttpUtils.signAndHttpPostEncodeParas(QqTConstant.ADD_TAG_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean addTag(String tagName) {
        return QqTCheckAndTransUtils.checkModifyResult(addTag(QqTConstant.VALUE_FORMAT_JSON, tagName));
    }

    @Override
    public QqTResponse addTagRes(String tagName) {
        String response = addTag(QqTConstant.VALUE_FORMAT_JSON, tagName);
        QqTResponse qqTResponse = QqTTransformUtils.transResponse(response);
        if (qqTResponse != null) {
            qqTResponse.setData(QqTTransformUtils.transQqTIdAndTime(response));
        }
        return qqTResponse;
    }

    @Override
    public String deleteTag(String format, String tagId) {
        if (StringUtils.isEmpty(tagId) || qqTAppAndToken == null || !qqTAppAndToken.isValid()) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(),
                                                                          qqTAppAndToken.getAccessToken());
        parasMap.put(QqTConstant.PARA_FORMAT, format);
        parasMap.put(QqTConstant.PARA_TAG_ID, tagId);

        return QqTSignAndHttpUtils.signAndHttpPost(QqTConstant.DELETE_TAG_URL, parasMap, qqTAppAndToken);
    }

    @Override
    public boolean deleteTag(String tagId) {
        return QqTCheckAndTransUtils.checkModifyResult(deleteTag(QqTConstant.VALUE_FORMAT_JSON, tagId));
    }

    @Override
    public QqTResponse deleteTagRes(String tagId) {
        return QqTTransformUtils.transResponse(deleteTag(QqTConstant.VALUE_FORMAT_JSON, tagId));
    }

    @Override
    public Map<String, String> getUnAuthorizedRequestToken(String callBackUrl) {
        Map<String, String> parasMap = new HashMap<String, String>();
        parasMap.put(QqTConstant.PARA_OAUTH_CONSUMER_KEY, qqTAppAndToken.getAppKey());
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE_METHOD, QqTConstant.VALUE_OAUTH_SIGNATURE_METHOD);
        parasMap.put(QqTConstant.PARA_OAUTH_TIMESTAMP, Long.toString(((new Date()).getTime()) / 1000));
        parasMap.put(QqTConstant.PARA_OAUTH_NONCE, StringUtils.getRandomNumbersAndLetters(32));
        parasMap.put(QqTConstant.PARA_OAUTH_CALLBACK, callBackUrl);
        parasMap.put(QqTConstant.PARA_OAUTH_VERSION, QqTConstant.VALUE_OAUTH_VERSION);

        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(QqTConstant.GET_REQUEST_TOKEN_URL);
        qqTSign.setHttpMethod(HttpUtils.HTTP_GET_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, QqTSignAndHttpUtils.signature(qqTSign));

        /** response格式类似oauth_token=hdk48Djdsa&oauth_token_secret=xyz4992k83j47x0b&oauth_callback_confirmed=true **/
        String response = HttpUtils.httpGetEncodeParas(QqTConstant.GET_REQUEST_TOKEN_URL, parasMap);
        return StringUtils.isEmpty(response) ? null : HttpUtils.getParasMap(response);
    }

    @Override
    public Map<String, String> getAuthorizedRequestToken(String query) {
        /** response格式类似oauth_token=hdk48Djdsa&oauth_verifier=473f82d3 **/
        return (StringUtils.isEmpty(query)) ? null : HttpUtils.getParasMap(query);
    }

    @Override
    public Map<String, String> getAccessToken(String oauthToken, String oauthVerifier, String requestTokenSecret) {
        if (StringUtils.isEmpty(oauthToken) || StringUtils.isEmpty(oauthVerifier)) {
            return null;
        }

        Map<String, String> parasMap = QqTParaMapUtils.getStandardParaMap(qqTAppAndToken.getAppKey(), oauthToken);
        parasMap.put(QqTConstant.PARA_OAUTH_VERIFIER, oauthVerifier);
        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(QqTConstant.GET_ACCESS_TOKEN_URL);
        qqTSign.setHttpMethod(HttpUtils.HTTP_GET_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(requestTokenSecret);
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, QqTSignAndHttpUtils.signature(qqTSign));

        /** response格式类似oauth_token=nnch734d00ls2jdk&oauth_token_secret=pdkkdhi9sl3r4s00 **/
        String response = HttpUtils.httpGetEncodeParas(QqTConstant.GET_ACCESS_TOKEN_URL, parasMap);
        return StringUtils.isEmpty(response) ? null : HttpUtils.getParasMap(response);
    }
}
