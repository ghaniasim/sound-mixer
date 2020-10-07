package com.example.soundmixer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(R.layout.fragment_category), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cars_card.setOnClickListener(this)
        bike_card.setOnClickListener(this)
        ambience_card.setOnClickListener(this)
        airplane_card.setOnClickListener(this)
        tram_card.setOnClickListener(this)
        construction_card.setOnClickListener(this)
        wind_card.setOnClickListener(this)
        rain_card.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.cars_card -> nextaction("cars")
            R.id.bike_card -> nextaction("bike")
            R.id.ambience_card -> nextaction("ambience")
            R.id.airplane_card -> nextaction("airplane")
            R.id.tram_card -> nextaction("tram")
            R.id.construction_card -> nextaction("construction")
            R.id.wind_card -> nextaction("wind")
            R.id.rain_card -> nextaction("rain")
        }
    }

    private fun nextaction(action: String) {
        val nextAction = CategoryFragmentDirections.nextAction(action)
        view?.let { Navigation.findNavController(it).navigate(nextAction) }
    }
}