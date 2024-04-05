package network

import model.Dog

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DogService {
    @GET("/v1/dogs")
    suspend fun getDogs(
        @Query("trainability") trainability: Int = 5,
        @Header("X-Api-Key") apiKey: String = "0wlsysAuFpPguLU2OmJYAw==VDx3rRwNp2mSm26D"
    ): List<Dog>
}