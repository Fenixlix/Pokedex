package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.detail_screen.view.screens.DetailScreen
import com.example.pokedex.detail_screen.viewmodel.DetailViewModel
import com.example.pokedex.home_screen.view.screens.HomeScreen
import com.example.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home_screen") {
                    composable(route = "home_screen") {
                        HomeScreen { pkId ->
                            navController.navigate(route = "details_screen/$pkId")
                        }
                    }
                    composable(
                        route = "details_screen/{pkId}",
                        arguments = listOf(navArgument(name = "pkId") { type = NavType.StringType })
                    ) {
                        DetailScreen(pkId = it.arguments?.getString("pkId") ?: "") { newPkId ->
                            if (navController.previousBackStackEntry != null) {
                                navController.popBackStack()
                            }
                            navController.navigate(route = "details_screen/$newPkId")
                        }
                    }
                }
            }
        }
    }
}