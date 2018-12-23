package me.cristalliz.ash.githubjobs.data.PositionsRepository

import me.cristalliz.ash.githubjobs.data.model.Coordinates
import me.cristalliz.ash.githubjobs.data.model.Position
import io.reactivex.Observable

interface PositionsDataSource {
    fun positions(description: String?,
                  location: String?,
                  coordinates: Coordinates?,
                  isFullTimeOnly: Boolean = false) : Observable<List<Position>>
}