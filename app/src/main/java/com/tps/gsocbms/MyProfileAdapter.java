package com.tps.gsocbms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyProfileAdapter extends RecyclerView.Adapter<MyProfileAdapter.MyViewHolder> {

    private final Context context;
    private final List<Petition> myPetition;

    public MyProfileAdapter(Context context, List<Petition> myPetition) {
        this.context = context;
        this.myPetition = myPetition;
    }

    @NonNull
    @Override
    public MyProfileAdapter.MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_petition_format, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProfileAdapter.MyViewHolder holder, int position) {
        Petition petition = myPetition.get(position);
        holder.title_my_petition_view.setText(petition.title);
        if (petition.status.equalsIgnoreCase("pending")) {
            holder.title_my_petition_view.setBackgroundColor(Color.RED);
        } else if (petition.status.equalsIgnoreCase("in progress")) {
            holder.title_my_petition_view.setBackgroundColor(Color.YELLOW);
        } else if (petition.status.equalsIgnoreCase("resolved")) {
            holder.title_my_petition_view.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return myPetition.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView title_my_petition_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_my_petition_view = itemView.findViewById(R.id.view_my_petitions);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            String title_my_petition = myPetition.get(getAdapterPosition()).getTitle();
            String email_my_petition = myPetition.get(getAdapterPosition()).getEmail();
            String status_my_petition = myPetition.get(getAdapterPosition()).getStatus();
            String text_my_petition = myPetition.get(getAdapterPosition()).getPetitionText();

            Intent intent = new Intent(context, ViewMyPetition.class);
            intent.putExtra("title_my_petition", title_my_petition);
            intent.putExtra("email_my_petition", email_my_petition);
            intent.putExtra("status_my_petition", status_my_petition);
            intent.putExtra("text_my_petition", text_my_petition);
            context.startActivity(intent);
        }
    }

}