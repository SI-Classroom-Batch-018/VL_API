package com.syntax_institut.android_vl_api.data.model

import com.squareup.moshi.Json

// Klasse um die Liste von Meals zu halten
data class MealResult(

    @Json(name = "meals")
    val mealList: List<Meal>
)
