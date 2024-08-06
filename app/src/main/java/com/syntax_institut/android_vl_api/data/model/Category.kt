package com.syntax_institut.android_vl_api.data.model

import com.squareup.moshi.Json

data class Category(
    val strCategory: String,

    @Json(name = "strCategoryThumb")
    val image: String
)