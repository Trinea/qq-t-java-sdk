package com.trinea.sns.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.trinea.java.common.MapUtils;
import com.trinea.sns.util.QqTConstant;

/**
 * 腾讯微博修改用户教育信息参数
 * http://wiki.open.t.qq.com/index.php/%E5%B8%90%E6%88%B7%E7%9B%B8%E5%85%B3/%E6%9B%B4%E6%96%B0%E7%94%A8%E6%88%B7%E6%95%
 * 99%E8%82%B2%E4%BF%A1%E6%81%AF
 * 
 * @author Trinea 2011-10-29 下午06:51:15
 */
public class QqTUserEduPara implements Serializable {

    private static final long serialVersionUID    = 3298635316340763420L;

    /** 返回数据的格式 **/
    private String            format;

    /**
     * 教育信息记录id
     * 添加教育信息feildId=1
     * 修改教育信息填返回的feildId
     * 删除教育信息下面四个参数为空
     **/
    private long              feildId;

    /** 入学年 **/
    private String            year;

    /** 学校id **/
    private long              schoolId;

    /** 院系id **/
    private long              departmentId;

    /** 学历级别，1表示小学，2表示初中，3表示高中，4表示大学，5表示硕士，6表示博士 **/
    private int               level;

    /** 默认值 **/
    private static String     defaultFormat       = "";
    private static long       defaultFeildId      = -1;
    private static String     defaultYear         = "";
    private static long       defaultSchoolId     = -1;
    private static long       defaultDepartmentId = -1;
    private static int        defaultLevel        = -1;

    public QqTUserEduPara(){
        super();

        this.format = defaultFormat;
        this.feildId = defaultFeildId;
        this.year = defaultYear;
        this.schoolId = defaultSchoolId;
        this.departmentId = defaultDepartmentId;
        this.level = defaultLevel;
    }

    /**
     * 将用户信息参数对象转换为api需要的map
     * 
     * @return
     */
    public Map<String, String> getParasMap() {
        Map<String, String> parasMap = new HashMap<String, String>();
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_FORMAT, format);
        MapUtils.putMapNotEmptyValue(parasMap, QqTConstant.PARA_USER_EDU_YEAR, year);
        if (feildId >= 0) {
            parasMap.put(QqTConstant.PARA_USER_EDU_FEILD_ID, Long.toString(feildId));
        }
        if (schoolId >= 0) {
            parasMap.put(QqTConstant.PARA_USER_EDU_SCHOOL_ID, Long.toString(schoolId));
        }
        if (departmentId >= 0) {
            parasMap.put(QqTConstant.PARA_USER_EDU_DEPARTMENT_ID, Long.toString(departmentId));
        }
        if (level >= 0) {
            parasMap.put(QqTConstant.PARA_USER_EDU_LEVEL, Long.toString(level));
        }
        return parasMap;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getFeildId() {
        return feildId;
    }

    public void setFeildId(long feildId) {
        this.feildId = feildId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
