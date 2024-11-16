package com.example.sewingshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.CartViewHolder > {
    Context context;
    ArrayList<ProductModel> products;

    public CartRecyclerViewAdapter(Context context, ArrayList<ProductModel> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public CartRecyclerViewAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_list_row, parent, false);
        return new CartRecyclerViewAdapter.CartViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerViewAdapter.CartViewHolder holder, int position) {
        final ProductModel product = products.get(position);

        holder.name.setText(product.getName());
        holder.description.setText(product.getDescription());
        holder.price.setText(context.getString(R.string.cost, product.getPrice()));
        holder.image.setImageResource(product.getImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;
        ImageView image;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.cartProductName);
            description = itemView.findViewById(R.id.cartProductDescription);
            price = itemView.findViewById(R.id.cartProductPrice);
            image = itemView.findViewById(R.id.cartProductImage);
        }
    }
}
