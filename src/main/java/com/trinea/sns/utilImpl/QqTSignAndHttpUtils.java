package com.trinea.sns.utilImpl;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.trinea.java.common.HttpUtils;
import com.trinea.java.common.MapUtils;
import com.trinea.java.common.StringUtils;
import com.trinea.sns.entity.QqTAppAndToken;
import com.trinea.sns.entity.QqTSign;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博签名和http请求
 * 
 * @author Trinea 2011-11-9 上午12:04:43
 */
public class QqTSignAndHttpUtils {

    /**
     * 创建签名，规则见<a href="http://wiki.open.t.qq.com/index.php/OAuth%E6%8E%88%E6%9D%83%E8%AF%B4%E6%98%8E">腾讯oauth api介绍</a>
     * 
     * @param parasMap 参数map
     * @param appSecret 应用密码，用于加密，不可为空
     * @param tokenSecret token密码，用于加密，可为空
     * @return 签名值
     */
    public static String signature(QqTSign qqTSign) {
        if (qqTSign == null || !qqTSign.isValid()) {
            return null;
        }

        /** URL Encode，规则见http://open.t.qq.com/resource.php?i=1,2 **/
        StringBuilder url = new StringBuilder(qqTSign.getHttpMethod());
        url.append(HttpUtils.PARAMETERS_SEPARATOR).append(HttpUtils.utf8Encode(qqTSign.getBaseUrl()));
        url.append(HttpUtils.PARAMETERS_SEPARATOR).append(HttpUtils.utf8Encode(HttpUtils.getOrderedValueEncodeParas(qqTSign.getParasMap())));

        /** 签名算法HMAC-SHA1，密钥由App Secret和Token Secret组成（中间使用&符号分隔） **/
        byte[] oauthSignature = null;
        try {
            Mac mac = Mac.getInstance(QqTConstant.MAC_ALGORITHM);
            String oauthKey = HttpUtils.utf8Encode(qqTSign.getAppSecret())
                              + "&"
                              + (StringUtils.isEmpty(qqTSign.getTokenSecret()) ? "" : HttpUtils.utf8Encode(qqTSign.getTokenSecret()));
            SecretKeySpec spec = new SecretKeySpec(oauthKey.getBytes(QqTConstant.MAC_ENCODING),
                                                   QqTConstant.MAC_ALGORITHM);
            mac.init(spec);
            oauthSignature = mac.doFinal(url.toString().getBytes(QqTConstant.MAC_ENCODING));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Base64Encoder.encode(oauthSignature);
    }

    /**
     * 对参数进行签名，并且发http get请求到固定url，返回内容
     * <ul>
     * <li><strong>注意：</strong>会改变parasMap，将sign后的值做为value，put置parasMap中</li>
     * </ul>
     * 
     * @param url 请求的url
     * @param parasMap key为参数名，value为参数值
     * @param qqTAppAndToken 用户信息
     * @return
     */
    public static String signAndHttpGet(String url, Map<String, String> parasMap, QqTAppAndToken qqTAppAndToken) {
        if (StringUtils.isEmpty(url) || MapUtils.isEmpty(parasMap) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        /** 对参数进行签名，并且发http get请求到固定url，返回内容 **/
        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(url);
        qqTSign.setHttpMethod(HttpUtils.HTTP_GET_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(qqTAppAndToken.getTokenSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, signature(qqTSign));
        return HttpUtils.httpGetEncodeParas(qqTSign.getBaseUrl(), parasMap);
    }

    /**
     * 对参数进行签名，并且发http post请求到固定url，返回内容
     * <ul>
     * <li><strong>注意：</strong>会改变parasMap，将sign后的值做为value，put置parasMap中</li>
     * </ul>
     * 
     * @param url 请求的url
     * @param parasMap key为参数名，value为参数值
     * @param qqTAppAndToken 用户信息
     * @return
     */
    public static String signAndHttpPost(String url, Map<String, String> parasMap, QqTAppAndToken qqTAppAndToken) {
        if (StringUtils.isEmpty(url) || MapUtils.isEmpty(parasMap) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        /** 对参数进行签名，并且发http post请求到固定url，返回内容 **/
        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(url);
        qqTSign.setHttpMethod(HttpUtils.HTTP_POST_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(qqTAppAndToken.getTokenSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, signature(qqTSign));
        return HttpUtils.httpPost(qqTSign.getBaseUrl(), parasMap);
    }

    /**
     * 对参数进行签名，加密参数然后发http post请求到固定url，返回内容
     * <ul>
     * <li><strong>注意：</strong>会改变parasMap，将sign后的值做为value，put置parasMap中</li>
     * </ul>
     * 
     * @param url
     * @param parasMap key为参数名，value为参数值
     * @param qqTAppAndToken
     * @return
     */
    public static String signAndHttpPostEncodeParas(String url, Map<String, String> parasMap,
                                                    QqTAppAndToken qqTAppAndToken) {
        if (StringUtils.isEmpty(url) || MapUtils.isEmpty(parasMap) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        /** 对参数进行签名，加密参数然后发http post请求到固定url，返回内容 **/
        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(url);
        qqTSign.setHttpMethod(HttpUtils.HTTP_POST_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(qqTAppAndToken.getTokenSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, signature(qqTSign));
        return HttpUtils.httpPostEncodeParas(qqTSign.getBaseUrl(), parasMap);
    }

    /**
     * 对参数进行签名，加密参数然后发http post请求以及文件到固定url，返回内容
     * <ul>
     * <li><strong>注意：</strong>会改变parasMap，将sign后的值做为value，put置parasMap中</li>
     * </ul>
     * 
     * @param url
     * @param filePathMap key为参数名，value为文件路径
     * @param parasMap key为参数名，value为参数值
     * @param qqTAppAndToken
     * @return
     */
    public static String signAndHttpPostWithFile(String url, Map<String, String> filePathMap,
                                                 Map<String, String> parasMap, QqTAppAndToken qqTAppAndToken) {
        if (StringUtils.isEmpty(url) || MapUtils.isEmpty(parasMap) || qqTAppAndToken == null
            || !qqTAppAndToken.isValid()) {
            return null;
        }

        /** 对参数进行签名，加密参数然后发http post请求到固定url，返回内容 **/
        QqTSign qqTSign = new QqTSign();
        qqTSign.setBaseUrl(url);
        qqTSign.setHttpMethod(HttpUtils.HTTP_POST_METHOD.toUpperCase());
        qqTSign.setAppSecret(qqTAppAndToken.getAppSecret());
        qqTSign.setTokenSecret(qqTAppAndToken.getTokenSecret());
        qqTSign.setParasMap(parasMap);
        parasMap.put(QqTConstant.PARA_OAUTH_SIGNATURE, signature(qqTSign));

        return HttpUtils.httpPostWithFile(qqTSign.getBaseUrl(), parasMap, filePathMap);
    }
}
