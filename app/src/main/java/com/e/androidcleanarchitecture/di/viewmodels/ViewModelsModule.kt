package com.e.androidcleanarchitecture.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.androidcleanarchitecture.di.scopes.ActivityScope
import com.e.androidcleanarchitecture.di.scopes.ViewModelKey
import com.e.androidcleanarchitecture.di.viewmodel.factory.ViewModelProviderFactory
import com.e.androidcleanarchitecture.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ActivityScope
    abstract fun bindViewModelProviderFactory(factory:ViewModelProviderFactory):ViewModelProvider.Factory
}