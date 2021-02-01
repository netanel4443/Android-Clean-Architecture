package com.e.androidcleanarchitecture.di.components

import com.e.androidcleanarchitecture.di.modules.AppModule
import com.e.androidcleanarchitecture.di.modules.AppSubComponentsModule
import com.e.androidcleanarchitecture.di.scopes.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [
    AppModule::class,
    AppSubComponentsModule::class
])
interface ApplicationComponent {

    fun activityComponent():ActivityComponent.Factory


}