package com.e.androidcleanarchitecture.di

import android.app.Application
import com.e.androidcleanarchitecture.di.components.ApplicationComponent
import com.e.androidcleanarchitecture.di.components.DaggerApplicationComponent

class BaseApplication:Application() {

    val appcomponent=DaggerApplicationComponent.create()

}