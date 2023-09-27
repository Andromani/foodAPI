package com.mealsdatabase.foodapp.data

import kotlinx.serialization.SerialName


data class AllCategories(
    @SerialName("categories")
    val categories: List<Category>
)