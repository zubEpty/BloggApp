package com.example.blogg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class blogAdapter extends RecyclerView.Adapter<blogAdapter.MyViewHolder>{


    private Context mContext;
    private List<blogModel> bData;

    public blogAdapter(Context mContext, List<blogModel> bData) {
        this.mContext = mContext;
        this.bData = bData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.blogitems,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.id.setText(bData.get(position).getId());
        holder.title.setText(bData.get(position).getTitle());

        holder.categ.setText(bData.get(position).getCateg());
        holder.categ1.setText(bData.get(position).getCateg1());



        holder.cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,DetailsActivity.class);
                intent.putExtra("avatar", bData.get(position).getAvatar());
               // intent.putExtra("title", bData.get(position).getTitle());
                intent.putExtra("name", bData.get(position).getName());
                intent.putExtra("description", bData.get(position).getDescription());
                intent.putExtra("profession", bData.get(position).getProf());

                mContext.startActivity(intent);
            }
        });

        Glide.with(mContext)
                .load(bData.get(position).getImage())
                .into(holder.img);





    }

    @Override
    public int getItemCount() {
        return bData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView title;
        TextView categ;
        TextView categ1;
        TextView nam;
        TextView prof;
        TextView desc;



        ImageView img;
        ImageView avt;


        ConstraintLayout cons;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id_text);
            title = itemView.findViewById(R.id.title_txt);
            nam = itemView.findViewById(R.id.name_txt);
            prof = itemView.findViewById(R.id.prof);
            desc = itemView.findViewById(R.id.descrip);

            categ = itemView.findViewById(R.id.cat_txt);
            categ1 = itemView.findViewById(R.id.cat1_txt);


            img = itemView.findViewById(R.id.imageView);
            avt = itemView.findViewById(R.id.cover);

            cons = itemView.findViewById(R.id.cat);
        }
    }

}
