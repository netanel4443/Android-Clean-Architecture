package com.e.androidcleanarchitecture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.e.androidcleanarchitecture.R
import com.e.androidcleanarchitecture.data.PhotoData
import com.e.androidcleanarchitecture.ui.recyclerview.adapters.GenericRecyclerViewAdapter
import com.e.androidcleanarchitecture.ui.recyclerview.viewholders.GenericViewHolder
import com.e.androidcleanarchitecture.ui.recyclerview.viewholders.PhotosViewHolder

class PhotosRecyclerViewAdapter : GenericRecyclerViewAdapter<PhotoData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.photos_recyclerview_cell_design,parent,false)
        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<PhotoData>, position: Int) {
        if (holder is PhotosViewHolder) {holder.bind(items[position]) }
    }
}