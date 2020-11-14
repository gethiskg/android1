package com.example.homeworkfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private List<String> listItem;
        private Context context;


    public MyAdapter(List<String> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }


    public void addOn(String text){
        listItem.add(text);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.costom_recycler_fragment,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textRecycler.setText(listItem.get(position));


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textRecycler;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textRecycler = itemView.findViewById(R.id.textInRecycler);
        }
    }
}
