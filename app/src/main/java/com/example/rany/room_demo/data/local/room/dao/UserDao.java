package com.example.rany.room_demo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rany.room_demo.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);
    @Update
    void editUser(User user);
    @Delete
    void removeUser(User user);
    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Query("delete from users where name = :name")
    void removeByName(String name);
}
