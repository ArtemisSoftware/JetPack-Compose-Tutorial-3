package com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.models.Movie
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.models.getMovies
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.navigation.MovieScreens
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
            Text(text = "To The Movies")
        }
    }) {
        MovieList(navController = navController)
    }

}


@Composable
fun MovieList(movieList : List<Movie> = getMovies(), navController: NavController){

    Column(modifier = Modifier.padding(12.dp)) {

        LazyColumn{

            items(items = movieList){ movieId->
                MovieRow(movie = movieId){ id->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/${id}")
                }
            }

        }
    }
}