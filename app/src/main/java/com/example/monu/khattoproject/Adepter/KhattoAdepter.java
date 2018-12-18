package com.example.monu.khattoproject.Adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monu.khattoproject.Database.KhattoDB;
import com.example.monu.khattoproject.Interface.FavCick;
import com.example.monu.khattoproject.Model.KhattoData;
import com.example.monu.khattoproject.R;

import java.util.List;

public class KhattoAdepter extends RecyclerView.Adapter<KhattoAdepter.KhattoViewHolder> {

    Context context;
    List<KhattoData> khattoDataList;
    KhattoDB khattoDB;
    private FavCick favCick;

    public void setFavCick(FavCick favCick) {
        this.favCick = favCick;
    }

    public KhattoAdepter(Context context, List<KhattoData> khattoDataList) {
        this.context = context;
        this.khattoDataList = khattoDataList;
    }

    @NonNull
    @Override
    public KhattoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        khattoDB = new KhattoDB(context);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.khatto_recycular_design, null);
        return new KhattoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final KhattoViewHolder khattoViewHolder, final int i) {
        khattoViewHolder.item_name.setText(khattoDataList.get(i).getItem_name());
        khattoViewHolder.item_price.setText(khattoDataList.get(i).getItem_price());

//        notifyDataSetChanged();




        if (khattoDataList.get(i).getItem_fav_status().equals("1")) {
            khattoViewHolder.item_fav.setImageResource(R.drawable.favourite);
        } else if (khattoDataList.get(i).getItem_fav_status().equals("0"))
        {
            khattoViewHolder.item_fav.setImageResource(R.drawable.favourite_null);
        }


        khattoViewHolder.item_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /* if (khattoViewHolder.item_fav.getDrawable()==context.getResources().getDrawable(R.drawable.favourite)){
                   khattoDB.remove_fav(khattoDataList.get(i).getKey_id());
                   khattoViewHolder.item_fav.setImageResource(R.drawable.favourite_null);
               }else if (khattoViewHolder.item_fav.getDrawable()==context.getResources().getDrawable(R.drawable.favourite_null)){
                   khattoDB.set_fav(khattoDataList.get(i).getKey_id());
                   khattoViewHolder.item_fav.setImageResource(R.drawable.favourite);
               }*/
                 String  status=khattoDataList.get(i).getItem_fav_status();
                Toast.makeText(context, ""+status, Toast.LENGTH_SHORT).show();
                if (khattoDataList.get(i).getItem_fav_status().equals("0")){
                    khattoDB.set_fav(khattoDataList.get(i).getKey_id());
                    khattoViewHolder.item_fav.setImageResource(R.drawable.favourite);

                }else if (khattoDataList.get(i).getItem_fav_status().equals("1")){
                    khattoDB.remove_fav(khattoDataList.get(i).getKey_id());
                    khattoViewHolder.item_fav.setImageResource(R.drawable.favourite_null);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return khattoDataList.size();
    }

    public class KhattoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_name, item_price;
        ImageView item_fav;

        public KhattoViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
            item_fav = itemView.findViewById(R.id.item_fav);
            item_fav.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            try {
                favCick.setFavClick(v, getAdapterPosition());
            } catch (Exception e) {

            } finally {

            }

        }
    }
}
