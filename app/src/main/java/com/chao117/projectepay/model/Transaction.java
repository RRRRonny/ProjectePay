package com.chao117.projectepay.model;

/**
 * Created by chan on 17/04/2017.
 */

public class Transaction {
    private int id;
    private User buyer;
    private User seller;
    private Goods goods;
    private TransState transState;
    private TransType transType;
    private String buyerRemark;
    private String sellerRemark;
    private long timestamp;

    public Transaction() {
    }

    public Transaction(int id, User buyer, User seller, Goods goods, TransState transState, TransType transType, String buyerRemark, String sellerRemark, long timestamp) {
        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.goods = goods;
        this.transState = transState;
        this.transType = transType;
        this.buyerRemark = buyerRemark;
        this.sellerRemark = sellerRemark;
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

    public TransState getTransState() {
        return transState;
    }

    public void setTransState(TransState transState) {
        this.transState = transState;
    }

    public TransType getTransType() {
        return transType;
    }

    public void setTransType(TransType transType) {
        this.transType = transType;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public String getSalerRemark() {
        return sellerRemark;
    }

    public void setSalerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", goods=" + goods +
                ", transState=" + transState +
                ", transType=" + transType +
                ", buyerRemark='" + buyerRemark + '\'' +
                ", sellerRemark='" + sellerRemark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
