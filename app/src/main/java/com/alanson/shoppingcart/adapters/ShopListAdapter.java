package com.alanson.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.alanson.shoppingcart.databinding.ShopItemBinding;
import com.alanson.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.alanson.shoppingcart.models.Product.itemCallback;

public class ShopListAdapter extends ListAdapter<Product, ShopListAdapter.ShopViewHolder> {
    private ShopInterface shopInterface;
    private List<Product> fullList;

    public ShopListAdapter(ShopInterface shopInterface) {
        super(itemCallback);
        this.shopInterface = shopInterface;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopItemBinding shopItemBinding = ShopItemBinding.inflate(layoutInflater, parent, false);
        shopItemBinding.setShopInterface(shopInterface);
        return new ShopViewHolder(shopItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Product product = getItem(position);
        holder.shopItemBinding.setProduct(product);
        holder.shopItemBinding.executePendingBindings();
    }
    AsyncListDiffer<Product> differ = new AsyncListDiffer<Product>(this, itemCallback);

    /*public void submitList(List<Product> products){
        differ.submitList(products);
        fullList = new ArrayList<>(products);
    }*/

    /*   @Override
    public Filter getFilter() {
        return filter;
    }*/

    /*private Filter filter = new Filter() {
        //run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<Product> productList = new ArrayList<>();
            if (charSequence.toString().isEmpty()){
                productList.addAll(fullList);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for (Product product : fullList){
                    if (product.getName().toLowerCase().contains(filterPattern)){
                        productList.add(product);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = productList;
            return results;
        }

        //run on ui thread
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            differ.getCurrentList().clear();
            differ.getCurrentList().addAll((Collection<? extends Product>) filterResults.values);
            differ.submitList((List<Product>) filterResults.values);
            notifyDataSetChanged();
        }
    };*/

    public class ShopViewHolder extends RecyclerView.ViewHolder {
        ShopItemBinding shopItemBinding;
        public ShopViewHolder(ShopItemBinding binding) {
            super(binding.getRoot());
            this.shopItemBinding = binding;
        }
    }
    public interface ShopInterface{
        void addItem(Product product);
        void onClickItem(Product product);
    }

}
