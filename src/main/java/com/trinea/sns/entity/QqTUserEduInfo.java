package com.trinea.sns.entity;

import java.io.Serializable;

/**
 * 腾讯微博用户教育信息
 * 
 * @author Trinea 2011-10-25 下午11:47:49
 */
public class QqTUserEduInfo implements Serializable {

    private static final long serialVersionUID = -623843187140208710L;

    private long              id;                                     // 学历记录id
    private String            year;                                   // 入学年
    private long              schoolId;                               // 学校id
    private long              departmentId;                           // 院系id
    private int               level;                                  // 学历级别

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
