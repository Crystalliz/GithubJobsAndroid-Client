package me.cristalliz.ash.githubjobs.data.Api

import dagger.Module
import dagger.Provides
import me.cristalliz.ash.githubjobs.Services.ServiceModule
import retrofit2.Retrofit

@Module(includes = arrayOf(ServiceModule::class))
class ApiModule {
    @Provides
    fun positionsService(retrofit: Retrofit): PositionsService {
        return retrofit.create(PositionsService::class.java)
    }
}