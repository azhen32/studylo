package com.azhen.domain;

import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Long id;

    private Byte state;

    private String nickname;

    private String comment;

    @Length(min = 5, max = 20, message = "{phone.length.illegal}")
    private String phone;

    @NotBlank(message="{email.notblank}")
    @Pattern(regexp = "[a-zA-Z]{5,20}", message = "{email.format.illegal}")
    private String email;

    @NotNull(message = "{password.notnull}")
    private String password;

    private Date createTime;

    private Date updateTime;

    private List<UsersRoles> userRoles;

    private List<Videos> videos;

    public User() {}
    public User(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public List<UsersRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UsersRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Videos> getVideos() {
        return videos;
    }

    public void setVideos(List<Videos> videos) {
        this.videos = videos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", state=" + state +
                ", nickname='" + nickname + '\'' +
                ", comment='" + comment + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}