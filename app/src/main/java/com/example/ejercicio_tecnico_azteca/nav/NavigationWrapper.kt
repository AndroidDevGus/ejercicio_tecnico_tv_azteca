package com.example.ejercicio_tecnico_azteca.nav

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio_tecnico_azteca.ui.SplashScreen
import com.example.ejercicio_tecnico_azteca.ui.home.HomeScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun NavigationWrapper(
    innerPadding: PaddingValues,
) {
    val navController = rememberNavController()

    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = CCSplash,
            modifier = Modifier
        ) {
            composable<CCSplash> {
                SplashScreen(
                    onTimeout = {
                        navController.navigate(CCHome) {
                            popUpTo<CCSplash> { inclusive = true } // ← limpia el backstack
                        }
                    }
                )
            }

            composable<CCHome> {
                HomeScreen()
            }
        }
    }
}
