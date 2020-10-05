package com.example.soundmixer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arrayOf("Cars", "Bikes", "Airplanes", "Tram", "Construction", "Wind", "Rain")

        category_list.adapter = activity?.applicationContext?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, category) }

        category_list.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(activity, "You clicked on ${category[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}