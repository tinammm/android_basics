package com.example.altzagreb.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.altzagreb.ui.AltZagrebScreens

data class NavigationIcon(
    /** Material Icon used as navigation icon **/
    @DrawableRes val drawableResource: Int,
    /** Text displayed for navigation icon **/
    @StringRes val stringResource: Int,
    /** Navigation element **/
    val navigation: AltZagrebScreens,
    /** Color used as card background **/
    val color: Color
)
