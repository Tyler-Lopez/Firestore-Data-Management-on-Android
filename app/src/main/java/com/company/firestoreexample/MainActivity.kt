package com.company.firestoreexample

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.firestoreexample.ui.theme.FirestoreExampleTheme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private val personCollectionRef = Firebase.firestore.collection("persons")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            var lastNameState by remember {
                mutableStateOf("")
            }
            var ageState by remember {
                mutableStateOf("")
            }
            FirestoreExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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
                                        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
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
                                        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
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
                                        modifier = Modifier.fillMaxWidth().background(Color.LightGray)
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                                        Button(onClick = {
                                            uploadData(
                                                firstName = textFieldState,
                                                lastName = lastNameState,
                                                age = ageState.toInt()
                                            )
                                        }, modifier = Modifier
                                            .padding(5.dp)

                                        ) {
                                            Text("Register")
                                        }
                                        Button(onClick = {

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
            }
        }
    }

    fun uploadData(firstName: String, lastName: String, age: Int) {
        val person = Person(firstName, lastName, age)
        savePerson(person)
    }

    data class Person(
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = -1
    )

    private fun savePerson(person: Person) {
        personCollectionRef.add(person).addOnSuccessListener { documentReference -> println("success") }
            .addOnFailureListener { e -> "this happened obv "}

    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirestoreExampleTheme {
        Greeting("Android")
    }
}