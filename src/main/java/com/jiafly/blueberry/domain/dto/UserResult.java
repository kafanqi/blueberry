package com.jiafly.blueberry.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author liuyi
 */
@ApiModel("用户返回值")
public class UserResult {
    @ApiModelProperty("主键ID")
    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("昵称")
    private String nickname;
    @ApiModelProperty("头像")
    private String headImage;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("性别 0:未知，1:男，2:女")
    private Integer gender;
    @ApiModelProperty("城市")
    private String city;
    @ApiModelProperty("省")
    private String province;
    @ApiModelProperty("国家")
    private String country;
    @ApiModelProperty("微信openId")
    private String openId;
    @ApiModelProperty("微信unionId")
    private String unionId;
    @ApiModelProperty("状态 10:正常，20:冻结")
    private Integer status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;

    public UserResult() {
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
