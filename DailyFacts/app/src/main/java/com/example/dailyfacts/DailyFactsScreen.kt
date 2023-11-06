package com.example.dailyfacts


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandCircleDown
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyfacts.model.FactRepository.funFacts
import com.example.dailyfacts.model.FunFact
import com.example.dailyfacts.ui.theme.DailyFactsTheme
import com.example.dailyfacts.ui.theme.Shapes

@Composable
fun FunFactList(
    funFacts: List<FunFact>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
){
    LazyColumn(contentPadding = contentPadding){
        items(funFacts){ item ->
            FunFactCard(item, modifier)
        }
    }
}

@Composable
fun FunFactCard(fact: FunFact, modifier: Modifier = Modifier){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation)
        ),
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.small_padding))
            .clip(Shapes.medium)
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.small_padding))
        ) {
            FactTitle(fact)
            FactImage(fact)
            FactDescription(fact)
        }
    }
}

@Composable
fun FactTitle(fact: FunFact, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.small_padding))
    ){
        Text(
            text = String.format(stringResource(id = R.string.day_format_string), fact.dayOfMonth),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = fact.title),
            style = MaterialTheme.typography.displayMedium
        )
    }
}


@Composable
fun FactImage(fact: FunFact, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = fact.image),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.image_height))
            .clip(Shapes.small),
        contentScale = ContentScale.Crop,

    )
}

@Composable
fun FactDescription(fact: FunFact, modifier: Modifier = Modifier){
    var expanded by remember {mutableStateOf(false)}
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.small_padding))
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ){
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = stringResource(id = fact.shortDescription),
                modifier = modifier.weight(1f),
                style = MaterialTheme.typography.labelMedium
            )
            ExpandFactButton(expanded, {expanded = ! expanded})

        }
        if(expanded){
            Spacer(
                modifier = Modifier.size(dimensionResource(id = R.dimen.extra_small_padding))
            )
            Text(
                stringResource(id = fact.fact),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun ExpandFactButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandCircleDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary
        )
    }

}

@Preview(showBackground = true)
@Composable
fun FunFactScreenPreview(){
    DailyFactsTheme {
        FunFactList(funFacts)
    }
}

@Preview(showBackground = true)
@Composable
fun FunFactDarkScreenPreview(){
    DailyFactsTheme(darkTheme = true) {
        FunFactList(funFacts)
    }
}


