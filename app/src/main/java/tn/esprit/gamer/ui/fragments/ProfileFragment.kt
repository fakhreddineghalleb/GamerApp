package tn.esprit.gamer.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import tn.esprit.gamer.databinding.FragmentProfileBinding
import tn.esprit.gamer.ui.adapters.BookmarksAdapter
import tn.esprit.gamer.utils.MyStatics

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.rvBookmarks.adapter = BookmarksAdapter(MyStatics.getListProducts(requireContext()))
        binding.rvBookmarks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        return binding.root
    }

}