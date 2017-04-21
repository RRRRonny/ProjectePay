package com.chao117.projectepay.model;

/**
 * Created by chan on 13/04/2017.
 */

public class Goods {
    private int id;
    private User user;
    private String name;
    private double price;
    private Category category;
    private Location location;
    private GoodsState goodsState;
    private String remark;
    private Picture mainPicture;
    private long timestamp;
    private Brand brand;

    public Goods() {
    }

    public Goods(int id, User user, String name, double price, Category category, Location location, GoodsState goodsState, String remark, Picture mainPicture, long timestamp, Brand brand) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.price = price;
        this.category = category;
        this.location = location;
        this.goodsState = goodsState;
        this.remark = remark;
        this.mainPicture = mainPicture;
        this.timestamp = timestamp;
        this.brand = brand;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public GoodsState getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(GoodsState goodsState) {
        this.goodsState = goodsState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Picture getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(Picture mainPicture) {
        this.mainPicture = mainPicture;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }




    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", location=" + location +
                ", goodsState=" + goodsState +
                ", remark='" + remark + '\'' +
                ", mainPicture=" + mainPicture +
                ", timestamp=" + timestamp +
                ", brand=" + brand +
                '}';
    }
}
