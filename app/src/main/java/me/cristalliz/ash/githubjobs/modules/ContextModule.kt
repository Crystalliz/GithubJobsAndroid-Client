package me.cristalliz.ash.githubjobs.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(internal var context: Context) {
    @Provides
    fun getContext(): Context {
        return context.applicationContext
    }
}