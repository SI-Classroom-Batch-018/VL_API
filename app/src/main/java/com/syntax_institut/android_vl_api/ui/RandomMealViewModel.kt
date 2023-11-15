package com.syntax_institut.android_vl_api.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.android_vl_api.data.Repository
import com.syntax_institut.android_vl_api.data.remote.MealApi
import kotlinx.coroutines.launch

class RandomMealViewModel: ViewModel() {

    // Repository wird mit Hilfe des MealApi Objektes erstellt
    private val repository = Repository(MealApi)

    // Referenz auf die LiveData aus dem Repository
    val randomMeal = repository.randomMeal

    // Referenz auf die LiveData aus dem Repository
    val categories = repository.categories

    // Init funktion um direkt beim Starten der App Daten zu laden
    init {
        loadRandomMeal()
    }

    // Funktion die Laden der Daten im Repository in einer Coroutine startet
    fun loadRandomMeal() {
        viewModelScope.launch {
            repository.getRandomMeal()
        }
    }

    // Funktion um Categories in Coroutine zu laden
    fun loadCategories() {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}