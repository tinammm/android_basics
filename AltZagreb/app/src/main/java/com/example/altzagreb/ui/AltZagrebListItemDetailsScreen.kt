package com.example.altzagreb.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.altzagreb.R
import com.example.altzagreb.data.AltMuseumDataProvider
import com.example.altzagreb.model.AltInstitution
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun AltZagrebListItemDetailsScreen(
    altInstitution: AltInstitution,
    onClickBack : () -> Unit,
    onShare: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Box( modifier = modifier){

        Column(modifier = modifier.verticalScroll(rememberScrollState())){
            Image(
                painter = painterResource(altInstitution.image),
                contentDescription = stringResource(altInstitution.name),
                modifier = modifier
                    .fillMaxWidth()
                    .height(260.dp),
                contentScale = ContentScale.Crop
            )
            AltZagrebInstitutionDetails(
                altInstitution = altInstitution,
                modifier = modifier,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = stringResource(altInstitution.longDescriptor),
                modifier = modifier
                    .padding(
                        bottom = dimensionResource(R.dimen.padding_large)
                    )
                    .padding(horizontal = dimensionResource(R.dimen.padding_large)),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Center
            )
            AltZagrebListItemLocationCard(
                altInstitution = altInstitution,
                modifier = modifier
            )
        }
        AltZagrebButtonRow(
            altInstitution = altInstitution,
            onClickBack = onClickBack,
            onShare = onShare,
            modifier = modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_large))
                .padding(top = dimensionResource(id = R.dimen.padding_extra_large))
                .background(color = Color.Transparent)
        )
    }
}

@Composable
fun AltZagrebListItemLocationCard(
    altInstitution: AltInstitution,
    modifier: Modifier = Modifier
){
   val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(altInstitution.geoLocation, 15f)
    }
    Box(modifier= modifier
        .background(color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
    ){
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .height(240.dp)
        ){
            val context = LocalContext.current
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties (
                    mapStyleOptions = MapStyleOptions(context.getString(R.string.style_json)))
            ) {
                Marker(
                    state = MarkerState(position = altInstitution.geoLocation),
                    title = stringResource(altInstitution.name),
                    snippet = stringResource(altInstitution.name)
                )
            }
        }
    }

}


@Composable
fun AltZagrebInstitutionDetails(
    altInstitution: AltInstitution,
    modifier: Modifier = Modifier,
    color : Color
){
    Row(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = stringResource(altInstitution.name),
                style = MaterialTheme.typography.headlineLarge,
                color = color,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_extra_small)))
            Text(
                text = stringResource(altInstitution.shortDescriptor),
                style = MaterialTheme.typography.titleMedium,
                color = color
            )
            Text(
                text = altInstitution.pricing.price,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_extra_small)),
                color = color
            )
        }
    }
}

@Composable
fun AltZagrebButtonRow(
    altInstitution: AltInstitution,
    onClickBack : () -> Unit,
    onShare : (String) -> Unit,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        val iconModifier = Modifier.background(
            color = MaterialTheme.colorScheme.primary,
            shape = CircleShape
        )

        val iconTint = MaterialTheme.colorScheme.onPrimary
        val summary = stringResource(
            id = R.string.summary,
            stringResource(altInstitution.name),
            stringResource(altInstitution.shortDescriptor),
            stringResource(altInstitution.locationLink)
        )

        IconButton(
            onClick = onClickBack,
            modifier = iconModifier
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_arrow_back),
                contentDescription = stringResource(R.string.back_arrow),
                tint = iconTint
            )
        }
        IconButton(
            onClick = {onShare(summary)},
            modifier = iconModifier
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_share),
                contentDescription = stringResource(R.string.back_arrow),
                tint = iconTint
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AltZagrebAlternativeScreenPreview(){
    AltZagrebListItemDetailsScreen(
        altInstitution = AltMuseumDataProvider.getAllMuseums()[1],
        onClickBack = {},
        onShare = {summary ->},
        modifier = Modifier
            .fillMaxWidth()

    )
}