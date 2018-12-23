package me.cristalliz.ash.githubjobs.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.cristalliz.ash.githubjobs.App.App
import me.cristalliz.ash.githubjobs.data.DataModule
import me.cristalliz.ash.githubjobs.modules.ContextModule
import me.cristalliz.ash.githubjobs.modules.PicassoModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityBindingModule::class, AndroidSupportInjectionModule::class, DataModule::class, PicassoModule::class))
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface  Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun contextModule(contextModule: ContextModule): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}