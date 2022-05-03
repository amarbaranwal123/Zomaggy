package com.example.zomaggyapiseroproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quantsAdapter1 extends RecyclerView.Adapter<quantsAdapter1.MyViewHolder1>{

    Context mcontext;
    int l;
    ArrayList <Model1> maths;
    quantsAdapter1(Context mcontext, ArrayList<Model1> maths, int l)
    { this.maths=maths;
        this.mcontext=mcontext;
        this.l=l;
    }

    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.quanstems1,parent,false);
        return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {

        holder.textView.setText(maths.get(position).getText());
        holder.number.setText(maths.get(position).getNumber());
        holder.price.setText(maths.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return l;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView number;
        TextView textView;
        TextView price;


        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            price=itemView.findViewById(R.id.price);
            number=itemView.findViewById(R.id.number);
        }
    }
}
