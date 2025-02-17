package com.example.mdassignment2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class ViewAdapter  extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{

    private final Context context;
    List<Phone> items;

    public ViewAdapter(Context context,List<Phone> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recycleView.getContext());
        View v = inflater.inflate(R.layout.row_item,recycleView,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.descTxt.setText(items.get(position).getDescription());
        holder.imgView.setImageResource(R.drawable.unnamed);
        holder.icon.setImageResource(R.drawable.info_24dp_000000_fill0_wght400_grad0_opsz24);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, descTxt;
        ShapeableImageView imgView;
        ImageView icon;
        ConstraintLayout item;
        View layout;

        public ViewHolder(View v){
            super(v);
            layout = v;
            titleTxt = v.findViewById(R.id.titleTxt);
            descTxt = v.findViewById(R.id.DescriptionTxt);
            icon = v.findViewById(R.id.icon);
            imgView = v.findViewById(R.id.imgID);
            item = v.findViewById(R.id.item);
        }

    }
}
