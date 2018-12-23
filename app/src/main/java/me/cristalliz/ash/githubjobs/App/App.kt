package me.cristalliz.ash.githubjobs.App

import dagger.android.DaggerApplication
import me.cristalliz.ash.githubjobs.di.DaggerAppComponent
import me.cristalliz.ash.githubjobs.modules.ContextModule

class App: DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .contextModule(ContextModule(this))
        .build()
}