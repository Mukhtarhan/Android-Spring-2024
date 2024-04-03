package model

import java.util.UUID

data class Dog(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val weight: Int,
    val height: Int,
    val energy: Int,
    val imageUrl: String,
    val playfulness: Int
)