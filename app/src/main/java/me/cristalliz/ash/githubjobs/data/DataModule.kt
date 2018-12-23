package me.cristalliz.ash.githubjobs.data

import dagger.Module
import dagger.Provides
import me.cristalliz.ash.githubjobs.data.Api.ApiModule
import me.cristalliz.ash.githubjobs.data.Api.PositionsService
import me.cristalliz.ash.githubjobs.data.LocalRepository.LocalDataSource
import me.cristalliz.ash.githubjobs.data.LocalRepository.LocalRepository
import me.cristalliz.ash.githubjobs.data.PositionsRepository.PositionsDataSource
import me.cristalliz.ash.githubjobs.data.PositionsRepository.PositionsRepository
import javax.inject.Singleton

@Module(includes = arrayOf(ApiModule::class))
class DataModule {
    @Provides
    @Singleton
    fun localDataSource() : LocalDataSource {
        return LocalRepository()
    }

    @Provides
    @Singleton
    fun positionsDataSource(service: PositionsService) : PositionsDataSource {
        return PositionsRepository(service)
    }
}