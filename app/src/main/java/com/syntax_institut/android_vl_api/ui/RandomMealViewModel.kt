package com.syntax_institut.android_vl_api.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.android_vl_api.data.Repository
import com.syntax_institut.android_vl_api.data.model.Category
import com.syntax_institut.android_vl_api.data.remote.MealApi
import kotlinx.coroutines.launch

class RandomMealViewModel: ViewModel() {

    // Repository wird mit Hilfe des MealApi Objektes erstellt
    private val repository = Repository(MealApi)

    // Referenz auf die LiveData aus dem Repository
    val randomMeal = repository.randomMeal

    // Referenz auf die LiveData aus dem Repository
    val categories = repository.categories

    val mealsByCategory = repository.mealsByCat

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

    // Funktion um Meals nach bestimmter Kategorie zu laden
    // Die Funktion bekommt einen Paramter (Die gesuchte Kategorie) übergeben und gibt diese an die Repository Funktion weiter
    fun loadMealsByCategory(category: String) {
        viewModelScope.launch {
            repository.getMealsByCat(category)
        }
    }

    // Test Funktion um neue Kategorie hinzuzufügen
    fun addNewCategory() {
        val cat = Category("Test", "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/uvuyxu1503067369.jpg")
        repository.addNewCategory(cat)
    }

}