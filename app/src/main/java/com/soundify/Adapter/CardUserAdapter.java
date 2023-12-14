package com.soundify.Adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.CardItem;
import com.soundify.R;

import java.util.List;

public class CardUserAdapter extends RecyclerView.Adapter<CardUserAdapter.CardViewHolder> {

    private List<CardItem> cardItemList;

    public CardUserAdapter(List<CardItem> cardItemList) {

        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem cardItem = cardItemList.get(position);

        // Gắn dữ liệu cho card
        holder.name.setText(cardItem.getName());
        holder.price.setText(cardItem.getPrice());
        holder.subscript.setText(cardItem.getSubscript());

        holder.icon1.setImageResource(cardItem.getIcon1());
        holder.subscription1.setText(cardItem.getSubscription1());

        holder.icon2.setImageResource(cardItem.getIcon2());
        holder.subscription2.setText(cardItem.getSubscription2());

        holder.icon3.setImageResource(cardItem.getIcon3());
        holder.subscription3.setText(cardItem.getSubscription3());

        holder.cardView.setCardBackgroundColor(cardItem.getCardBackgroundColor());
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, subscript, subscription1, subscription2, subscription3;
        ImageView icon1, icon2, icon3;
        CardView cardView;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            // Khởi tạo các thành phần trong card
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            subscript = itemView.findViewById(R.id.subscript);
            subscription1 = itemView.findViewById(R.id.subscription1);
            subscription2 = itemView.findViewById(R.id.subscription2);
            subscription3 = itemView.findViewById(R.id.subscription3);
            icon1 = itemView.findViewById(R.id.icon1);
            icon2 = itemView.findViewById(R.id.icon2);
            icon3 = itemView.findViewById(R.id.icon3);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}

