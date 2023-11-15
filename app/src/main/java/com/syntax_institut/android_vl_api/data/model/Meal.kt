package com.syntax_institut.android_vl_api.data.model

import com.squareup.moshi.Json

// Klasse um ein Meal abzubilden
data class Meal (
    val idMeal: Int,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,

    @Json(name = "strMealThumb")
    val image: String
)