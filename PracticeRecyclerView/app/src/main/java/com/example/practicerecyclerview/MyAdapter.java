package com.example.practicerecyclerview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<PersonInfo> list;
    private Context context;

    public MyAdapter(ArrayList<PersonInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ArrayList<PersonInfo> getList() {
        return list;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.costomized_view_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PersonInfo personInfo = list.get(position);
        holder.personName.setText(personInfo.getName());
        holder.personAge.setText(Integer.toString(personInfo.getAge()));
        holder.imagePerson.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imagePerson.setImageURI(Uri.parse(list.get(position).getImage()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imagePerson;
    TextView personName,personAge;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imagePerson = itemView.findViewById(R.id.picRecycler);
        personName = itemView.findViewById(R.id.textViewName);
        personAge = itemView.findViewById(R.id.textViewAge);
    }
}
