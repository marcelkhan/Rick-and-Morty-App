package com.marcelkhan.rickandmortyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.Image
import coil.compose.rememberAsyncImagePainter
import com.marcelkhan.rickandmortyapp.model.characters.Result
import com.marcelkhan.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import com.marcelkhan.rickandmortyapp.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Characters()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Characters() {
    val characterViewModel = viewModel<CharacterViewModel>()
    val characters by characterViewModel.characters.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Rick and Morty App")
                }
            )
        }
    ) {
        LazyColumn{
            items(characters.results.size) {
                CharactersContent(characterEntries = characters.results[it])
            }
        }
    }
}

@Composable
fun CharactersContent(characterEntries: Result) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 4.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(characterEntries.image),
                contentDescription = characterEntries.name,
                modifier = Modifier
                    .size(170.dp)

            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = characterEntries.name, style = MaterialTheme.typography.subtitle1)
                Text(text = "${characterEntries.status} - ${characterEntries.species}", style = MaterialTheme.typography.subtitle2)
                Text(text = "Last known location:", style = MaterialTheme.typography.overline, modifier = Modifier.padding(top = 4.dp))
                Text(text = characterEntries.location.name, style = MaterialTheme.typography.body2)
                Text(text = "Origin:", style = MaterialTheme.typography.overline, modifier = Modifier.padding(top = 4.dp))
                Text(text = characterEntries.origin.name, style = MaterialTheme.typography.body2)
            }
        }
    }
}