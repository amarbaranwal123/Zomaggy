package com.example.zomaggyapiseroproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quantsAdapter4 extends RecyclerView.Adapter<quantsAdapter4.MyViewHolder4>{

    Context mcontext;
    int l;
    ArrayList<Model4> maths;
    quantsAdapter4(Context mcontext, ArrayList<Model4> maths, int l)
    { this.maths=maths;
        this.mcontext=mcontext;
        this.l=l;
    }

    @NonNull
    @Override
    public quantsAdapter4.MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.quanstems4,parent,false);
        return new quantsAdapter4.MyViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull quantsAdapter4.MyViewHolder4 holder, int position) {
        holder.resname.setText(maths.get(position).getResname());
    }

    @Override
    public int getItemCount() {
        return l;
    }

    public class MyViewHolder4 extends RecyclerView.ViewHolder {

        TextView resname;

        public MyViewHolder4(@NonNull View itemView) {
            super(itemView);

            resname=itemView.findViewById(R.id.resname);
        }
    }
}
