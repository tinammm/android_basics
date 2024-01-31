package com.example.altzagreb.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.altzagreb.R
import com.example.altzagreb.data.AltRestaurantDataProvider.getAltRestaurants
import com.example.altzagreb.model.AltInstitution
import com.example.altzagreb.ui.theme.AltZagrebTheme

@Composable
fun AltListScreen(
    modifier: Modifier = Modifier,
    altInstitutionsList: List<AltInstitution>,
    onClick : (AltInstitution) -> Unit,
    contentPadding: PaddingValues = PaddingValues(8.dp)
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = contentPadding
    ){
        items(altInstitutionsList){ item ->
            AltListItem(
                onClick = onClick,
                altItem = item,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_extra_small))
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AltListItem(
    onClick : (AltInstitution) -> Unit,
    modifier : Modifier = Modifier,
    altItem : AltInstitution
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        onClick = {onClick(altItem)},
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = modifier
            .height(140.dp)
            .padding(dimensionResource(id = R.dimen.padding_extra_small))
    ){
        Row{
            Image(
                painter = painterResource(altItem.image),
                contentDescription = stringResource(altItem.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .fillMaxHeight()
                    .weight(2f),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = stringResource(altItem.name),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(altItem.longDescriptor),
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment =  Alignment.Bottom
                ){
                    Text(
                        text = stringResource(altItem.shortDescriptor),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        text = altItem.pricing.price,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AltListItemPreview(){
    AltZagrebTheme {
        Surface {
            AltListItem(
                onClick = {},
                altItem = getAltRestaurants()[0],
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun AltListScreenPreview(){
    AltZagrebTheme {
        Surface {
            AltListScreen(
                onClick = {},
                altInstitutionsList = getAltRestaurants(),
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}