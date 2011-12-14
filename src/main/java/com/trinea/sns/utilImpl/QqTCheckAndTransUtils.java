package com.trinea.sns.utilImpl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.trinea.java.common.StringUtils;
import com.trinea.sns.entity.QqTStatus;
import com.trinea.sns.entity.QqTTopicSimple;
import com.trinea.sns.entity.QqTUpdateNumInfo;
import com.trinea.sns.entity.QqTUser;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博检查返回的结果是否正确，正确的话进行格式转换类
 * 
 * @author Trinea 2011-11-9 上午12:03:38
 */
public class QqTCheckAndTransUtils {

    /**
     * 检查修改操作是否正确返回，依据服务器返回的字符串中包含msg字段，若该字段为ok，则表示成功
     * 
     * @param response 服务器返回的字符串
     * @return 正确返回true
     */
    public static boolean checkModifyResult(JSONObject responseObj) {
        if (responseObj == null) {
            return false;
        }

        /** 当 msg等于ok **/
        try {
            return QqTConstant.RET_VALUE_MSG.equals(responseObj.getString(QqTConstant.RET_PARA_MSG));
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 检查修改操作是否正确返回，依据服务器返回的字符串中包含msg字段，若该字段为ok，则表示成功
     * 
     * @param response 服务器返回的字符串
     * @return 正确返回true
     *         <ul>
     *         <li>1、字符串转换为JSONObject</li>
     *         <li>2、调用{@link QqTCheckAndTransUtils#checkModifyResult(JSONObject)}</li>
     *         </ul>
     */
    public static boolean checkModifyResult(String response) {
        if (StringUtils.isEmpty(response)) {
            return false;
        }

        try {
            return checkModifyResult(new JSONObject(response));
        } catch (JSONException e) {
            return false;
        }
    }

    /**
     * 将从服务器返回的微博列表信息转换成QqTStatus lilst
     * 
     * @param statusesObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link QqTTransformUtils#transTLStatusesToList(String)}</li>
     *         </ul>
     */
    public static List<QqTStatus> transStatusesToList(String statusesJsonStr) {
        if (!QqTCheckAndTransUtils.checkModifyResult(statusesJsonStr)) {
            return null;
        }
        return QqTTransformUtils.transTLStatusesToList(statusesJsonStr);
    }

    /**
     * 将从服务器返回的用户列表信息转换成QqTUser lilst
     * 
     * @param useresObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link QqTTransformUtils#transUsersToList(String)}</li>
     *         </ul>
     */
    public static List<QqTUser> transUsersToList(String useresJsonStr) {
        if (!QqTCheckAndTransUtils.checkModifyResult(useresJsonStr)) {
            return null;
        }
        return QqTTransformUtils.transUsersToList(useresJsonStr);
    }

    /**
     * 将从服务器返回的用户姓名列表信息转换成String lilst
     * 
     * @param useresObj
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link QqTTransformUtils#transUserNamesToList(String)}</li>
     *         </ul>
     */
    public static List<String> transUserNamesToList(String userNamesJsonStr) {
        if (!QqTCheckAndTransUtils.checkModifyResult(userNamesJsonStr)) {
            return null;
        }
        return QqTTransformUtils.transUserNamesToList(userNamesJsonStr);
    }

    /**
     * 将从服务器返回的主题信息转换成QqTTopicSimple lilst
     * 
     * @param topicsJsonStr
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link QqTTransformUtils#transTopicsToList(String)}</li>
     *         </ul>
     */
    public static List<QqTTopicSimple> transTopicsToList(String topicsJsonStr) {
        if (!QqTCheckAndTransUtils.checkModifyResult(topicsJsonStr)) {
            return null;
        }
        return QqTTransformUtils.transTopicsToList(topicsJsonStr);
    }

    /**
     * 将从服务器返回的数据更新信息转换成QqTUpdateNumInfo
     * 
     * @param updateNumInfo
     * @return
     *         <ul>
     *         <li>1、先检验字符串中的msg是否是ok</li>
     *         <li>2、调用{@link QqTTransformUtils#transQqTUpdateNumInfo(String)}</li>
     *         </ul>
     */
    public static QqTUpdateNumInfo transQqTUpdateNumInfo(String updateNumInfo) {
        if (!QqTCheckAndTransUtils.checkModifyResult(updateNumInfo)) {
            return null;
        }
        return QqTTransformUtils.transQqTUpdateNumInfo(updateNumInfo);
    }
}
