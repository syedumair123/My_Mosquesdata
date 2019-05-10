package com.example.my_mosquesdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MosqueDataAdapter extends RecyclerView.Adapter<MosqueDataAdapter.Myviewholder> {
 private LayoutInflater inflater;
 private ArrayList<Mosque> mosquelist;
 public MosqueDataAdapter(Context context, ArrayList<Mosque> mosquelist){
     inflater=LayoutInflater.from(context);
     this.mosquelist=mosquelist;
 }

    @NonNull
    @Override
    public MosqueDataAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem= layoutInflater.inflate(R.layout.single_detaill_layout, viewGroup, false);
        Myviewholder viewHolder = new Myviewholder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i) {
        Picasso.get().load(mosquelist.get(i).getImageurl()).into(myviewholder.mosqueimg);
        myviewholder.nametext.setText(mosquelist.get(i).getName());
        myviewholder.addresstext.setText(mosquelist.get(i).getAddress());

    }

    @Override
    public int getItemCount() {
        return mosquelist.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {
TextView nametext,addresstext;
ImageView mosqueimg;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            nametext=(TextView) itemView.findViewById(R.id.nametxt);
            addresstext=(TextView) itemView.findViewById(R.id.addresstxt);
            mosqueimg=(ImageView) itemView.findViewById(R.id.mosqueimage);
        }
    }
}
