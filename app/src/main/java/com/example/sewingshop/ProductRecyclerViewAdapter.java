package com.example.sewingshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder > {
    Context context;
    ArrayList<ProductModel> products;

    public ProductRecyclerViewAdapter(Context context, ArrayList<ProductModel> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductRecyclerViewAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ProductRecyclerViewAdapter.ProductViewHolder(view );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductRecyclerViewAdapter.ProductViewHolder holder, int position) {
        final ProductModel product = products.get(position);

        holder.name.setText(product.getName());
        holder.price.setText(product.getPrice());
        holder.image.setImageResource(product.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked: "+product.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView image;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.productName);
            price = itemView.findViewById(R.id.productPrice);
            image = itemView.findViewById(R.id.productImageView);
        }
    }
}
