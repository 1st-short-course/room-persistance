package com.example.rany.room_demo.data.local.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.rany.room_demo.data.local.room.dao.ArticleDao;
import com.example.rany.room_demo.data.local.room.dao.UserDao;
import com.example.rany.room_demo.entity.Article;
import com.example.rany.room_demo.entity.User;

@Database(version = 2,entities = {User.class, Article.class})
public abstract class ArticleDatabase extends RoomDatabase{
    public static final String DB_NAME="article_db";
    public abstract UserDao getUserDao();
    public abstract ArticleDao getArticleDao();

    public static ArticleDatabase getDatabase(Context context){
        return Room.databaseBuilder(context,ArticleDatabase.class,DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
