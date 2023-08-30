package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);

        // Bind product data to views
        holder.textProductName.setText(product.getName());
        holder.textProductDescription.setText(product.getDescription());
        holder.textProductPrice.setText(String.format("$%.2f", product.getPrice()));
        holder.imageProduct.setImageResource(product.getImageResourceId());

        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart(product);

                // Load the custom animation
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.custom_button_animation);
                holder.btnAddToCart.startAnimation(animation);

                // Change button color
                holder.btnAddToCart.setBackgroundResource(R.color.green); // Change to your desired color resource
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView textProductDescription;
        TextView textProductPrice;
        TextView textProductName;
        Button btnAddToCart;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.imageProduct);
            textProductDescription = itemView.findViewById(R.id.textProductDescription);
            textProductPrice = itemView.findViewById(R.id.textProductPrice);
            textProductName = itemView.findViewById(R.id.textProductName);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }

    private void addToCart(Product product) {
        if (context instanceof ProductsActivity) {
            ((ProductsActivity) context).addToCart(product);
        }
    }
}
