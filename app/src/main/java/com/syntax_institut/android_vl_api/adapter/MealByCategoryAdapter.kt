package com.syntax_institut.android_vl_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.android_vl_api.databinding.ItemMealBinding

class MealByCategoryAdapter(
    private val dataset: List<Int>
): RecyclerView.Adapter<MealByCategoryAdapter.MealByCatViewHolder>() {

    inner class MealByCatViewHolder(val binding: ItemMealBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealByCatViewHolder {
        val binding = ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealByCatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: MealByCatViewHolder, position: Int) {
        val item = dataset[position]

    }

}