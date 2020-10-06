package com.example.soundmixer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL


class ListFragment : Fragment(R.layout.fragment_list), OnItemClickListener {

    private var soundList = ArrayList<Result>()
    private var filter = ""

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = ListFragmentArgs.fromBundle(it)
            filter = safeArgs.category
        }

        showCont(filter)
    }

    private fun showCont(filter: String) {

        viewModel.mySounds(filter).observe(viewLifecycleOwner, Observer {
            val sounds = it.results

            for (sound in sounds!!){
                soundList.add(sound!!)
            }

            recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                addItemDecoration( DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
                )
                adapter = ListAdapter(soundList, this@ListFragment)
            }
        })
    }

    override fun onItemClick(item: Result, position: Int) {

        lifecycleScope.launch(Dispatchers.Main) {
            val track = item.previews?.preview_hq_mp3
            val ft = async(Dispatchers.IO) {
                if (track != null) {
                    playAudio(track)
                }
            }
            ft.await()
        }

        Toast.makeText(activity, "Sound playing", Toast.LENGTH_SHORT).show()
    }

    override fun onIconClick() {
        Toast.makeText(activity, "Icon clicked", Toast.LENGTH_SHORT).show()
    }

    fun playAudio(track: String) {

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