package com.example.artspaceapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceAppScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceAppScreen() {
    var currentArtWork by remember { mutableStateOf(1) }
    var image = R.drawable.chica
    var title = "The Girl with the Pearl Earring"
    var artist = "Vermeer"
    var year = "1902"
    when(currentArtWork) {
        1 -> {
            image = R.drawable.chica
            title = "The Girl with the Pearl Earring"
            artist = "Vermeer"
            year = "1902"
        }
        2 -> {
            image = R.drawable.cabezas
            title = "Los amantes"
            artist = "René Magritte "
            year = "1930"
        }
        3 -> {
            image = R.drawable.saturno_jpg
            title = "Saturno devorando a su hijo"
            artist = "Francisco de Goya"
            year = "1819"
        }
        4 -> {
            image = R.drawable.ola
            title = "La gran ola"
            artist = "Hokusai"
            year = "1831"
        }
        5 -> {
            image = R.drawable.fusilamiento
            title = "El 3 de mayo en Madrid"
            artist = "Francisco de Goya"
            year = "1814"
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F)
                .wrapContentSize(align = Alignment.Center),
            elevation = 16.dp,
            border = BorderStroke(1.dp, color = Color.DarkGray)
        ) {
            Image(
                modifier = Modifier.padding(32.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.weight(1F),
        ){
            Surface(
                elevation = 16.dp) {
                SpaceArtwork(
                    title = title,
                    artist = artist,
                    year = year,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ){
                Button(
                    modifier = Modifier.padding(8.dp).weight(1F),
                    onClick = { if(currentArtWork == 1) currentArtWork = 5 else currentArtWork-- }) {
                    Text(text = "Previous")
                }
                Button(
                    modifier = Modifier.padding(8.dp).weight(1F),
                    onClick = { if(currentArtWork == 5) currentArtWork = 1 else currentArtWork++ }) {
                    Text(text = "Next")
                }
            }
        }

    }
}


@Composable
fun SpaceArtwork(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
    ) {
        Text(text = title, fontSize = 25.sp, fontWeight = FontWeight.Light)
        Row {
            Text(text = artist, fontWeight = FontWeight.Bold)
            Text(text = " (", fontWeight = FontWeight.Light)
            Text(text = year, fontWeight = FontWeight.Light)
            Text(text = ")", fontWeight = FontWeight.Light)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceAppScreen()
    }
}