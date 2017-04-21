package com.chao117.projectepay.model;

import java.util.Date;

/**
 * Created by chan on 13/04/2017.
 */

public class User {
    private int id;
    private String account;
    private String password;
    private String name;
    private String gender;
    private Date birth;
    private String phone;
    private String header;//用户的头像的位置
    private String headerLocal;//本地头像的位置
    private String remark;
    private long timestamp;

    public User() {
    }

    public User(int id, String account, String password, String name, String gender, Date birth, String phone, String header, String headerLocal, String remark, long timestamp) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.phone = phone;
        this.header = header;
        this.headerLocal = headerLocal;
        this.remark = remark;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeaderLocal() {
        return headerLocal;
    }

    public void setHeaderLocal(String headerLocal) {
        this.headerLocal = headerLocal;
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
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", header='" + header + '\'' +
                ", headerLocal='" + headerLocal + '\'' +
                ", remark='" + remark + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
