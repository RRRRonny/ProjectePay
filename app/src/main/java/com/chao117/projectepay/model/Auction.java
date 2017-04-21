package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class Auction {
    private int id;
    private User buyer;
    private User seller;
    private Goods goods;
    private int state;
    private String remark;
    private long timestamp;

    public Auction() {
    }

    public Auction(int id, User buyer, User seller, Goods goods, int state, String remark, long timestamp) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.goods = goods;
        this.state = state;
        this.remark = remark;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSaler() {
        return seller;
    }

    public void setSaler(User seller) {
        this.seller = seller;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        return "Auction{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", goods=" + goods +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
