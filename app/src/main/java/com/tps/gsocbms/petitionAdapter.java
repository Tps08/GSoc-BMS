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

public class petitionAdapter extends RecyclerView.Adapter<petitionAdapter.petitionHolder> {

    private final Context context;
    private final List<Petition> petitionList;
    final String s;

    public petitionAdapter(Context context, List<Petition> petitionList,String s) {
        this.context = context;
        this.petitionList = petitionList;
        this.s=s;
    }

    @NonNull
    @Override
    public petitionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.show_petition_format,parent,false);
        return new petitionHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull petitionAdapter.petitionHolder holder, int position) {
        Petition petition = petitionList.get(position);
        holder.title_admin.setText(petition.title);
        if(petition.status.equalsIgnoreCase("pending")){
            holder.title_admin.setBackgroundColor(Color.RED);
        } else if(petition.status.equalsIgnoreCase("in progress")){
            holder.title_admin.setBackgroundColor(Color.YELLOW);
        } else if(petition.status.equalsIgnoreCase("resolved")){
            holder.title_admin.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    public int getItemCount() {
        return petitionList.size();
    }

    public class petitionHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView title_admin;
        public petitionHolder(@NonNull View itemView) {
            super(itemView);
            title_admin = itemView.findViewById(R.id.view_petition_admin);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            String titleAdmin = petitionList.get(getAdapterPosition()).getTitle();
            String emailAdmin = petitionList.get(getAdapterPosition()).getEmail();
            String statusAdmin = petitionList.get(getAdapterPosition()).getStatus();
            String petitionTextAdmin = petitionList.get(getAdapterPosition()).getPetitionText();

            Intent intent = new Intent(context,ViewPetitionAdmin.class);
            intent.putExtra("titleAdmin",titleAdmin);
            intent.putExtra("emailAdmin",emailAdmin);
            intent.putExtra("statusAdmin",statusAdmin);
            intent.putExtra("petitionTextAdmin",petitionTextAdmin);
            intent.putExtra("department",s);
            context.startActivity(intent);

        }
    }
}
