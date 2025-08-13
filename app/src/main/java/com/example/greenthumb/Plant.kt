package com.example.greenthumb

// This is just a simple data class to hold information about a plant.
// It doesn't need Room annotations yet.
data class Plant(
    val id: Int,
    val name: String,
    val species: String,
    val photoUri: String,
    val wateringDate: Long
)