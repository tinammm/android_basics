package com.example.altzagreb.ui


import android.content.Context
import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.altzagreb.R
import com.example.altzagreb.data.AltCoffeeDataProvider
import com.example.altzagreb.data.AltMuseumDataProvider
import com.example.altzagreb.data.AltNightlifeDataProvider
import com.example.altzagreb.data.AltRestaurantDataProvider
import com.example.altzagreb.ui.theme.AltZagrebTheme

enum class AltZagrebScreens(@StringRes val title: Int){
    HomePage(title = R.string.app_banner),
    Dining(title = R.string.dining),
    Museums(title = R.string.museums),
    Coffee(title = R.string.coffee),
    Nightlife(title = R.string.nightlife),
    DetailPage(title = R.string.app_banner)
}


@Composable
fun AltZagrebApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: AltZagrebViewModel = viewModel(),
){
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AltZagrebScreens.valueOf(
        backStackEntry?.destination?.route ?: AltZagrebScreens.HomePage.name
    )
    val currentDestination = backStackEntry?.destination


    Scaffold (
        topBar = {
            AnimatedVisibility(
                visible = currentScreen != AltZagrebScreens.DetailPage,
                enter = fadeIn(
                    animationSpec = snap()
                ),
                exit = fadeOut(
                    animationSpec = snap()
                )
            ){
                AltZagrebAppBar(
                    currentScreen
                )
            }
        },
        bottomBar = {
            AltZagrebNavigation(

                onClick = {
                    viewModel.setCurrentScreen(
                        currentScreen
                    )
                    navController.navigate(it.name){
                        launchSingleTop = true
                    }
                },
                currentDestination = currentDestination,
                showBottomBar = currentScreen != AltZagrebScreens.HomePage &&
                        currentScreen != AltZagrebScreens.DetailPage
            )
        }


    ){innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AltZagrebScreens.HomePage.name,
            modifier = Modifier.padding(innerPadding),
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 400,
                        delayMillis = 50,
                        easing = LinearOutSlowInEasing
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis =400,
                        delayMillis = 50,
                        easing = LinearOutSlowInEasing
                    )
                )
            },
            popExitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 400,
                        delayMillis = 50,
                        easing = LinearOutSlowInEasing
                    )
                )
            }
        ){
            composable(
                route = AltZagrebScreens.HomePage.name
                ){

                AltZagrebHomeScreen(
                    onCardClick = {
                        viewModel.setCurrentScreen(it)
                        navController.navigate(it.name)
                    },
                    modifier= modifier
                )
            }
            composable(route = AltZagrebScreens.Dining.name){
                AltListScreen(
                    onClick = {
                        viewModel.setCurrentAltInstitution(it)
                        navController.navigate(AltZagrebScreens.DetailPage.name)
                    },
                    altInstitutionsList = AltRestaurantDataProvider.getAltRestaurants(),
                    modifier = modifier
                )
            }

            composable(route = AltZagrebScreens.Museums.name){
                AltListScreen(
                    onClick = {
                        viewModel.setCurrentAltInstitution(it)
                        navController.navigate(AltZagrebScreens.DetailPage.name)
                    },
                    altInstitutionsList = AltMuseumDataProvider.getAllMuseums(),
                    modifier = modifier
                )
            }
            composable(route = AltZagrebScreens.Coffee.name){
                AltListScreen(
                    onClick = {
                        viewModel.setCurrentAltInstitution(it)
                        navController.navigate(AltZagrebScreens.DetailPage.name)
                    },
                    altInstitutionsList = AltCoffeeDataProvider.getAllCoffeeShops(),
                    modifier = modifier
                )
            }
            composable(route = AltZagrebScreens.Nightlife.name){
                AltListScreen(
                    onClick = {
                        viewModel.setCurrentAltInstitution(it)
                        navController.navigate(AltZagrebScreens.DetailPage.name)
                    },
                    altInstitutionsList = AltNightlifeDataProvider.getAllNightLife(),
                    modifier = modifier

                )
            }
            composable(route = AltZagrebScreens.DetailPage.name){
                val context = LocalContext.current
                AltZagrebListItemDetailsScreen(
                    altInstitution = uiState.currentAltListItem,
                    onClickBack = {
                        navController.navigateUp()
                    },
                    onShare = { summary ->
                        shareAltInstitution(
                            context,
                            summary
                        )
                    }
                )
            }
        }
    }
}

private fun shareAltInstitution(context: Context, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.app_banner)
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AltZagrebAppBar(
    currentScreen: AltZagrebScreens,
    modifier: Modifier = Modifier
){

    TopAppBar(
        title = {
            Row(
                modifier = modifier
                    .fillMaxWidth()

            ){
                Text(
                    text = stringResource(currentScreen.title),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
    )
}

@Preview
@Composable
fun AltZagrebAppPreview(){
    AltZagrebTheme {
        Surface {
            AltZagrebApp(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
