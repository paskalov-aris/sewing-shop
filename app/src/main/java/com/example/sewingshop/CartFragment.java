package com.example.sewingshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        ArrayList<ProductModel> cartItems = Cart.getCartItems();

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.cartListRecyclerView);
        CartRecyclerViewAdapter adapter = new CartRecyclerViewAdapter(getContext(), cartItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new ItemDecoration(20, true));

        Button cartBuyButton = view.findViewById(R.id.cartBuyButton);
        cartBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), R.string.purchasesDontWork, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}