package com.e.androidcleanarchitecture.ui.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.e.androidcleanarchitecture.ui.recyclerview.viewholders.GenericViewHolder

open class GenericRecyclerViewAdapter<T>:RecyclerView.Adapter<GenericViewHolder<T>>() {

    val items=ArrayList<T>()

    fun addItems(items:ArrayList<T>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item:T){
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(viewType,parent,false)
        return GenericViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
      holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}