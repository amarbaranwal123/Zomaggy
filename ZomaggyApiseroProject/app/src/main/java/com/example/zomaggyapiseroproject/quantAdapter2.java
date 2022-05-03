package com.example.zomaggyapiseroproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quantAdapter2 extends RecyclerView.Adapter<quantAdapter2.MyViewHolder2>{

    Context mcontext;
    int l;
    ArrayList<Model2> maths;
    quantAdapter2(Context mcontext, ArrayList<Model2> maths, int l)
    { this.maths=maths;
        this.mcontext=mcontext;
        this.l=l;
    }


    @NonNull
    @Override
    public quantAdapter2.MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.quantstems2,parent,false);
        return new quantAdapter2.MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull quantAdapter2.MyViewHolder2 holder, int position) {
        //holder.ID.setText(maths.get(position).getID());
        holder.ResName.setText(maths.get(position).getResName());
        holder.Ratings.setText(maths.get(position).getRatings());
        holder.city.setText(maths.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return l;
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView ID;
        TextView ResName;
        TextView Ratings;
        TextView city;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);

            ID=itemView.findViewById(R.id.id);
            ResName=itemView.findViewById(R.id.resname);
            Ratings=itemView.findViewById(R.id.rating);
            city=itemView.findViewById(R.id.city);
        }
    }
}
