package com.e.androidcleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.e.androidcleanarchitecture.databinding.ActivityMainBinding
import com.e.androidcleanarchitecture.di.BaseApplication
import com.e.androidcleanarchitecture.di.components.ActivityComponent
import com.e.androidcleanarchitecture.di.components.DaggerApplicationComponent
import com.e.androidcleanarchitecture.ui.BaseActivity
import com.e.androidcleanarchitecture.ui.PhotosRecyclerViewAdapter
import com.e.androidcleanarchitecture.viewmodels.MainViewModel

class MainActivity : BaseActivity() {

    lateinit var activityComponent:ActivityComponent
    private lateinit var binding: ActivityMainBinding
    private lateinit var photosAdapter:PhotosRecyclerViewAdapter
    private val viewModel:MainViewModel by lazy(this::getViewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent=(application as BaseApplication).appcomponent
                                 .activityComponent()
                                 .create()
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        initRecyclerView(binding.recyclerView)

        initStateObserver()
        initEffectObserver()

        viewModel.getPhotos()
        viewModel.uploadPhoto()
    }

    private fun initEffectObserver() {
        viewModel.viewEffect.observe(this,  {

        })
    }

    private fun initStateObserver() {
        viewModel.viewState.observe(this,{state->
        println(state.second.photosList.size)
            if (state.first.photosList!=state.second.photosList){
                photosAdapter.addItems(state.second.photosList)
            }
        })
    }

    private fun initRecyclerView(recyclerView:RecyclerView) {
        photosAdapter= PhotosRecyclerViewAdapter()
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=photosAdapter
        recyclerView.setHasFixedSize(true)
    }

}