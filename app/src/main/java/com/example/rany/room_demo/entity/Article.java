package com.example.rany.room_demo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "article",
foreignKeys = @ForeignKey(entity = User.class,parentColumns = "id",
        childColumns ="user_id" ))
public class Article {
    @PrimaryKey(autoGenerate = true)
    public  int id;
    public String title;
    public String content;
    @ColumnInfo(name = "created_date")
    public String createdDate;
    @ColumnInfo(name = "user_id")
    public int userId;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}
