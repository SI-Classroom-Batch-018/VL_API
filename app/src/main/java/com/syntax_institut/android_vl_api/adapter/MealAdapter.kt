package com.syntax_institut.android_vl_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.syntax_institut.android_vl_api.data.model.Meal
import com.syntax_institut.android_vl_api.databinding.ItemCategoryBinding

class MealAdapter(
    private val mealList: List<Meal>
): RecyclerView.Adapter<MealAdapter.MealItemViewHolder>() {

    inner class MealItemViewHolder(val vb: ItemCategoryBinding): RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealItemViewHolder {
        val viewBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealItemViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealItemViewHolder, position: Int) {
        val meal = mealList[position]

        holder.vb.tvCategoryText.text = meal.strMeal
        holder.vb.ivCategoryImage.load(meal.image)
    }
}