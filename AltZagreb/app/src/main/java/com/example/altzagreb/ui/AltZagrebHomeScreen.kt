package com.example.altzagreb.ui


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.altzagreb.R
import com.example.altzagreb.data.NavigationIconsDataProvider.getNavigationIconsData
import com.example.altzagreb.ui.theme.AltZagrebTheme


@Composable
fun AltZagrebHomeScreen(
    onCardClick: (AltZagrebScreens) -> Unit,
    modifier : Modifier = Modifier
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        AltHomeScreenGrid(
            onCardClick = onCardClick,
            modifier = modifier
        )
    }
}

@Composable
fun AltHomeScreenGrid(
    onCardClick: (AltZagrebScreens) -> Unit,
    modifier : Modifier = Modifier
){
    val navigationIcons = getNavigationIconsData()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.vertical_grid_size)),
        verticalArrangement = Arrangement.Center
    ){
        items(navigationIcons){ item ->
            AltHomeScreenItemCard(
                drawableResource = item.drawableResource,
                stringResource = item.stringResource,
                color = item.color,
                onClick = {
                    onCardClick(item.navigation)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AltHomeScreenItemCard(
    @DrawableRes drawableResource: Int,
    @StringRes stringResource: Int,
    color: Color,
    onClick: () -> Unit
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = color),
        modifier = Modifier
            .size(
                width = dimensionResource(id = R.dimen.navigation_card_width),
                height = dimensionResource(id = R.dimen.navigation_card_height)
            )
            .padding(dimensionResource(id = R.dimen.padding_extra_small))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Icon(
                painter = painterResource(drawableResource),
                contentDescription = stringResource(stringResource)
            )
            Text(
                text = stringResource(stringResource)
            )
        }
    }
}

@Preview
@Composable
fun AltHomeScreenItemCardPreview(){
    AltZagrebTheme(darkTheme = false) {
        Surface {
            AltHomeScreenItemCard(
                drawableResource = R.drawable.local_dining,
                stringResource = R.string.dining,
                color = MaterialTheme.colorScheme.tertiary,
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun AltHomeScreenGridPreview(){
    AltZagrebTheme(darkTheme = true) {
        Surface {
            AltHomeScreenGrid(
                onCardClick = {}
            )
        }
    }
}

@Preview
@Composable
fun AltZagrebHomeScreenPreview(){
    AltZagrebTheme(darkTheme = false) {
        Surface {
            AltZagrebHomeScreen(
                onCardClick = {},
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}