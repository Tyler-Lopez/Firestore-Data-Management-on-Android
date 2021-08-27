package com.company.firestoreexample

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    // To control the NavHost a NavController is needed.
    val navController = rememberNavController()
    // A NavHost "hosts" navigation.
    // Each screen is it's own Composable.
    // The job of the NavHost is to navigate the user to different screens and pass arguments as necessary.
    NavHost(
        // Listens to and makes changes based on commands from NavController
        navController = navController,
        // Start at the provided Screen.
        startDestination = Screen.AddUserScreen.route) {
        // The composable tells the NavHost what each screen is.
        composable(route = Screen.AddUserScreen.route) {
            // Specify a composable that represents our Add User Screen.
            // Needs an instance of our NavController.
            AddUserScreen(navController = navController)
        }
        composable(route = Screen.ViewUsersScreen.route) {
            ViewUserScreen(navController = navController)
        }
    }
}

