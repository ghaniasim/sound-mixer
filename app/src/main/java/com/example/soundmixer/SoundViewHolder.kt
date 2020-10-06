package com.example.soundmixer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class SoundViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item, parent, false)) {

    private var mNameView: TextView? = null
    private var mTagsView: TextView? = null

    init {
        mNameView = itemView.txtname
        mTagsView = itemView.txttags
    }

    fun bind(sound: Result, action: OnItemClickListener) {
        mNameView?.text = sound.name
        mTagsView?.text = sound.previews?.preview_hq_mp3

        mNameView?.setOnClickListener { action.onIconClick() }

        mTagsView?.setOnClickListener {
            action.onItemClick(sound, adapterPosition)
        }
    }
}

interface OnItemClickListener {

    fun onItemClick(item: Result, position: Int)
    fun onIconClick()
}