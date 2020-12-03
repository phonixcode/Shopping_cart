package com.alanson.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.alanson.shoppingcart.R;
import com.alanson.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){
        if (mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Fun Nike", R.drawable.product_item1, 290, true));
        productList.add(new Product(UUID.randomUUID().toString(), "R Nike", R.drawable.product_item1, 700, true));
        productList.add(new Product(UUID.randomUUID().toString(), "A Nike", R.drawable.product_item1, 250, true));
        productList.add(new Product(UUID.randomUUID().toString(), "Uma Nike", R.drawable.product_item1, 2690, true));
        productList.add(new Product(UUID.randomUUID().toString(), "O Nike", R.drawable.product_item1, 2999, true));
        productList.add(new Product(UUID.randomUUID().toString(), "F Nike", R.drawable.product_item1, 256, true));
        productList.add(new Product(UUID.randomUUID().toString(), "N Nike", R.drawable.product_item1, 297, false));
        productList.add(new Product(UUID.randomUUID().toString(), "L Puma", R.drawable.product_item1, 1000, true));
        productList.add(new Product(UUID.randomUUID().toString(), "D Puma", R.drawable.product_item1, 600, false));
        mutableProductList.setValue(productList);
    }
}
