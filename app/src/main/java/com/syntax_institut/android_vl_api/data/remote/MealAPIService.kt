package com.syntax_institut.android_vl_api.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.syntax_institut.android_vl_api.data.model.CategoryResponse
import com.syntax_institut.android_vl_api.data.model.MealResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val logger = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface MealAPIService {

    @GET("random.php") // -> https://www.themealdb.com/api/json/v1/1/random.php
    suspend fun randomMeal() : MealResponse

    @GET("filter.php") // -> c = TestCat -> https://www.themealdb.com/api/json/v1/1/filter.php?c=TestCat
    suspend fun filterCategory(@Query("c") category: String) : MealResponse

    @GET("categories.php") // -> https://www.themealdb.com/api/json/v1/1/categories.php
    suspend fun categories() : CategoryResponse
}

object MealAPI {
    val retrofitService: MealAPIService by lazy { retrofit.create(MealAPIService::class.java) }
}