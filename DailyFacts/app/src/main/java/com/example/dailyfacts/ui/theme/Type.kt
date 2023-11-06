package com.example.dailyfacts.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dailyfacts.R


val Anton = FontFamily(
    Font(R.font.anton_regular, FontWeight.Normal)
)

val RobotoCondensed = FontFamily(
    Font(R.font.robotocondensed_regular, FontWeight.Normal),
    Font(R.font.robotocondensed_bold, FontWeight.Bold),
    Font(R.font.robotocondensed_italic, FontWeight.Thin),
)


val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Anton,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Anton,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = RobotoCondensed,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    )
)