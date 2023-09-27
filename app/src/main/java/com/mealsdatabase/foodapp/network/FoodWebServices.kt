package com.mealsdatabase.foodapp.network

import com.mealsdatabase.foodapp.data.AllCategories
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FoodWebServices {
    private val baseURL = "https://www.themealdb.com/api/json/v1/1/"

    private val foodApiInstance: FoodApi by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodApi::class.java)
    }

    suspend fun getAllMealCategories(): Response<AllCategories> {
        return foodApiInstance.getAllMealCategories()
    }
}

