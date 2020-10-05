package com.example.soundmixer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_play.*

class PlayFragment : Fragment(R.layout.fragment_play) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }
    }
}