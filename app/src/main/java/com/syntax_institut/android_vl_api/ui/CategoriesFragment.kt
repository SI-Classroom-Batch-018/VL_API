package com.syntax_institut.android_vl_api.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.android_vl_api.adapter.CategoryAdapter
import com.syntax_institut.android_vl_api.databinding.FragmentCategoriesBinding

class CategoriesFragment: Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val viewModel: RandomMealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        viewModel.loadCategories()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Oberserver auf die Category-Live-Data-Liste
        // Wenn etwas in Liste: Adapter wird erstellt
        viewModel.categories.observe(viewLifecycleOwner) {
            binding.rvCategories.adapter = CategoryAdapter(it, viewModel)
        }

        binding.btNew.setOnClickListener {
            viewModel.addNewCategory()
        }

    }

}