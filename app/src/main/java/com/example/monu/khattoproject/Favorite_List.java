package com.example.monu.khattoproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.monu.khattoproject.Adepter.FavoriteAdepter;
import com.example.monu.khattoproject.Database.KhattoDB;
import com.example.monu.khattoproject.Model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class Favorite_List extends AppCompatActivity {
   RecyclerView recyclerView;
   KhattoDB khattoDB;
   List<Favorite> favoriteList=new ArrayList<>();
   FavoriteAdepter favoriteAdepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite__list);
        khattoDB =new KhattoDB(this);
        recyclerView=findViewById(R.id.favorite_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadData();
    }

    private void loadData() {
        if (favoriteList!=null){
            favoriteList.clear();
        }
        Cursor cursor=khattoDB.select_all_favorite_list();

        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(khattoDB.ITEM_NAME));
            String price=cursor.getString(cursor.getColumnIndex(khattoDB.ITEM_PRICE));

            Favorite favorite=new Favorite(name,price);
            favoriteList.add(favorite);
        }
        favoriteAdepter=new FavoriteAdepter(this,favoriteList);

        recyclerView.setAdapter(favoriteAdepter);


    }
}
