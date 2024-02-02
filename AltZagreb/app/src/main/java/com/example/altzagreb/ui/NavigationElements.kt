package com.example.altzagreb.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.snap
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.altzagreb.data.NavigationIconsDataProvider.getNavigationIconsData
import com.example.altzagreb.ui.theme.AltZagrebTheme


@Composable
fun AltZagrebNavigation(
    modifier: Modifier = Modifier,
    onClick : (AltZagrebScreens) -> Unit = {},
    currentDestination : NavDestination?,
    showBottomBar: Boolean = false
){
    AnimatedVisibility(
        visible = showBottomBar,
        enter = fadeIn(
            animationSpec = snap()
        ),
        exit = fadeOut(
            animationSpec = snap()
        )
    ) {

        AltZagrebBottomNavigationBar(
            modifier = modifier,
            onClick = onClick,
            currentDestination = currentDestination
        )

    }
}


@Composable
fun AltZagrebBottomNavigationBar(
    modifier: Modifier = Modifier,
    onClick : (AltZagrebScreens) -> Unit = {},
    currentDestination : NavDestination?
){
    val navItems = getNavigationIconsData()
    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        for (navItem in navItems) {
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == navItem.navigation.name } == true,
                onClick = { onClick(navItem.navigation) },
                icon = {
                    Icon(
                        painter = painterResource(
                            navItem.drawableResource
                        ),
                        contentDescription = stringResource(
                            navItem.stringResource
                        )
                    )
                }
            )
        }
    }
}



@Preview
@Composable
fun AltZagrebBottomNavigationBarPreview(){
    AltZagrebTheme {
        AltZagrebBottomNavigationBar(
            currentDestination = NavDestination(AltZagrebScreens.HomePage.name)
        )
    }
}