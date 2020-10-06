package com.example.soundmixer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: ArrayList<Result>, var clickListener: OnItemClickListener)
    : RecyclerView.Adapter<SoundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SoundViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val sound: Result = list[position]
        holder.bind(sound, clickListener)
    }

    override fun getItemCount(): Int = list.size

}