package com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.screens.HomeScreen
import com.artemissoftware.jetpackcomposetutorial3.ui.tothemovies.screens.details.DetailsScreen

@ExperimentalAnimationApi
@Composable
fun MovieNavigation(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name ){

        composable(route = MovieScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(route = MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})){
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }

}