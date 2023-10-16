package tn.esprit.gamer.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.gamer.databinding.SingleItemBookmarksBinding
import tn.esprit.gamer.model.Product

class BookmarksAdapter(val products: MutableList<Product>) : RecyclerView.Adapter<BookmarksAdapter.BookmarksHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksHolder {
        val binding = SingleItemBookmarksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarksHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarksHolder, position: Int) {
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

    inner class BookmarksHolder(val binding: SingleItemBookmarksBinding) : RecyclerView.ViewHolder(binding.root)
}