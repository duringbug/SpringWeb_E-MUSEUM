package com.tjf.myBatis.project;

import org.springframework.lang.Nullable;

/**
 * @author 唐健峰
 * @version 1.0
 * @date 2023/1/4 15:15
 * @description:
 */
public class Museums {
    @Nullable
    private String username;
    @Nullable
    private String museum_class;
    @Nullable
    private String creat_time;
    @Nullable
    private String museum_name;
    @Nullable
    private String museum_path;
    @Nullable
    private String update_by;

    @Override
    public String toString() {
        return "Museums{" +
                "username='" + username + '\'' +
                ", museum_class='" + museum_class + '\'' +
                ", creat_time='" + creat_time + '\'' +
                ", museum_name='" + museum_name + '\'' +
                ", museum_path='" + museum_path + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public String getMuseum_class() {
        return museum_class;
    }

    public void setMuseum_class(@Nullable String museum_class) {
        this.museum_class = museum_class;
    }

    @Nullable
    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(@Nullable String creat_time) {
        this.creat_time = creat_time;
    }

    @Nullable
    public String getMuseum_name() {
        return museum_name;
    }

    public void setMuseum_name(@Nullable String museum_name) {
        this.museum_name = museum_name;
    }

    @Nullable
    public String getMuseum_path() {
        return museum_path;
    }

    public void setMuseum_path(@Nullable String museum_path) {
        this.museum_path = museum_path;
    }

    @Nullable
    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(@Nullable String update_by) {
        this.update_by = update_by;
    }

    public Museums() {
    }

    public Museums(@Nullable String username, @Nullable String museum_class, @Nullable String creat_time, @Nullable String museum_name, @Nullable String museum_path, @Nullable String update_by) {
        this.username = username;
        this.museum_class = museum_class;
        this.creat_time = creat_time;
        this.museum_name = museum_name;
        this.museum_path = museum_path;
        this.update_by = update_by;
    }
}
