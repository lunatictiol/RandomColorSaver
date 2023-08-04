package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lunatictiol.randomcolorsaver.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(syncNumber:String,
    onClick:()->Unit) {
    TopAppBar(
        colors =TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF5659A4)
        ) ,
        title = { Text( text = "Color App",
        color = Color(0xFFFFFFFF) )},
        actions = { TopAppBarActionButton( syncNumber = syncNumber, description = "Action Button") {
            onClick()
        }
        })
}
@Composable
fun TopAppBarActionButton(
    syncNumber:String,
    description: String,
    onClick: () -> Unit
) {
    IconButton(
        modifier = Modifier
            .width(71.dp)
            .height(35.dp),
        onClick = {
        onClick()
    }) {

            Row(modifier= Modifier

                .background(color = Color(0xFFB6B9FF), shape = RoundedCornerShape(size = 20.dp))
                .fillMaxWidth()
                .padding(2.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {Text(
                text = syncNumber,
                fontSize = 20.sp,
                    color = Color(0xFFFFFFFF))
                Icon(painter = painterResource(id = R.drawable.sync), contentDescription = description)
            }



    }
}