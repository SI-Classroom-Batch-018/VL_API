package com.syntax_institut.android_vl_api.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.syntax_institut.android_vl_api.databinding.FragmentRandomMealBinding

class RandomMealFragment: Fragment() {

    private lateinit var binding: FragmentRandomMealBinding
    private val viewModel: RandomMealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomMealBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Oberver um LiveData zu beobachten
        viewModel.randomMeal.observe(viewLifecycleOwner) {
            binding.tvMealTitle.text = it.strMeal
            binding.tvCountry.text = it.strArea
            binding.tvCategory.text = it.strCategory
        }

        // Button um nächstes Meal zu laden
        binding.btNext.setOnClickListener {
            viewModel.loadRandomMeal()
        }

    }

}