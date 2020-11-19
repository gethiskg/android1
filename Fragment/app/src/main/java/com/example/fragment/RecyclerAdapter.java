package com.example.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Destinations> list;
    private Context context;
    private Ifragments listener;



    public RecyclerAdapter(ArrayList<Destinations> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView titleTextView;
        private TextView description;
        private ImageView titleImageView;
        private Destinations model;
        int pos = 0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = itemView.findViewById(R.id.tvTitle);
            titleImageView = itemView.findViewById(R.id.img_row);
            description = itemView.findViewById(R.id.tvDesc);
        }

        private void onBind(Destinations model, int position) {
            this.pos = position;
            this.model = model;
            titleTextView.setText(model.getTitle());
            titleImageView.setImageResource(model.getImageView());
            description.setText(model.getDescription());

        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onDisplayDetails(model.getTitle(),model.getDescription());
            }
        }
    }
        public void setOnClickListener(Ifragments mListener){
            this.listener =  mListener;
    }


}
