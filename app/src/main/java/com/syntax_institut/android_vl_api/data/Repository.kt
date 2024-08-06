package com.syntax_institut.android_vl_api.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_vl_api.data.model.Category
import com.syntax_institut.android_vl_api.data.model.Meal
import com.syntax_institut.android_vl_api.data.remote.MealAPI

class Repository(private val api: MealAPI) {

    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories

    suspend fun randomMeal() {
        val result = api.retrofitService.randomMeal()
        _randomMeal.postValue(result.meals.first())
    }

    suspend fun loadCategories() {
        val result = api.retrofitService.categories()
        _categories.postValue(result.categories)
    }
}