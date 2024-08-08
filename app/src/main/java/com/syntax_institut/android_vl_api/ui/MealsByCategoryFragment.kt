package com.syntax_institut.android_vl_api.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.syntax_institut.android_vl_api.R
import com.syntax_institut.android_vl_api.adapter.MealAdapter
import com.syntax_institut.android_vl_api.databinding.FragmentMealsByCategoryBinding

class MealsByCategoryFragment : Fragment() {

    private lateinit var vb: FragmentMealsByCategoryBinding
    private val viewModel: RandomMealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentMealsByCategoryBinding.inflate(layoutInflater)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.filteredMealsByCategory.observe(viewLifecycleOwner) {
            vb.rvMeals.adapter = MealAdapter(it)
        }
    }
}