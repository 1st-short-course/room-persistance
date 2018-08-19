package com.example.rany.room_demo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rany.room_demo.entity.Article;
import com.example.rany.room_demo.entity.UserArticle;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM article order by id desc")
    List<Article> getAllArticle();

    /*@Query("SELECT users.id as user_id , users.name,users.email,users.password" +
            "  FROM article " +
            "join users on users.id=article.user_id "+
            "order by article.id desc")*/
    @Query("SELECT *,article.id as article_id  FROM article " +
            "join users on users.id=article.user_id "+
            "order by article.id desc")
    List<UserArticle> getAllArticleWithUser();

    @Insert
    void add(Article article);
    @Delete
    void remove(Article article);
    @Update
    void update(Article article);
}
