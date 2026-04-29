import com.example.pc05.service.PokedexResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiInterface {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokedexResponse
}