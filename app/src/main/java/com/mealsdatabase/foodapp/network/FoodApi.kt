package com.mealsdatabase.foodapp.network

import com.mealsdatabase.foodapp.data.AllCategories
import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {
    @GET("categories.php")
    suspend fun getAllMealCategories(): Response<AllCategories>
}