package com.example.monu.khattoproject;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.monu.khattoproject.Adepter.KhattoAdepter;
import com.example.monu.khattoproject.Database.KhattoDB;
import com.example.monu.khattoproject.Interface.FavCick;
import com.example.monu.khattoproject.Model.KhattoData;

import java.util.ArrayList;
import java.util.List;

public class ShowKattaData extends AppCompatActivity  {
   List<KhattoData> khattoDataList=new ArrayList<>();
   KhattoAdepter khattoAdepter;
    KhattoDB khattoDB;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_katta_data);
        khattoDB=new KhattoDB(getApplicationContext());
        recyclerView=findViewById(R.id.recycular_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        loadData();
     /*   khattoAdepter.setFavCick(new FavCick() {
            @Override
            public void setFavClick(View v, int position)
            {

                Toast.makeText(ShowKattaData.this, "Clicked "+position, Toast.LENGTH_SHORT).show();

                if (khattoDataList.get(position).getItem_fav_status().equals("0"))
                {
                    khattoDB.set_fav(khattoDataList.get(position).getKey_id());
                    loadData();
                }else if(khattoDataList.get(position).getItem_fav_status().equals("1"))
                {
                    khattoDB.remove_fav(khattoDataList.get(position).getKey_id());
                    loadData();

                }
            }
        });
*/



    }




    private void loadData() {
        Cursor cursor=khattoDB.read_all_data();
        khattoDataList.clear();
        while (cursor.moveToNext()){
            String item_id=cursor.getString(cursor.getColumnIndex(khattoDB.KEY_ID));
            String item_name=cursor.getString(cursor.getColumnIndex(khattoDB.ITEM_NAME));
            String item_parice=cursor.getString(cursor.getColumnIndex(khattoDB.ITEM_PRICE));
            String item_fav_status=cursor.getString(cursor.getColumnIndex(khattoDB.FAVOURITE_STATUS));

            //String key_id, String item_name, String item_price, String item_fav_status
            KhattoData khattoData=new KhattoData(item_id,item_name,item_parice,item_fav_status);
            khattoDataList.add(khattoData);
        }

        khattoAdepter=new KhattoAdepter(this,khattoDataList);
        recyclerView.setAdapter(khattoAdepter);
    }
}
