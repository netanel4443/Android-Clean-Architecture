package com.e.androidcleanarchitecture.ui.recyclerview.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.e.androidcleanarchitecture.ui.recyclerview.helpers.ViewHolderHelper

open class GenericViewHolder<T>(itemView: View):RecyclerView.ViewHolder(itemView),ViewHolderHelper<T> {

    override fun bind(item: T) {}


}