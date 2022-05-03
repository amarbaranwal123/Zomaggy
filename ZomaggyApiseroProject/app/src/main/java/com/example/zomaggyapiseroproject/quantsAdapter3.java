package com.example.zomaggyapiseroproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class quantsAdapter3 extends RecyclerView.Adapter<quantsAdapter3.MyViewHolder3>{

    Context mcontext;
    int l;
    ArrayList<Model3> maths;
    String UserId;

    Integer image[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.orderhistoryimage,R.drawable.fitnessimage};

    quantsAdapter3(Context mcontext, ArrayList<Model3> maths, int l,String UserId)
    { this.maths=maths;
        this.mcontext=mcontext;
        this.l=l;
        this.UserId=UserId;
    }

    @NonNull
    @Override
    public quantsAdapter3.MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.quanstems3,parent,false);
        return new quantsAdapter3.MyViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull quantsAdapter3.MyViewHolder3 holder, int position) {
        holder.text.setText(maths.get(position).getText());




        int id=image[position];
        holder.image.setImageResource(id);




        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                {
                    Intent intent=new Intent(mcontext,AboutUs.class);

                    mcontext.startActivity(intent);
                }
                else if(position==1)
                {
                    Intent intent=new Intent(mcontext,CityActivity.class);
                    intent.putExtra("useridnew",UserId);
                    mcontext.startActivity(intent);
                }
                else if(position==2)
                {
                    Intent intent=new Intent(mcontext,WebViewActivity.class);
                    intent.putExtra("useridnew",UserId);
                    mcontext.startActivity(intent);
                }
                else if(position==3)
                {
                    Intent intent=new Intent(mcontext,Recommendation.class);
                    intent.putExtra("user_id",UserId);
                    mcontext.startActivity(intent);
                }
                else if(position==4)
                {
                    Intent intent=new Intent(mcontext,Gami.class);
                    intent.putExtra("useridne",UserId);
                    mcontext.startActivity(intent);
                }
                else if(position==5)
                {
                    Intent intent=new Intent(mcontext,AvailableItem.class);

                    mcontext.startActivity(intent);
                }
                else if(position==6)
                {


                    Intent intent=new Intent(mcontext,OrderHistory.class);
                    intent.putExtra("useridnew",UserId);

                    mcontext.startActivity(intent);
                }

                else if(position==7)
                {
                    Intent intent=new Intent(mcontext,FitnessActivity.class);
                    intent.putExtra("useridnew",UserId);

                    mcontext.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return l;
    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder {


        ImageView image;
        TextView text;


        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            text=itemView.findViewById(R.id.text);

        }
    }
}
