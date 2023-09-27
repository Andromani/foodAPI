package com.mealsdatabase.foodapp.composeView

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.mealsdatabase.foodapp.network.FoodWebServices
import com.mealsdatabase.foodapp.repository.FoodRepository
import com.mealsdatabase.foodapp.repository.MainViewModelFactory
import com.mealsdatabase.foodapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel = ViewModelProvider(
            this@MainActivity,
            MainViewModelFactory(
                application, FoodRepository(FoodWebServices())
            )
        )[MainViewModel::class.java]
        setContent {
            HomeScreen(mainViewModel)
        }
    }
}