package com.example.altzagreb.ui

import com.example.altzagreb.data.AltRestaurantDataProvider.getAltRestaurants
import com.example.altzagreb.model.AltInstitution

data class AltZagrebUiState(
    val currentScreen: AltZagrebScreens = AltZagrebScreens.Dining,
    val currentAltListItem: AltInstitution = getAltRestaurants()[0]
)
