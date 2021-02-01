package com.e.androidcleanarchitecture.viewmodels.states

import com.e.androidcleanarchitecture.data.PhotoData

data class MainViewState(
    var photosList: ArrayList<PhotoData> =ArrayList<PhotoData>()
) {}