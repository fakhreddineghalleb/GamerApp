package tn.esprit.gamer.ui.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.R
import tn.esprit.gamer.databinding.SingleItemNewsBinding
import tn.esprit.gamer.model.News

class NewsAdapter(val newsList: MutableList<News>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = SingleItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        with(holder){
            with(newsList[position]){
                binding.newsTitle.text = title
                binding.newsDescription.text = description
                binding.newsImage.setImageResource(imageRes)
                binding.actionShowMore.setOnClickListener {
                    Snackbar.make((itemView.context as Activity).findViewById(R.id.context_view), itemView.context.getString(R.string.msg_coming_soon), Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount() = newsList.size

    inner class NewsHolder(val binding: SingleItemNewsBinding) : RecyclerView.ViewHolder(binding.root)
}