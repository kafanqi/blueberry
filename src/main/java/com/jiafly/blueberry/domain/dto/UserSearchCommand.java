package com.jiafly.blueberry.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuyi
 */
@ApiModel("用户搜索参数")
public class UserSearchCommand {
    @ApiModelProperty(value = "用户名", required = false)
    private String username;
    @ApiModelProperty(value = "昵称", required = false)
    private String nickname;
    @ApiModelProperty(value = "邮箱", required = false)
    private String email;
    @ApiModelProperty(value = "手机号", required = false)
    private String mobile;
    @ApiModelProperty(value = "性别 0:未知，1:男，2:女", required = false)
    private Integer gender;
    @ApiModelProperty(value = "城市", required = false)
    private String city;
    @ApiModelProperty(value = "省", required = false)
    private String province;
    @ApiModelProperty(value = "国家", required = false)
    private String country;
    @ApiModelProperty(value = "微信openId", required = false)
    private String openId;
    @ApiModelProperty(value = "微信unionId", required = false)
    private String unionId;
    @ApiModelProperty(value = "状态 10:正常，20:冻结", required = false)
    private Integer status;

    public UserSearchCommand() {
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
}
