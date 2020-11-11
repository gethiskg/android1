package com.example.rcyclerinotherway;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ItemOnClickListener itemOnClickListener;
    List<TitleModel> list;
    Context context;


    public MyAdapter(List<TitleModel> list, Context context, ItemOnClickListener itemOnClickListener) {
        this.list = list;
        this.context = context;
        this.itemOnClickListener = itemOnClickListener;
    }

    public void addApplication(TitleModel titleModel) {
        list.add(titleModel);
        notifyDataSetChanged();
    }

    public void replaceItem(TitleModel titleModel, int pos) {
        list.set(pos, titleModel);
        notifyItemChanged(pos);
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.costom_view_recycler, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popupMenu = new PopupMenu(context, holder.moreButton);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.itemSave:
                                Toast.makeText(context, "has been saved", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.itemDelete:
                                list.remove(position);
                                notifyDataSetChanged();
                                break;
                            default:
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView contactImage;
        ImageButton moreButton;
        TextView contactName, contactPhone;
        TitleModel titleModel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactImage = itemView.findViewById(R.id.contactImage);
            moreButton = itemView.findViewById(R.id.moreBtn);
            contactName = itemView.findViewById(R.id.contactName);
            contactPhone = itemView.findViewById(R.id.contactPhone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemOnClickListener.clickListener(getAdapterPosition());
                }
            });
        }
        public void onBind(TitleModel model) {
            this.titleModel = model;
            contactName.setText(model.name);
            contactPhone.setText(model.phoneNumber);
            Glide.with(context)
                    .load(model.image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(contactImage);
        }
    }
}