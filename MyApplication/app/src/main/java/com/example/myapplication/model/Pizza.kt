package com.example.myapplication.model

import java.io.Serializable
import java.util.UUID;

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val shortDescription: String,
    val sizeDescription: String,
    val testoDescription: String,
    val imageRes: Int,
    val smallPrice: Int,
    val mediumPrice: Int,
    val bigPrice: Int,
    val combo: Boolean,
) : Serializable{



}