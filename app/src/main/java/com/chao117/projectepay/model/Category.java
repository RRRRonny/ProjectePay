package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class Category {

    private int id;
    private String name;
    private String remark;
    private int parentCode;
    private long timestamp;

    public Category() {
    }

    public Category(int id, String name, String remark, int parentCode, long timestamp) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.parentCode = parentCode;
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

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", parentCode=" + parentCode +
                ", timestamp=" + timestamp +
                '}';
    }
}
