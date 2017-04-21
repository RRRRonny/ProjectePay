package com.chao117.projectepay.model;

/**
 * Created by chan on 19/04/2017.
 */

public class Brand {
    private int id;
    private String name;
    private String code;
    private String parentCode;
    private String remark;
    private long timestamp;


    public Brand() {
    }

    public Brand(int id, String name, String code, String parentCode, String remark, long timestamp) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentCode = parentCode;
        this.remark = remark;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
