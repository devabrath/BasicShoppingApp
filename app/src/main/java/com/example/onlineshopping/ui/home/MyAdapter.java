package com.example.onlineshopping.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Data> dataArrayList;

    public MyAdapter(Context context, ArrayList<Data> dataArrayList){
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_custom_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data data = dataArrayList.get(position);
        holder.prodHeading.setText(data.heading);
        holder.titleImage.setImageResource(data.titleImage);
        holder.prodDesc.setText(data.Desc);
        holder.price.setText(data.Price);
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImage;
        TextView prodHeading;
        TextView prodDesc;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            prodHeading = itemView.findViewById(R.id.textviewProdInfo);
            prodDesc = itemView.findViewById(R.id.textViewProdDisp);
            price = itemView.findViewById(R.id.price);

        }
    }

}
