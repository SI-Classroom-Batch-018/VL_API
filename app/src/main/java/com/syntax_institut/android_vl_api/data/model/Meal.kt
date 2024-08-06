package com.syntax_institut.android_vl_api.data.model

import com.squareup.moshi.Json

data class Meal(
    val strMeal: String,
    val strCategory: String = "",
    val strArea: String = "",

    @Json(name = "strMealThumb")
    val image: String
)