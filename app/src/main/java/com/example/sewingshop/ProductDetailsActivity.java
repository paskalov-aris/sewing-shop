package com.example.sewingshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailsActivity extends AppCompatActivity {
    private static final String PRODUCT_PARAM = "product";

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
        ProductModel product = (ProductModel) intent.getSerializableExtra(PRODUCT_PARAM);

        if (product != null) {
            this.setUpProductDetailsLayout(product);
        }
    }

    protected void setUpProductDetailsLayout(ProductModel product) {
        ImageView image;
        TextView name, description, code, price;
        Button addToCartButton, viewCartButton;

        image = findViewById(R.id.productDetailsImage);

        name = findViewById(R.id.productDetailsName);
        description = findViewById(R.id.productDetailsDescription);
        code = findViewById(R.id.productDetailsCode);
        price = findViewById(R.id.productDetailsPrice);
        addToCartButton = findViewById(R.id.addToCartButton);
        viewCartButton = findViewById(R.id.viewCartButton);

        image.setImageResource(product.getImage());
        name.setText(product.getName());
        description.setText(product.getDescription());
        code.setText(getString(R.string.articleNumber, product.getCode().toString()));
        price.setText(getString(R.string.cost, product.getPrice()));

        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("changeFragmentToCart", true);  // Signal to change fragment
                setResult(RESULT_OK, resultIntent);  // Send back the result
                finish();
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAlreadyInCart =  Cart.isProductInCart(product.getName());

                Context context = ProductDetailsActivity.this;

                if (!isAlreadyInCart) {
                    Cart.addToCart(product);
                    Toast.makeText(context, R.string.itemIsAddedToCart, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, R.string.itemIsAlreadyInCart, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}