package com.chao117.projectepay.model;

/**
 * Created by chan on 13/04/2017.
 */

public class Picture {
    private int id;
    private String url;
    private Goods goods;
    private long timestamp;

    public Picture() {
    }

    public Picture(int id, String url, Goods goods, long timestamp) {
        this.id = id;
        this.url = url;
        this.goods = goods;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", goods=" + goods +
                ", timestamp=" + timestamp +
                '}';
    }
}
