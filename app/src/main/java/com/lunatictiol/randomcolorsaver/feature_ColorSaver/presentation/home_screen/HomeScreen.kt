package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen

import android.annotation.SuppressLint
import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import com.lunatictiol.randomcolorsaver.R
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen.components.ColorItem
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen.components.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(syncNumber = viewModel.state.value.syncCounter.toString()) {

                viewModel.onEvent(HomeScreenEvents.SyncColor)
            }
        },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier
                .width(123.dp)
                .height(35.dp),
                shape = RoundedCornerShape(size = 20.dp),
                containerColor = Color(0xFFB6B9FF)
                , onClick = { viewModel.onEvent(HomeScreenEvents.SaveColor) }) {

               Row( modifier = Modifier.fillMaxSize(),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(
                       text = "Add Color",
                       fontSize = 18.sp,
                       color = Color(0xFF5659A4))

                   Icon(
                       painter = painterResource(id = R.drawable.plus_round_icon_1),
                       contentDescription = "add color",


                   )
               }




            }
        }
    ) { paddingValues ->

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()

                .padding(top = paddingValues.calculateTopPadding(), start = 10.dp, end = 10.dp),
            columns = GridCells.Fixed(2),

            )
        {
            items(
                state.colorList
            ) { randomColor ->
                Column(modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColorItem(
                        randomColor = randomColor, mod = Modifier .background(
                            color = Color(randomColor.color.toColorInt()),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                            .padding(5.dp)
                            .fillMaxWidth()
                            .height(102.dp)

                    )


                }

            }

        }

    }

}
