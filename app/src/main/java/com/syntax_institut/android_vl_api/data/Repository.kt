package com.syntax_institut.android_vl_api.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_vl_api.data.model.Category
import com.syntax_institut.android_vl_api.data.model.Meal
import com.syntax_institut.android_vl_api.data.remote.MealApi

class Repository(private val apiService: MealApi) {

    // Live-Data um ein zufälliges Meal zu halten
    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    // Live-Data um die Liste an Categories zu halten
    private var _categories = MutableLiveData<MutableList<Category>>()
    val categories: LiveData<MutableList<Category>>
        get() = _categories

    private var _mealsByCat = MutableLiveData<List<Meal>>()
    val mealsByCat: LiveData<List<Meal>>
        get() = _mealsByCat

    // Suspend Funktion um die Funktion des Api Services auszuführen
    suspend fun getRandomMeal() {
        val result = apiService.retrofitService.getRandomMeal()
        // sobald Ergebnis da ist wird es in die LiveData geschrieben
        _randomMeal.postValue(result.mealList.first())
    }

    // Funktion um die Categories zu laden und in die Live-Data zu schreiben
    suspend fun getCategories() {
        val result = apiService.retrofitService.getCategories()
        _categories.postValue(result.categories.toMutableList())
    }

    // Funktion um Meals nach bestimmter Category zu laden
    // Dafür bekommt die Funktion die gesuchte Kategorie als String gegeben und gibt diese an die API-Funktion weiter
    suspend fun getMealsByCat(category: String) {
        val result = apiService.retrofitService.getMealsByCategory(category)
        _mealsByCat.postValue(result.mealList)
    }

    // Test Funktion um neue Kategorie hinzuzufügen
    fun addNewCategory(category: Category) {
        _categories.value?.add(category)

        // Zwingt die LiveData sich zu updaten, ansonsten funktioniert das hinzufügen genau 1x
        _categories.value = _categories.value
    }

}