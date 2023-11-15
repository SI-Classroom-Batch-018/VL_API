package com.syntax_institut.android_vl_api.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.android_vl_api.data.model.CategoryResult
import com.syntax_institut.android_vl_api.data.model.MealResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Die Base-URL wird angelegt
const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

// Moshi Client wird im Builder Pattern geschrieben
// Wir fügen eine KotlinJsonFactory hinzu, die später die Übersetzung von Json in Kotlin für uns übernimmt
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit Client wird im Builder Pattern geschrieben
// Wir fügen Moshi hinzu
// und setzen die Base-Url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

// Das Interface beschreibt alle Funktionen, die die API später haben soll
interface MealApiService {

    // Der Endpunkt wird angegeben
    @GET("random.php")
    // Es wird eine Funktion angelegt, die einen Namen hat und zeigt, was später zurückgegeben wird
    suspend fun getRandomMeal(): MealResult

    // Neuer Endpunkt für die Api, dieser lädt alle Categories
    @GET("categories.php")
    suspend fun getCategories(): CategoryResult

}

// Das Objekt vereint alle Dinge, die wir oben geschrieben haben in einen Api-Service
object MealApi {
    val retrofitService: MealApiService by lazy { retrofit.create(MealApiService::class.java) }
}

