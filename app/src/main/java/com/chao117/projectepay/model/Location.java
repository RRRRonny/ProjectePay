package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class Location {

    private int id;
    private String name;
    private String remark;
    private String parentCode;
    private String code;
    private long timestamp;

    public Location() {
    }

    public Location(int id, String name, String remark, String parentCode, String code, long timestamp) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.parentCode = parentCode;
        this.code = code;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", code='" + code + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
