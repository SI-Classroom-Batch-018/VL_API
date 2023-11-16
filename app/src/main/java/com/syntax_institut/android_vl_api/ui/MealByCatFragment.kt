package com.syntax_institut.android_vl_api.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.syntax_institut.android_vl_api.adapter.MealByCategoryAdapter
import com.syntax_institut.android_vl_api.databinding.FragmentMealByCategoryBinding

class MealByCatFragment: Fragment() {

    private lateinit var binding: FragmentMealByCategoryBinding
    private val viewModel: RandomMealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealByCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer um die LiveData zu besorgen
        viewModel.mealsByCategory.observe(viewLifecycleOwner) {
            binding.rvMealsByCat.adapter = MealByCategoryAdapter(it)
        }

    }

}