package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dogService: DogService  = retrofit.create(DogService::class.java)
}