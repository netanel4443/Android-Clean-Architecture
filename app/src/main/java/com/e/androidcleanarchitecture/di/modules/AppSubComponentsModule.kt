package com.e.androidcleanarchitecture.di.modules

import com.e.androidcleanarchitecture.di.components.ActivityComponent
import dagger.Module

@Module(subcomponents =[ActivityComponent::class] )
abstract class AppSubComponentsModule {}