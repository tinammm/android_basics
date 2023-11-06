package com.example.dailyfacts.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FunFact(
    val dayOfMonth: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val shortDescription: Int,
    @StringRes val fact: Int
)
