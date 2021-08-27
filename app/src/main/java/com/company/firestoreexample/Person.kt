package com.company.firestoreexample

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private val personCollectionRef = Firebase.firestore.collection("persons")

data class Person(
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = -1
)

fun savePerson(person: Person) {
    personCollectionRef.add(person).addOnSuccessListener { documentReference -> println("Successfully updated to Firestore. $documentReference") }
        .addOnFailureListener { e -> "Did not successfully upload to Firestore $e"}
}
