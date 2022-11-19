package com.yakubjonov.nurserymanagement.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yakubjonov.nurserymanagement.core.Constants
import com.yakubjonov.nurserymanagement.databinding.FragmentDetailBinding
import com.yakubjonov.nurserymanagement.presentation.adapter.RecipeAdapter

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val childCount = it.getInt(Constants.CHILD_COUNT_KEY)
            adapter = RecipeAdapter(childCount)
        }
    }

    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
    }
}