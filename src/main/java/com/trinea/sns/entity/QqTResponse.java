package com.trinea.sns.entity;

import java.io.Serializable;

import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博api返回的所有信息
 * 
 * @author Trinea 2011-11-13 下午11:33:04
 */
public class QqTResponse implements Serializable {

    private static final long serialVersionUID = -2009665772693739186L;

    /** 返回状态，0成功，非0失败 **/
    private int               returnStatus;

    /** 返回信息，ok、error等 **/
    private String            message;

    /** 返回 的错误代码 **/
    private int               errorCode;

    /** 返回的数据，对于不同的api，返回不同，可能是微博列表，可能是用户信息，可能是单条微博，可能是操作是否正确结果 **/
    private Object            data;

    /** 返回的关联数据，一般api的用户数据保存在{@link QqTResponse#data}中，对于验证帐户合法api，若合法，保存用户信息 **/
    private Object            info;

    /** 表示是否正确返回 **/
    public boolean getIsOk() {
        return QqTConstant.RET_VALUE_MSG.equals(message);
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(int returnStatus) {
        this.returnStatus = returnStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getInfo() {
        return info;
    }
}
