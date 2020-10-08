package com.example.soundmixer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

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

        Toast.makeText(activity, "Demo playing", Toast.LENGTH_SHORT).show()

        lifecycleScope.launch(Dispatchers.Main) {
            val track = item.previews?.preview_hq_mp3
            val ft = async(Dispatchers.IO) {
                if (track != null) {
                    playAudio(track)
                }
            }
            ft.await()
        }
    }

    override fun onIconClick(item: Result, position: Int) {

        val name = item.name
        val preview = item.previews?.preview_hq_mp3
        val nextAction = ListFragmentDirections.nextAction(name!!, preview!!)

        view?.let { Navigation.findNavController(it).navigate(nextAction) }
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