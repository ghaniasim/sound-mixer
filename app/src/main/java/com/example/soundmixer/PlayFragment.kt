package com.example.soundmixer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_play.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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

        add_button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }

        play_button.setOnClickListener {

            lifecycleScope.launch(Dispatchers.Main) {
                for (i in 1 until sounds.size) {
                    val track = sounds[i].preview
                    val ft = async(Dispatchers.IO) {
                        if (track != null) {
                            playAudio(track)
                        }
                    }
                    ft.await()
                }
            }
        }
    }

    private fun playAudio(track: String) {

        MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(track)
            prepare()
            start()
        }
    }
}