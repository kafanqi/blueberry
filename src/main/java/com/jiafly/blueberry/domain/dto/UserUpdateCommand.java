package com.jiafly.blueberry.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author liuyi
 */
@ApiModel("用户修改参数")
public class UserUpdateCommand {
    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;
    @ApiModelProperty(value = "头像", required = true)
    private String headImage;
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
    @ApiModelProperty(value = "状态 10:正常，20:冻结", required = true)
    private Integer status;

    public UserUpdateCommand() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
