package tn.esprit.gamer.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import tn.esprit.gamer.databinding.FragmentNewsBinding
import tn.esprit.gamer.ui.adapters.NewsAdapter
import tn.esprit.gamer.utils.MyStatics

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater)

        binding.rvNews.adapter = NewsAdapter(MyStatics.getListNews(requireContext()))
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

}