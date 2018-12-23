package me.cristalliz.ash.githubjobs.data.Api

import me.cristalliz.ash.githubjobs.data.model.Position
import retrofit2.http.*
import io.reactivex.Observable

interface PositionsService {
    @GET ("/positions.json")
    fun positions(
        @Query("description") description: String?,
        @Query("location") location: String?,
        @Query("lat") lat: Double?,
        @Query("long") long: Double?,
        @Query("full_time") isFullTimeOnly: Boolean) : Observable<List<Position>>
}