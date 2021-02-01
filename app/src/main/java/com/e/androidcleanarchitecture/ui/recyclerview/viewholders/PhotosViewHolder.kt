package com.e.androidcleanarchitecture.ui.recyclerview.viewholders

import android.view.View
import android.widget.ImageView
import com.e.androidcleanarchitecture.data.PhotoData
import com.e.androidcleanarchitecture.databinding.PhotosRecyclerviewCellDesignBinding
import com.squareup.picasso.Picasso

class PhotosViewHolder(itemView: View):GenericViewHolder<PhotoData>(itemView) {

    private val binding=PhotosRecyclerviewCellDesignBinding.bind(itemView)
    private val image: ImageView=binding.photoCell

    override fun bind(item: PhotoData) {

        Picasso.get().load(item.url).into(image)
    }
}