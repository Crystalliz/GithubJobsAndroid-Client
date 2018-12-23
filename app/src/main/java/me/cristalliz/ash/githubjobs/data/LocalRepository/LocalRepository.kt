package me.cristalliz.ash.githubjobs.data.LocalRepository

import me.cristalliz.ash.githubjobs.Extensions.Result
import me.cristalliz.ash.githubjobs.Extensions.asErrorResult
import me.cristalliz.ash.githubjobs.Extensions.asResult
import me.cristalliz.ash.githubjobs.Extensions.unwrap
import javax.inject.Inject
import me.cristalliz.ash.githubjobs.data.model.Position

class LocalRepository @Inject constructor(): LocalDataSource {
    private var mDetailedPosition: Position? = null

    override fun setDetailedPosition(position: Position) {
        mDetailedPosition = position
    }

    override fun getDetailedPotition(): Result<Position> {
        return try {
            mDetailedPosition.unwrap().asResult()
        } catch (e: Throwable) {
            e.asErrorResult()
        }
    }
}