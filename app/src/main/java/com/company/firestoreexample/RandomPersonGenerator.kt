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
        val rnd: Random = Random(1337)
        val rnd1: Random = Random(1338)
        val rnd2: Random = Random(100)

        val firstName = randomFirstNames[rnd.nextInt(0, randomFirstNames.lastIndex)] // Not absolutely certain this is inclusive of last index.
        val lastName = randomLastNames[rnd1.nextInt(0, randomLastNames.lastIndex)]
        val age = rnd1.nextInt(18, 75)

        return Person(firstName, lastName, age)
    }
}