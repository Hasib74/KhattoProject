package com.example.monu.khattoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monu.khattoproject.Database.KhattoDB;

public class MainActivity extends AppCompatActivity {
    EditText item_name,item_price;
    Button save_btn,next_btn,fav;
    KhattoDB khattoDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        khattoDB=new KhattoDB(getApplicationContext());
        item_name=findViewById(R.id.item_name);
        item_price=findViewById(R.id.item_price);
        save_btn=findViewById(R.id.save);
        next_btn=findViewById(R.id.nextActivity);
        fav=findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Favorite_List.class));
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (!TextUtils.isEmpty(item_name.getText().toString()) || !TextUtils.isEmpty(item_price.getText().toString())){
                   String  response=khattoDB.insertIntoTheDatabase(item_name.getText().toString(),item_price.getText().toString());
                   Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
               }

             //  startActivity(new Intent(getApplicationContext(),ShowKattaData.class));
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ShowKattaData.class));
            }
        });


    }
}
