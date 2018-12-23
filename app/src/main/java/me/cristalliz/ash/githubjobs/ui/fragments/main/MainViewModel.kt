package me.cristalliz.ash.githubjobs.ui.fragments.main

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import me.cristalliz.ash.githubjobs.data.LocalRepository.LocalDataSource
import me.cristalliz.ash.githubjobs.data.PositionsRepository.PositionsDataSource
import me.cristalliz.ash.githubjobs.data.model.Position
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val positionsDataSource: PositionsDataSource,
    private val localDataSource: LocalDataSource
) : ViewModel() {
    fun getPositions(description: String) : Observable<List<Position>> = positionsDataSource.positions(description, null, null)

    fun setDetailedPosition(position: Position) = localDataSource.setDetailedPosition(position)
}
