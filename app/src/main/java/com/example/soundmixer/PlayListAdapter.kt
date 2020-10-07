package com.example.soundmixer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PlayListAdapter(context: Context, private val sounds: MutableList<PlaySound>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.play_item, parent, false)
        val thisSound = sounds[position]
        var tv = rowView.findViewById(R.id.txtname) as TextView
        tv.text = thisSound.name

        return rowView
    }

    override fun getItem(position: Int): Any {
        return sounds[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return sounds.size
    }
}