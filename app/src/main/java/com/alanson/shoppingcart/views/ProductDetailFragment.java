package com.alanson.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alanson.shoppingcart.R;
import com.alanson.shoppingcart.databinding.FragmentProductDetailBinding;
import com.alanson.shoppingcart.models.Product;
import com.alanson.shoppingcart.viewmodels.ShopViewModel;

import java.util.List;

public class ProductDetailFragment extends Fragment {
    FragmentProductDetailBinding fragmentProductDetailBinding;
    private ShopViewModel shopViewModel;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentProductDetailBinding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return fragmentProductDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        fragmentProductDetailBinding.setShopViewModel(shopViewModel);
    }
}