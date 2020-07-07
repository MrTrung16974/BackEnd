package com.example.backendkyc.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document("sa_user")
public class User  implements Serializable {

    @Id
    private String userID;

    @Field(name = "user_name")
    private String userName;

    @Field(name = "full_name")
    private String fullName;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "fail_login_count")
    private Integer failLoginCount;

    @Field(name = "roleID")
    private String roleID;

    @Field(name = "status")
    private Integer status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "Asia/Saigon")
    @Field(name = "last_login")
    private Date lastLogin;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getFailLoginCount() {
        return failLoginCount;
    }

    public void setFailLoginCount(Integer failLoginCount) {
        this.failLoginCount = failLoginCount;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
