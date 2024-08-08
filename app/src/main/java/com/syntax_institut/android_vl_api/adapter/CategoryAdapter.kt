package com.syntax_institut.android_vl_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.android_vl_api.R
import com.syntax_institut.android_vl_api.data.model.Category
import com.syntax_institut.android_vl_api.databinding.ItemCategoryBinding
import com.syntax_institut.android_vl_api.ui.RandomMealViewModel

class CategoryAdapter(
    private val dataset: List<Category>,
    private val viewModel: RandomMealViewModel
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.tvCategoryText.text = item.strCategory
        holder.binding.ivCategoryImage.load(item.image)

        holder.binding.root.setOnClickListener {
            viewModel.filterMealsByCategory(item.strCategory)
            holder.itemView.findNavController().navigate(R.id.mealsByCategoryFragment)
        }
    }
}