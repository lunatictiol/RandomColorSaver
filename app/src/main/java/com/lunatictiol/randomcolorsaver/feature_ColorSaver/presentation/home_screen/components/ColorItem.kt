package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen.components


import android.graphics.fonts.FontFamily
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.lunatictiol.randomcolorsaver.R
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import java.util.Date
import kotlin.time.Duration.Companion.days

@Composable
fun ColorItem(
randomColor: RandomColor,
mod: Modifier
){
    Box(
        modifier = mod



    ) {
        Column(modifier = Modifier
            .fillMaxWidth()

           ) {
            Text(modifier = Modifier
                .offset(x = 6.03862.dp, y = 7.dp)
                .width(90.11243.dp)
                .height(23.dp),
                text = randomColor.color,
                fontSize = 18.sp,
                color = Color(0xFFFFFFFF))
            Spacer(modifier = Modifier.height(10.dp))
            Divider(
                modifier = Modifier
                    .padding(0.dp)
                    .width(90.11243.dp)
                    .height(1.dp)
                    .background(color = Color(0xFFFFFCFC))
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(modifier = Modifier
                .align(End)
                ,
                text = "Created at \n ${convertLongToTime(randomColor.timestamp)}",
                fontSize = 14.sp,


                    color = Color(0xFFFFFEFE),
                    textAlign = TextAlign.Right)




            
        }

    }


}
fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd/MM/yyy")
    return format.format(date)
}








