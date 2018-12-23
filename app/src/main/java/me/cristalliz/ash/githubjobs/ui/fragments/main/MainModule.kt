package me.cristalliz.ash.githubjobs.ui.fragments.main

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.cristalliz.ash.githubjobs.di.ActivityScoped
import me.cristalliz.ash.githubjobs.di.FragmentScoped

@Module
internal abstract class MainModule {
    @ActivityScoped
    @Binds
    abstract fun viewModel(mainViewModel: MainViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment
}