package com.syntax_institut.android_vl_api.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_vl_api.data.model.Meal
import com.syntax_institut.android_vl_api.data.remote.MealApi

class Repository(private val apiService: MealApi) {

    // Live-Data um ein zufälliges Meal zu halten
    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    // Suspend Funktion um die Funktion des Api Services auszuführen
    suspend fun getRandomMeal() {
        val result = apiService.retrofitService.getRandomMeal()
        // sobald Ergebnis da ist wird es in die LiveData geschrieben
        _randomMeal.postValue(result.meals.first())
    }

}