package com.example.monu.khattoproject.Adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monu.khattoproject.Model.Favorite;
import com.example.monu.khattoproject.R;

import java.util.List;

public class FavoriteAdepter extends RecyclerView.Adapter<FavoriteAdepter.FavoriteViewHolder> {
    Context context;
    List<Favorite> favoriteList;

    public FavoriteAdepter(Context context, List<Favorite> favoriteList) {
        this.context = context;
        this.favoriteList = favoriteList;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.favorite_list_design,null);


        return new FavoriteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder favoriteViewHolder, int i) {
       favoriteViewHolder.item_name.setText(favoriteList.get(i).getItem_name());
       favoriteViewHolder.item_price.setText(favoriteList.get(i).getItem_price());
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public class FavoriteViewHolder extends RecyclerView.ViewHolder {
        TextView item_name,item_price;
        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
            item_price=itemView.findViewById(R.id.item_price);
        }
    }
}
