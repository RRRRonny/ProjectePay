package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class TransState {
    private int id;
    private String content;
    private String remark;
    private long timestamp;


    public TransState() {
    }

    public TransState(int id, String content, String remark, long timestamp) {
        this.id = id;
        this.content = content;
        this.remark = remark;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "TransState{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
