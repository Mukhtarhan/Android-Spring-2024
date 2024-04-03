package model
import com.google.gson.annotations.SerializedName
import java.util.UUID

data class DogApi(
    val name: String,
    @SerializedName("max_weight_male") val weight: Int,
    @SerializedName("max_height_male") val height: Int,
    val energy: Int,
    @SerializedName("image_link") val imageUrl: String,
    val playfulness: Int
) {
    companion object {
        fun toDog(dogApi: DogApi) = Dog(
            id = UUID.randomUUID().toString(),
            name = dogApi.name,
            weight = dogApi.weight,
            height = dogApi.height,
            energy = dogApi.energy,
            imageUrl = dogApi.imageUrl,
            playfulness = dogApi.playfulness,
        )
    }
}
