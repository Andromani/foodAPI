package com.mealsdatabase.foodapp.composeView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mealsdatabase.foodapp.R
import com.mealsdatabase.foodapp.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        TopAppBar(title = {
            MyTextView(stringResource(R.string.app_name), 24.sp)
        })
        LazyColumn {
            items(mainViewModel.foodCategories.value) {
                Column {
                    AsyncImage(
                        model = it.strCategoryThumb,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(140.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun MyTextView(myText: String, fontSize: TextUnit, textColor: Color = Color.Blue) {
    Text(
        myText, style = TextStyle(
            color = textColor, fontSize = fontSize, fontFamily = FontFamily.Monospace
        )
    )
}