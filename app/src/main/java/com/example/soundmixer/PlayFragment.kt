package com.example.soundmixer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_play.*

class PlayFragment : Fragment(R.layout.fragment_play) {

    private val sounds = GlobalModel.sounds

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = PlayFragmentArgs.fromBundle(it)
            val name = safeArgs.name
            val preview = safeArgs.preview

            sounds.add(PlaySound(name, preview))
        }

        for (sound in sounds) {
            Log.i("ABC", sound.preview)
        }

        Log.i("ABC", sounds.size.toString())

        add_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }
    }
}