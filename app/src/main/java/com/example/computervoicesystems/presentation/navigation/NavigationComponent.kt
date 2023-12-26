package com.example.computervoicesystems.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.computervoicesystems.domain.model.MovieDataClass
import com.example.computervoicesystems.presentation.screens.main_screen.MainScreen
import com.example.computervoicesystems.presentation.screens.one_movie_screen.OneMovieScreen


@Composable
fun NavigationComponent() {

    val navController = rememberNavController()
    val toBackScreen = { navController.popBackStack() }
    val toOneMovieScreen = { movie: MovieDataClass ->
        navController.navigate("${Screen.ONE_MOVIE_SCREEN.name}/${movie.id}")
    }

    NavHost(
        navController = navController,
        startDestination = Screen.MAIN_SCREEN.name
    ) {

        composable(
            route = Screen.MAIN_SCREEN.name
        ) {

            MainScreen(
                navController = navController,
                toOneMovieScreen = toOneMovieScreen,

                )
        }


        composable(
            route = "${Screen.ONE_MOVIE_SCREEN.name}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {

            val routeId = it.arguments?.getString("id").orEmpty()


            OneMovieScreen(
                navController = navController,
            )
        }

    }

}

enum class Screen {
    MAIN_SCREEN,
    ONE_MOVIE_SCREEN
}