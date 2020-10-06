package com.example.soundmixer

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class SoundViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item, parent, false)) {

    private var mNameView: TextView? = null
    private var mImageView: ImageView? = null

    init {
        mNameView = itemView.txtname
        mImageView = itemView.imageView
    }

    fun bind(sound: Result, action: OnItemClickListener) {
        mNameView?.text = sound.name

        mNameView?.setOnClickListener { action.onIconClick() }

        mImageView?.setOnClickListener {
            action.onItemClick(sound, adapterPosition)
        }
    }
}

interface OnItemClickListener {

    fun onItemClick(item: Result, position: Int)
    fun onIconClick()
}