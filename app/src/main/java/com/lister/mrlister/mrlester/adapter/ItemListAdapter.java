package com.lister.mrlister.mrlester.adapter;

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
import com.lister.mrlister.mrlester.data.Items;

import java.util.ArrayList;
import java.util.List;


public abstract class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<Items>items = new ArrayList<>();
    private Context context;

    public ItemListAdapter(Context context, List<Items>items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_list_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, final int position) {

        holder.tvTitle.setText(items.get(position).getTitle());

        switch (items.get(position).getColor()) {
            case 1:
                holder.cardView.setBackgroundResource(R.drawable.gradient_one);
                break;
            case 2:
                holder.cardView.setBackgroundResource(R.drawable.gradient_two);
                break;
            case 3:
                holder.cardView.setBackgroundResource(R.drawable.gradient_three);
                break;
            case 4:
                holder.cardView.setBackgroundResource(R.drawable.gradient_four);
                break;
            case 5:
                holder.cardView.setBackgroundResource(R.drawable.gradient_five);
                break;
            case 6:
                holder.cardView.setBackgroundResource(R.drawable.gradient_six);
                break;
            case 7:
                holder.cardView.setBackgroundResource(R.drawable.gradient_seven);
                break;
            case 8:
                holder.cardView.setBackgroundResource(R.drawable.gradient_eight);
                break;
            case 9:
                holder.cardView.setBackgroundResource(R.drawable.gradient_nine);
                break;

            default:
                holder.cardView.setBackgroundResource(R.drawable.gradient_nine);
        }

        switch (items.get(position).getIcon()) {
            case 1:
                holder.imageView.setImageResource(R.drawable.icon_fruit);
                break;

            case 2:
                holder.imageView.setImageResource(R.drawable.icon_instrument);
                break;

            case 3:
                holder.imageView.setImageResource(R.drawable.icon_clouses);
                break;

            case 4:
                holder.imageView.setImageResource(R.drawable.icon_medicine);
                break;

            case 5:
                holder.imageView.setImageResource(R.drawable.icon_gift);
                break;

            case 6:
                holder.imageView.setImageResource(R.drawable.icon_coctail);
                break;

            case 7:
                holder.imageView.setImageResource(R.drawable.icon_beauty);
                break;

            case 8:
                holder.imageView.setImageResource(R.drawable.icon_plain);
                break;

            case 9:
                holder.imageView.setImageResource(R.drawable.icon_car);
                break;

            case 10:
                holder.imageView.setImageResource(R.drawable.icon_list);
                break;

            case 11:
                holder.imageView.setImageResource(R.drawable.icon_sprey);
                break;

            case 12:
                holder.imageView.setImageResource(R.drawable.icon_cace);
                break;

            case 13:
                holder.imageView.setImageResource(R.drawable.icon_pacifier);
                break;

            case 14:
                holder.imageView.setImageResource(R.drawable.icon_suitcase);
                break;

            case 15:
                holder.imageView.setImageResource(R.drawable.icon_light);
                break;

            case 16:
                holder.imageView.setImageResource(R.drawable.icon_sports);
                break;

            case 17:
                holder.imageView.setImageResource(R.drawable.icon_pizza);
                break;

            case 18:
                holder.imageView.setImageResource(R.drawable.icon_cancelar);
                break;

            case 19:
                holder.imageView.setImageResource(R.drawable.icon_home);
                break;

            case 20:
                holder.imageView.setImageResource(R.drawable.icon_print);
                break;

                default:
                holder.imageView.setImageResource(R.drawable.icon_fruit);
        }

        holder.imageView_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClicMenu(items.get(position));
            }
        });


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickLister(items.get(position));
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

        public TextView tvTitle;
        public ImageView imageView;
        public ImageView imageView_menu;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.title_item_main);
            imageView = itemView.findViewById(R.id.category_image);
            imageView_menu = itemView.findViewById(R.id.menu_item);
            cardView = itemView.findViewById(R.id.card_view_item);

        }
    }

    public abstract void OnClickLister(Items items);
    public abstract void OnClicMenu(Items items);

}