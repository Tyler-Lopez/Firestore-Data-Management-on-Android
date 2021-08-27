package com.company.firestoreexample

import kotlin.random.Random

class RandomPersonGenerator {
    val randomFirstNames = listOf(
        "April",
        "Emory",
        "David",
        "Tyler",
        "Rebecca",
        "Craig",
        "Al",
        "Jose",
        "Mary",
        "John",
        "Jeff",
        "Olivia",
        "Sophia",
        "Elizabeth",
        "Cathy",
        "Catherine",
        "Skyler",
        "Tim",
        "Joe",
        "Mallory",
        "Megan",
        "Miranda",
        "Chad",
        "Joseph",
        "Chris",
        "Nathan",
        "Tomas"
    )
    val randomLastNames = listOf(
        "Lopez",
        "Yurgens",
        "Sanchez",
        "Garcia",
        "Moreno",
        "Vantol",
        "Smith",
        "Cornejo",
        "Paine",
        "Morgan",
        "Rathor",
        "Valco",
        "Koop",
        "Haertel",
        "O'Mara",
        "Keen",
        "Kruse",
        "Martinez",
        "Matzke",
        "Zerod",
        "Moore",
        "Livingston",
        "Irwin",
        "Ruppert",
        "Jones"
    )

    fun generateRandomPerson(): Person {
        val rnd: Random = Random

        val firstName = randomFirstNames[rnd.nextInt(0, randomFirstNames.lastIndex)] // Not absolutely certain this is inclusive of last index.
        val lastName = randomLastNames[rnd.nextInt(0, randomLastNames.lastIndex)]
        val age = rnd.nextInt(18, 75)

        return Person(firstName, lastName, age)
    }
}