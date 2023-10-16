package tn.esprit.gamer.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.gamer.databinding.SingleItemStoreBinding
import tn.esprit.gamer.model.Product

class StoreAdapter(val products: MutableList<Product>) : RecyclerView.Adapter<StoreAdapter.StoreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val binding = SingleItemStoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoreHolder(binding)
    }

    override fun onBindViewHolder(holder: StoreHolder, position: Int) {
        with(holder){
            with(products[position]){
                binding.itemImage.setImageResource(imageRes)
                binding.itemTitle.text = title
                binding.itemType.text = type
                binding.itemPrice.text = "$price $"
                binding.btnAddToCart.setOnClickListener {

                }

            }
        }
    }

    override fun getItemCount() = products.size

    inner class StoreHolder(val binding: SingleItemStoreBinding) : RecyclerView.ViewHolder(binding.root)
}