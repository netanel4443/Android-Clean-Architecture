package com.e.androidcleanarchitecture.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.e.androidcleanarchitecture.api.PhotosApi
import com.e.androidcleanarchitecture.viewmodels.states.MainViewState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule


@RunWith(AndroidJUnit4::class)
class MainViewModelTest{

    @get:Rule
    val initRule: MockitoRule = MockitoJUnit.rule()// has to be public according to the docs

    @get:Rule
    val instantTaskExecutorRule= InstantTaskExecutorRule()

    @Mock
    lateinit var stateObserver: Observer<Pair<MainViewState,MainViewState>>

    @Mock
    lateinit var photosApi:PhotosApi

    lateinit var viewModel:MainViewModel

    @Before fun setUp(){
        viewModel= MainViewModel(photosApi)
        viewModel.viewState.observeForever(stateObserver)
    }

    @Test fun getPhotos(){
    
        

    }

}