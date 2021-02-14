package com.e.androidcleanarchitecture.api

import com.e.androidcleanarchitecture.data.PhotoData
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotosApi {

    @GET("photos")
    fun getPhotos(): Single<Response<ArrayList<PhotoData>>>

    @POST("photos")
    fun postPhoto(@Body photoData: PhotoData):Single<Response<PhotoData>>
}