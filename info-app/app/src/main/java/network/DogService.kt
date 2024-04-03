package network

import model.DogApiResponse
import retrofit2.Call
import retrofit2.http.GET
interface DogService {
    @GET("dogs?trainability=5")
    fun fetchDogList(): Call<DogApiResponse>
}