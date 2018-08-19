package com.example.rany.room_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.rany.room_demo.R;
import com.example.rany.room_demo.data.local.room.dao.ArticleDao;
import com.example.rany.room_demo.data.local.room.db.ArticleDatabase;
import com.example.rany.room_demo.entity.Article;
import com.example.rany.room_demo.util.ToastMessage;

public class AddArticleActivity extends AppCompatActivity {

    EditText title,content;
    Button btnSave;
    ArticleDao articleDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        title=findViewById(R.id.title);
        content=findViewById(R.id.content);
        btnSave=findViewById(R.id.btnSave);

        articleDao= ArticleDatabase.getDatabase(this).getArticleDao();

        btnSave.setOnClickListener(v->{
            Article article=new Article();
            article.title=title.getText().toString();
            article.content=content.getText().toString();
            article.userId=1;
            articleDao.add(article);
            ToastMessage.showMessage(this,"save success");
        });
    }
}
