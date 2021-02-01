package com.e.androidcleanarchitecture.di.modules

import com.e.androidcleanarchitecture.api.PhotosApi
import com.e.androidcleanarchitecture.di.scopes.ApplicationScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @ApplicationScope
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @ApplicationScope
    @Provides
    fun provide(retrofit:Retrofit):PhotosApi{
     return retrofit.create(PhotosApi::class.java)
    }


}