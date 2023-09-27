package com.mealsdatabase.foodapp.repository

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mealsdatabase.foodapp.viewmodel.MainViewModel

class MainViewModelFactory(val application: Application, val foodRepository: FoodRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, foodRepository) as T
        }
        return super.create(modelClass)
    }
}