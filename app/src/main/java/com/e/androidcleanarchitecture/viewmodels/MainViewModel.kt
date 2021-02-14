package com.e.androidcleanarchitecture.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.e.androidcleanarchitecture.api.PhotosApi
import com.e.androidcleanarchitecture.data.PhotoData
import com.e.androidcleanarchitecture.di.scopes.ActivityScope
import com.e.androidcleanarchitecture.utils.SingleLiveEvent
import com.e.androidcleanarchitecture.utils.livedata.MviMutableLiveData
import com.e.androidcleanarchitecture.viewmodels.effects.MainViewEffects
import com.e.androidcleanarchitecture.viewmodels.states.MainViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
        private val photosApi: PhotosApi
):ViewModel() {

    private val _viewEffect=SingleLiveEvent<MainViewEffects>()
    val viewEffect get() = _viewEffect

    private val _viewState=MviMutableLiveData(MainViewState())
    val viewState get()= _viewState as LiveData<Pair<MainViewState,MainViewState>>

    private fun mviState(newState:MainViewState){
        _viewState.setMviValue(newState)
    }

    fun getPhotos(){
        photosApi.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->
                    response?.let {response->
                       if(response.isSuccessful){
                           val body=  response.body()?:ArrayList()
                       mviState( _viewState.currState()!!.copy(photosList = body))

                       }

                    }?:let {
                        //handle failure
                    }

                },{
                    //handle failure
                    println(it.message)
                })
    }

    fun uploadPhoto(){
        val photo=PhotoData(5001,5001,"title","url","thumbUrl")
        photosApi.postPhoto(photo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->
                    if (response.isSuccessful){
                        val body=response.body()
                        println(body)
                    }

                },{

                })
    }

}