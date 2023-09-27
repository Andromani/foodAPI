package com.mealsdatabase.foodapp.viewmodel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mealsdatabase.foodapp.data.AllCategories
import com.mealsdatabase.foodapp.data.Category
import com.mealsdatabase.foodapp.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application, private val foodRepository: FoodRepository) :
    AndroidViewModel(application) {
    val foodCategories: MutableState<List<Category>> = mutableStateOf(emptyList())

    private suspend fun getAllMealCategories(): Response<AllCategories> {
        return foodRepository.getAllMealCategories()
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val allMealCategories = getAllMealCategories()
            println("allMealCategories---> ==> 1")
            if (allMealCategories.isSuccessful) {
                allMealCategories.body()?.let {
                    foodCategories.value = it.categories
                }
            }
        }
    }
}