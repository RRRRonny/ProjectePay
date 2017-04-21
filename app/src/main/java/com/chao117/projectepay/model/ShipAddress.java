package com.chao117.projectepay.model;

/**
 * Created by chan on 13/04/2017.
 */

public class ShipAddress {
    private int id;
    private User user;
    private Location location;
    private String detail;
    private String remark;
    private long timestamp;

    public ShipAddress() {
    }

    public ShipAddress(int id, User user, Location location, String detail, String remark, long timestamp) {
        this.id = id;
        this.user = user;
        this.location = location;
        this.detail = detail;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        return "ShipAddress{" +
                "id=" + id +
                ", user=" + user +
                ", location=" + location +
                ", detail='" + detail + '\'' +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
