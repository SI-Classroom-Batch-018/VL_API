package com.syntax_institut.android_vl_api.data.model

import com.squareup.moshi.Json

// Klasse um eine Kategorie abzubilden
data class Category(

    // Wir können Werte umbenennnen indem wir vorher über die Json Annotation den Namen davon angeben
    @Json(name = "strCategory")
    val title: String,
    @Json(name = "strCategoryThumb")
    val image: String,

)
