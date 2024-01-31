package com.example.altzagreb.data

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.altzagreb.R
import com.example.altzagreb.model.NavigationIcon
import com.example.altzagreb.ui.AltZagrebScreens

object NavigationIconsDataProvider {
    @Composable
    fun getNavigationIconsData() : List<NavigationIcon> {
        return listOf(
            NavigationIcon(
                drawableResource = R.drawable.local_dining,
                stringResource = R.string.dining,
                navigation = AltZagrebScreens.Dining,
                color = MaterialTheme.colorScheme.tertiary
            ),
            NavigationIcon(
                drawableResource = R.drawable.museum,
                stringResource = R.string.museums,
                navigation = AltZagrebScreens.Museums,
                color = MaterialTheme.colorScheme.primary
            ),
            NavigationIcon(
                drawableResource = R.drawable.local_cafe,
                stringResource = R.string.coffee,
                navigation = AltZagrebScreens.Coffee,
                color = MaterialTheme.colorScheme.secondary
            ),
            NavigationIcon(
                drawableResource = R.drawable.nightlife,
                stringResource = R.string.nightlife,
                navigation = AltZagrebScreens.Nightlife,
                color = MaterialTheme.colorScheme.secondaryContainer
            )
        )
    }
}