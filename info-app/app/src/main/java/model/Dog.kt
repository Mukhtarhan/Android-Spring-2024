package model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.UUID


data class Dog(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    @SerializedName("max_weight_male") val weight: Double,
    @SerializedName("max_height_male") val height: Double,
    val energy: Int,
    @SerializedName("image_link") val imageUrl: String,
    val playfulness: Int,
    val grooming: Int,
    val shedding: Int,
    var isFavor: Boolean = false
) : Serializable {

}