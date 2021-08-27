package com.company.firestoreexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private val personCollectionRef = Firebase.firestore.collection("persons")


@Composable
fun AddUserScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember { mutableStateOf("") }
    var lastNameState by remember { mutableStateOf("") }
    var ageState by remember { mutableStateOf("") }
    Scaffold(
        scaffoldState = scaffoldState,
        content = {
            Row(modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text("First Name")
                        },
                        onValueChange = {
                            textFieldState = it
                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = lastNameState,
                        label = {
                            Text("Last Name")
                        },
                        onValueChange = {
                            lastNameState = it
                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = ageState,
                        label = {
                            Text("Age")
                        },
                        onValueChange = {
                            ageState = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        Button(onClick = { // Clicked when attempt to register a Person.
                            uploadData(
                                firstName = textFieldState,
                                lastName = lastNameState,
                                age = ageState.toInt()
                            )
                            // Navigate us to the other screen.
                            navController.navigate(Screen.ViewUsersScreen.withArgs(textFieldState))
                        }, modifier = Modifier
                            .padding(5.dp)

                        ) {
                            Text("Register")
                        }
                        Button(onClick = {
                            navController.navigate(Screen.ViewUsersScreen.withArgs("Tyler"))
                        }, modifier = Modifier
                            .padding(5.dp)) {
                            Text("View Data")
                        }
                    }

                }
            }
        }
    )
}

fun uploadData(firstName: String, lastName: String, age: Int) {
    val person = Person(firstName, lastName, age)
    savePerson(person)
}

private fun savePerson(person: Person) {
    personCollectionRef.add(person).addOnSuccessListener { documentReference -> println("Successfully updated to Firestore. $documentReference") }
        .addOnFailureListener { e -> "Did not successfully upload to Firestore $e"}
}

data class Person(
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = -1
)
