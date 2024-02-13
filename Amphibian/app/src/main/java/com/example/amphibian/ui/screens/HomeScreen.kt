package com.example.amphibian.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibian.model.Amphibian
import com.example.amphibian.ui.theme.AmphibianTheme
import com.example.amphibian.R

@Composable
fun HomeScreen(
    amphibianUiState: AmphibianUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when (amphibianUiState){
        is AmphibianUiState.Loading -> LoadingScreen(modifier = modifier)
        
        is AmphibianUiState.Success -> AmphibianListScreen(
            amphibianUiState.amphibians,
            modifier = modifier,
            contentPadding = contentPadding
        )
        
        is AmphibianUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier = modifier
        )
    }

}

@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = stringResource(id = R.string.loading_failed)
        )
        Text(
            text = stringResource(id = R.string.loading_failed),
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun AmphibianListScreen(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(contentPadding = contentPadding){
        items(amphibians){ item ->
            Card(
                elevation = CardDefaults.cardElevation(8.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(16.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){
                    AmphibianImageHeader(
                        item,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = item.description,
                        modifier = modifier.padding(top = 8.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun AmphibianImageHeader(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ){
        AmphibianImage(amphibian, modifier)
        Column(
            modifier = modifier
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            AmphibianDetails(amphibian, modifier)
        }

    }
}

@Composable
fun AmphibianImage(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(amphibian.imgSrc)
            .crossfade(true)
            .build(),
        contentDescription = amphibian.name,
        error = painterResource(id = R.drawable.error),
        placeholder = painterResource(id = R.drawable.loading_img),
        modifier = Modifier
            .size(86.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun AmphibianDetails(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
){
    Text(
        text = amphibian.name,
        style = MaterialTheme.typography.titleLarge
    )
    Text(
        text = amphibian.type,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    AmphibianTheme {
        val fakeAmphibians = listOf(
            Amphibian(
                name = "Name1", type = "Type1", description = "First description", imgSrc = "url1"
            )
        )
        HomeScreen(AmphibianUiState.Success(fakeAmphibians), {})
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    AmphibianTheme {
        LoadingScreen(modifier = Modifier.fillMaxSize())
    }
}