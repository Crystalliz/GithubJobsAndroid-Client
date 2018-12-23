package me.cristalliz.ash.githubjobs.ui.fragments.positiondetails

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.cristalliz.ash.githubjobs.di.ActivityScoped
import me.cristalliz.ash.githubjobs.di.FragmentScoped

@Module
internal abstract class PositionDetailsModule {
    @ActivityScoped
    @Binds
    abstract fun viewModel(positionDetailsViewModel: PositionDetailsViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun positionDetailsFragment(): PositionDetailsFragment
}