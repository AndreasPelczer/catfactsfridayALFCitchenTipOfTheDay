package com.example.catfactsfriday.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.catfactsfriday.R
import com.example.catfactsfriday.adapter.ItemAdapter
import com.example.catfactsfriday.databinding.FragmentItemBinding

class ItemFragment : Fragment() {

    private val viewModel: ItemViewModel by viewModels()
    private lateinit var binding: FragmentItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadData()
        binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the ImageView in the fragment layout
        val imageView: ImageView = view.findViewById(R.id.imageView)

        // Set the image resource to the ImageView
        imageView.setImageResource(R.drawable.ede9aab6043917b249a4aec7abc0ea5e)



        binding.btnRefresh.setOnClickListener {
            viewModel.loadData()
        }
        binding.itemRv.setHasFixedSize(true)

        viewModel.items.observe(viewLifecycleOwner) {
            binding.itemRv.adapter = ItemAdapter(it, viewModel)
            binding.itemRv.layoutManager = LinearLayoutManager(context)
        }
    }
}
