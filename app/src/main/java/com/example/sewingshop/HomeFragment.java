package com.example.sewingshop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<ProductModel> products = new ArrayList<>();

    int[] productImages = {R.drawable.hoodie, R.drawable.jeans_oversize, R.drawable.jacket};

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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
        recyclerView.addItemDecoration(new ItemDecoration(1));

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