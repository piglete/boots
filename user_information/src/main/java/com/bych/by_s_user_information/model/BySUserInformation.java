package com.bych.by_s_user_information.model;

import club.map.core.mapper.ColumnTransient;
import club.map.core.model.RootObject;
import club.map.core.model.TableName;

@TableName("by_s_user_information")
public class BySUserInformation extends RootObject {
    private String loginName;//用户账号

    private String password;//用户密码

    private String userName;//用户名称

    private String icon;//图标

    private String sex;//性别

    private String telephone;//联系电话

    private String email;//邮箱

    private String address;//住址

    private String remark;//备注


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ColumnTransient
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", userName=").append(userName);
        sb.append(", icon=").append(icon);
        sb.append(", sex=").append(sex);
        sb.append(", telephone=").append(telephone);
        sb.append(", email=").append(email);
        sb.append(", address=").append(telephone);
//        sb.append(", byBEmployee=").append(byBEmployee);
        sb.append("]");
        return sb.toString();
    }
}