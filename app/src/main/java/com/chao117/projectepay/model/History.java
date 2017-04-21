package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class History {
    private int id;
    private User user;
    private Goods goods;
    private String remark;
    private long timestamp;

    public History() {
    }

    public History(int id, User user, Goods goods, String remark, long timestamp) {
        this.id = id;
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
        return "History{" +
                "id=" + id +
                ", user=" + user +
                ", goods=" + goods +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
