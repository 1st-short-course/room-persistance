package com.example.rany.room_demo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

public class UserArticle {

    @ColumnInfo(name = "user_id")
    public int userId;
    public String name;
    public String email;
    public String password;
    @ColumnInfo(name = "article_id")
    public int articleId;
    public String title;
    public String content;
    @ColumnInfo(name = "created_date")
    public String createdDate;

    @Override
    public String toString() {
        return "UserArticle{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
