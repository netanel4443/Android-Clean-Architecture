package com.e.androidcleanarchitecture.di.components

import com.e.androidcleanarchitecture.MainActivity
import com.e.androidcleanarchitecture.di.scopes.ActivityScope
import com.e.androidcleanarchitecture.di.viewmodels.ViewModelsModule
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ViewModelsModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory{
        fun create():ActivityComponent
    }
    fun inject(mainActivity: MainActivity)
}