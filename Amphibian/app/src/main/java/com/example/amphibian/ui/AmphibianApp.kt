package com.example.amphibian.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibian.R
import com.example.amphibian.ui.screens.AmphibianViewModel
import com.example.amphibian.ui.screens.HomeScreen
import com.example.amphibian.ui.theme.AmphibianTheme


@Composable
fun AmphibianApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            AmphibianAppBar()
        }
    ) {paddingValues ->
        val amphibianViewModel: AmphibianViewModel = viewModel(
            factory = AmphibianViewModel.Factory
        )
        HomeScreen(
            amphibianUiState = amphibianViewModel.amphibianUiState,
            retryAction = amphibianViewModel::getAmphibians,
            modifier = modifier,
            contentPadding = paddingValues
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianAppBar(){
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Preview(showBackground = true)
@Composable
fun AmphibianAppPreview(){
    AmphibianTheme {
        AmphibianApp()
    }
}