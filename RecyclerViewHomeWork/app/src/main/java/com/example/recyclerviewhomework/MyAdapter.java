package com.example.recyclerviewhomework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<UserInfo> list;
    Context context;

    public List<UserInfo> getList() {
        return list;
    }

    public Context getContext() {
        return context;
    }

    public MyAdapter(List<UserInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.costom_view_recycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserInfo userInfo = list.get(position);
        holder.textName.setText(userInfo.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    TextView textName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.firstName);


    }
}
