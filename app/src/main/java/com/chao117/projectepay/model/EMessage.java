package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class EMessage {
    private int id;
    private String content;
    private EMessage preMessage;
    private User user;
    private Goods goods;
    private String remark;
    private long timestamp;

    public EMessage() {
    }

    public EMessage(int id, String content, EMessage preMessage, User user, Goods goods, String remark, long timestamp) {
        this.id = id;
        this.content = content;
        this.preMessage = preMessage;
        this.user = user;
        this.goods = goods;
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

    public EMessage getPreMessage() {
        return preMessage;
    }

    public void setPreMessage(EMessage preMessage) {
        this.preMessage = preMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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
        return "EMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", preMessage=" + preMessage +
                ", user=" + user +
                ", goods=" + goods +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
