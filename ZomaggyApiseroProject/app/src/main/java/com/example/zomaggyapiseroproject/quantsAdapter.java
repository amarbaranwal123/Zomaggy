package com.example.zomaggyapiseroproject;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quantsAdapter extends RecyclerView.Adapter<quantsAdapter.MyViewHolder>{

    quantsAdapter(Context mcontext, ArrayList<Model> maths, int l)
    {
        this.maths=maths;
        this.mcontext=mcontext;
        this.l=l;
    }

    Context mcontext;
    int l;
    ArrayList <Model> maths;

    @NonNull
    @Override
    public quantsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.quanstems,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull quantsAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(maths.get(position).getText());
        holder.number.setText(maths.get(position).getNumber());
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return l;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView number;
        TextView textView;
        Button btn1;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.textView);
            btn1=itemView.findViewById(R.id.btn1);
            number=itemView.findViewById(R.id.number);
        }
    }

}
