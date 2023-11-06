package com.example.dailyfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyfacts.model.FactRepository.funFacts
import com.example.dailyfacts.ui.theme.DailyFactsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyFactsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FunFactsApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FunFactsApp(modifier: Modifier = Modifier){
    Scaffold (
        topBar = {
            FactsTopAppBar()
        }
    ){ it ->
        FunFactList(funFacts, it, modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactsTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Text(
                stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun FunFactPreview() {
    DailyFactsTheme{
        FunFactsApp()
    }
}