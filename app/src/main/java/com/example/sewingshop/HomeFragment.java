package com.example.sewingshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<ProductModel> products = new ArrayList<>();

    int[] productImages = {R.drawable.hoodie, R.drawable.jeans_oversize, R.drawable.jacket};

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.productListRecyclerView);
        setUpProducts();
        ProductRecyclerViewAdapter adapter = new ProductRecyclerViewAdapter(getContext(), products);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addItemDecoration(new ItemDecoration(1, false));

        return view;
    }

    private void setUpProducts() {
        String[] productNames = getResources().getStringArray(R.array.product_names);
        String[] productDescriptions = getResources().getStringArray(R.array.product_descriptions);
        int[] productCodes = getResources().getIntArray(R.array.product_codes);
        String[] productPrices = getResources().getStringArray(R.array.product_prices);

        for (int i = 0; i < productNames.length; i++) {
            products.add(
                    new ProductModel(
                            productNames[i],
                            productCodes[i],
                            productDescriptions[i],
                            productPrices[i],
                            productImages[i]
                    )
            );
        }
    }
}