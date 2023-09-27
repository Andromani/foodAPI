package com.mealsdatabase.foodapp.repository

import com.mealsdatabase.foodapp.data.AllCategories
import com.mealsdatabase.foodapp.network.FoodWebServices
import retrofit2.Response

class FoodRepository(private val foodWebServices: FoodWebServices) {

    suspend fun getAllMealCategories(): Response<AllCategories> {
        return foodWebServices.getAllMealCategories()
    }
}
