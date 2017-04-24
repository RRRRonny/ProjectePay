package com.chao117.projectepay.model;

/**
 * Created by chan on 24/04/2017.
 */

public class RequestTrans {
    private int id;
    private User buyer;
    private User seller;
    private Goods goods;
    private int state;
    private long timestamp;

    public RequestTrans() {
    }

    public RequestTrans(int id, User buyer, User seller, Goods goods, int state, long timestamp) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.goods = goods;
        this.state = state;
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

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RequestTrans{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", goods=" + goods +
                ", state=" + state +
                ", timestamp=" + timestamp +
                '}';
    }
}
