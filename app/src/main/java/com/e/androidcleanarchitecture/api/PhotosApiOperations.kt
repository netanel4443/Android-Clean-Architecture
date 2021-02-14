package com.e.androidcleanarchitecture.api

import com.e.androidcleanarchitecture.data.PhotoData
import com.e.androidcleanarchitecture.di.scopes.ActivityScope
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

@ActivityScope
class PhotosApiOperations @Inject constructor(private val photosApi: PhotosApi) {

    fun getPhotos(): Single<Response<ArrayList<PhotoData>>> {
     return  photosApi.getPhotos()
    }

    fun uploadPhoto(photoData: PhotoData):Single<Response<PhotoData>>{
        return photosApi.postPhoto(photoData)
    }
}