package com.company.firestoreexample

// Sealed class only allows classes inside of this file to extend Screen.
sealed class Screen(val route: String) {
    object AddUserScreen : Screen("adduser_screen")
    object ViewUsersScreen : Screen("viewuser_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            this.append(route)
            args.forEach {
                arg -> append("/$arg")
            }
        }
    }
}