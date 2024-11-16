package com.example.sewingshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        ProductModel product = (ProductModel) intent.getSerializableExtra("product");

        if (product != null) {
            this.setUpProductDetailsLayout(product);
        }
    }

    protected void setUpProductDetailsLayout(ProductModel product) {
        ImageView image;
        TextView name, description, code;
        Button button;

        image = findViewById(R.id.productDetailsImage);

        name = findViewById(R.id.productDetailsName);
        description = findViewById(R.id.productDetailsDescription);
        code = findViewById(R.id.productDetailsCode);

        button = findViewById(R.id.productDetailsButton);

        image.setImageResource(product.getImage());
        name.setText(product.getName());
        description.setText(product.getDescription());
        code.setText("Артикул: "+product.getCode());
        button.setText("Придбати за "+product.getPrice());
    }
}