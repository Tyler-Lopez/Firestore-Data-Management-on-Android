package com.company.firestoreexample

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.AddUserScreen.route) {
        composable(route = Screen.AddUserScreen.route) {
            AddUserScreen(navController = navController)
        }
        composable(
            route = Screen.ViewUsersScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Phillip"
                    nullable = true
                }
            )
        ) {
            ViewUserScreen(name = it.arguments?.getString("name"))
        }
    }
}

