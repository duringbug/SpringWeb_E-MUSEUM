package com.tjf.myBatis.project;


import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:08
 * @description:
 */
@Repository("user")
public class User {
    @Nullable
    private int userid;
    @Nullable
    private String username;
    @Nullable
    private String password;
    /**
     * 用户状态：在线或不在线
     */
    @Nullable
    private int del_flg;
    @Nullable
    private String remark;
    @Nullable
    private String create_by;
    @Nullable
    private String create_time;
    @Nullable
    private String update_by;
    @Nullable
    private String update_time;
    @Nullable
    private String userQQmail;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", del_flg=" + del_flg +
                ", remark='" + remark + '\'' +
                ", create_by=" + create_by +
                ", create_time='" + create_time + '\'' +
                ", update_by=" + update_by +
                ", update_time='" + update_time + '\'' +
                ", userQQmail='" + userQQmail + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public int getDel_flg() {
        return del_flg;
    }

    public void setDel_flg(int del_flg) {
        this.del_flg = del_flg;
    }

    @Nullable
    public String getRemark() {
        return remark;
    }

    public void setRemark(@Nullable String remark) {
        this.remark = remark;
    }

    @Nullable
    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    @Nullable
    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(@Nullable String create_time) {
        this.create_time = create_time;
    }
    @Nullable

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    @Nullable
    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(@Nullable String update_time) {
        this.update_time = update_time;
    }

    @Nullable
    public String getUserQQmail() {
        return userQQmail;
    }

    public void setUserQQmail(@Nullable String userQQmail) {
        this.userQQmail = userQQmail;
    }

    public User(int userid, @Nullable String username, @Nullable String password, int del_flg, @Nullable String remark, String create_by, @Nullable String create_time, String update_by, @Nullable String update_time, @Nullable String userQQmail) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.del_flg = del_flg;
        this.remark = remark;
        this.create_by = create_by;
        this.create_time = create_time;
        this.update_by = update_by;
        this.update_time = update_time;
        this.userQQmail = userQQmail;
    }
}
