package me.cristalliz.ash.githubjobs.data.LocalRepository

import me.cristalliz.ash.githubjobs.Extensions.Result
import me.cristalliz.ash.githubjobs.data.model.Position

interface LocalDataSource {
    fun setDetailedPosition(position: Position)
    fun getDetailedPotition(): Result<Position>
}