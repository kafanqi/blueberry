package com.jiafly.blueberry.domain.model;


import com.jiafly.blueberry.common.utils.SnowIdUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * @author liuyi
 */
@Table(name = "user")
public class User {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户名
     */
    private String username;

    private String password;
    private String nickname;
    private String headImage;
    private String email;
    private String mobile;
    private Integer gender;
    private String city;
    private String province;
    private String country;
    private String openId;
    private String unionId;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    public User() {
    }

    public User(String password, String nickname, String headImage, String email, String mobile, Integer gender, String city, String province, String country, String openId, String unionId) {
        this.username = SnowIdUtils.uniqueLongHex();
        this.password = password;
        this.nickname = nickname;
        this.headImage = headImage;
        this.email = email;
        this.mobile = mobile;
        this.gender = Objects.nonNull(gender) ? gender : 0;
        this.city = city;
        this.province = province;
        this.country = country;
        this.openId = openId;
        this.unionId = unionId;
        this.status = 20;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}