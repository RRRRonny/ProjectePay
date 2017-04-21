package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class Follow {
    private int id;
    private User buyer;
    private User seller;
    private Goods goods;
    private String remark;
    private long timestamp;


    public Follow() {
    }

    public Follow(int id, User buyer, User seller, Goods goods, String remark, long timestamp) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
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
        return "Follow{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", goods=" + goods +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
