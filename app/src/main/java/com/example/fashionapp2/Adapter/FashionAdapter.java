package com.example.fashionapp2.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fashionapp2.Domain.FashionDomain;
import com.example.fashionapp2.R;
import com.example.fashionapp2.ShowDetailActivity;

import java.util.ArrayList;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.ViewHolder> {
    ArrayList<FashionDomain> FashionDomains;

    public FashionAdapter(ArrayList<FashionDomain> FashionDomains) {
        this.FashionDomains = FashionDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_fashion,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(FashionDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(FashionDomains.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(FashionDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", FashionDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return FashionDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic;
        RelativeLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            mainLayout = itemView.findViewById(R.id.mainlayout2);
        }
    }
}
