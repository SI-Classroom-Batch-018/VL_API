package com.syntax_institut.android_vl_api.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.android_vl_api.data.Repository
import com.syntax_institut.android_vl_api.data.remote.MealAPI
import kotlinx.coroutines.launch


class RandomMealViewModel: ViewModel() {

    private val repository = Repository(MealAPI)

    val randomMeal = repository.randomMeal
    val categories = repository.categories

    init {
        loadRandomMeal()
        loadCategories()
    }

    fun loadRandomMeal() {
        viewModelScope.launch {
            repository.randomMeal()
        }
    }

    fun loadCategories() {
        viewModelScope.launch {
            repository.loadCategories()
        }
    }

}