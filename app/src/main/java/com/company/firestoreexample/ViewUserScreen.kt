package com.company.firestoreexample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private val personCollectionRef = Firebase.firestore.collection("persons")



@Composable
fun ViewUserScreen(name: String?) {

    var personList = remember { mutableStateOf(mutableListOf<Person>()) }
    Scaffold(
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally) {
                for (person in personList.value) {
                    Text("${person.firstName} ${person.lastName} ${person.age}")
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Text(text = "Update data.",
                modifier = Modifier.clickable {
                    val tmpList = mutableListOf<Person>()
                    personCollectionRef.get().addOnSuccessListener {
                            collection ->
                        for (document in collection.documents) {
                            println("Iteration.")
                            val person = document.toObject<Person>()
                            println("${person?.firstName} ${person?.lastName} ${person?.age}")

                            if(person != null) tmpList.add(person)
                        }
                        personList.value = tmpList

                    }.addOnFailureListener { e -> println("Failed to retrieve data.")}
                })
            }
        }
    )
}