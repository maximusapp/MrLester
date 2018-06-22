package com.lister.mrlister.mrlester.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lister.mrlister.mrlester.R;
import com.lister.mrlister.mrlester.data.ItemsNewProduct;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemListNewProduct extends RecyclerView.Adapter<ItemListNewProduct.ViewHolder> {

    private List<ItemsNewProduct> items = new ArrayList<>();
    private Context context;

    public ItemListNewProduct(Context context, List<ItemsNewProduct> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemListNewProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_unchecked_product_item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ItemListNewProduct.ViewHolder holder, final int position) {

        holder.textName.setText(items.get(position).getName());

        if (items.get(position).getChecked() == 0) {
            holder.imageCheck.setImageResource(R.drawable.unchecked_item);
        } else {
            holder.imageCheck.setImageResource(R.drawable.checkes);
            holder.textName.setTextColor(R.color.colorGray);
        }

        holder.imageCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (items.get(position).getChecked() == 1) {
                    items.get(position).setChecked(0);
                    holder.imageCheck.setImageResource(R.drawable.unchecked_item);
                } else {
                        items.get(position).setChecked(1);
                        holder.imageCheck.setImageResource(R.drawable.checkes);
                }
                notifyDataSetChanged();
                ClickChecked(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        ImageView imageCheck;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_view);
            textName = itemView.findViewById(R.id.name_of_product);
            imageCheck = itemView.findViewById(R.id.checkbox_item);
        }
    }

    public void updateList(List<ItemsNewProduct> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public abstract void ClickChecked(ItemsNewProduct itemsNewProduct);

}