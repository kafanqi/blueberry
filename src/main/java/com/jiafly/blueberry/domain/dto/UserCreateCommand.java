package com.jiafly.blueberry.domain.dto;

import com.jiafly.blueberry.common.utils.SnowIdUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author liuyi
 */
@ApiModel("用户创建参数")
public class UserCreateCommand {
    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;
    @ApiModelProperty(value = "头像", required = false)
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
    @ApiModelProperty(value = "微信openId", required = true)
    private String openId;
    @ApiModelProperty(value = "微信unionId", required = false)
    private String unionId;
    @ApiModelProperty(value = "状态 10:正常，20:冻结", required = false)
    private Integer status;

    public UserCreateCommand() {
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
}
