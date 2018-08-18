package com.example.rany.room_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.rany.room_demo.data.local.room.dao.UserDao;
import com.example.rany.room_demo.data.local.room.db.ArticleDatabase;
import com.example.rany.room_demo.entity.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    Button btnSave,btnGet,btnEdit,btnDelete;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDelete=findViewById(R.id.deleteUser);
        btnSave=findViewById(R.id.saveUser);
        btnEdit=findViewById(R.id.editUser);
        btnGet=findViewById(R.id.getUser);

        userDao=ArticleDatabase.getDatabase(this).getUserDao();

        btnSave.setOnClickListener(v->{
            User user=new User();
            user.name="chamroern";
            user.email="chamroern@gmial.com";
            user.password="1234567";

            userDao.addUser(user);
            showMessage("save success");
        });


        btnGet.setOnClickListener(v->{
            List<User> users=userDao.getAllUser();
            Log.e(TAG, "onCreate: "+users );
        });

        btnEdit.setOnClickListener(v->{
            User user=new User();
            user.id=1;
            user.name="visal";
            userDao.editUser(user);
        });

        btnDelete.setOnClickListener(v->{
            User user=new User();
            user.id=1;

            //userDao.removeUser(user);
            userDao.removeByName("chamroern");
            showMessage("remove user success");
        });

    }
    public void showMessage(String smg){
        Toast.makeText(this, smg, Toast.LENGTH_SHORT).show();
    }

    private static final String TAG = "MainActivity";
}
