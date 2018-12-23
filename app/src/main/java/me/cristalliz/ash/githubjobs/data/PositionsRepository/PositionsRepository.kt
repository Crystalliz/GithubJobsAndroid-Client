package me.cristalliz.ash.githubjobs.data.PositionsRepository

import me.cristalliz.ash.githubjobs.data.model.Coordinates
import me.cristalliz.ash.githubjobs.data.model.Position
import io.reactivex.Observable
import me.cristalliz.ash.githubjobs.data.Api.PositionsService
import javax.inject.Inject

class PositionsRepository @Inject constructor(private val service: PositionsService) :
    PositionsDataSource {
    override fun positions(description: String?, location: String?, coordinates: Coordinates?, isFullTimeOnly: Boolean) : Observable<List<Position>> {
        return service.positions(
            description,
            location,
            coordinates?.lat,
            coordinates?.long,
            isFullTimeOnly
        )
    }
}
