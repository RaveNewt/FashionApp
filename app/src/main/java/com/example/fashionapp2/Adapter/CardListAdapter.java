package com.example.fashionapp2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fashionapp2.Domain.FashionDomain;
import com.example.fashionapp2.Helper.ManagementCart;
import com.example.fashionapp2.Interface.ChangeNumberItemsListener;
import com.example.fashionapp2.R;
import com.example.fashionapp2.ShowDetailActivity;

import java.util.ArrayList;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
    ArrayList<FashionDomain> FashionDomains;
    ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CardListAdapter(ArrayList<FashionDomain> FashionDomains, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.FashionDomains = FashionDomains;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_card,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(FashionDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(FashionDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round(FashionDomains.get(position).getNumberInCard() * FashionDomains.get(position).getFee() * 100.0) /100.0));
        holder.num.setText(String.valueOf(FashionDomains.get(position).getNumberInCard()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(FashionDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFashion(FashionDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberFashion(FashionDomains, position, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {
        return FashionDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem, totalEachItem, num;
        ImageView pic, plusItem, minusItem;
        RelativeLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title2Txt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.picCard);
            mainLayout = itemView.findViewById(R.id.mainlayout3);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.num);
            plusItem = itemView.findViewById(R.id.plusItem);
            minusItem = itemView.findViewById(R.id.minusItem);

        }
    }
}
