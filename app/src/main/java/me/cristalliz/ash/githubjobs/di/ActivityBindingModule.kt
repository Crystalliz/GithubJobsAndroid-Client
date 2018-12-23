package me.cristalliz.ash.githubjobs.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.cristalliz.ash.githubjobs.ui.activities.MainActivity
import me.cristalliz.ash.githubjobs.ui.fragments.main.MainModule
import me.cristalliz.ash.githubjobs.ui.fragments.positiondetails.PositionDetailsModule

@Module
internal abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class, PositionDetailsModule::class))
    internal abstract fun mainActivity(): MainActivity
}