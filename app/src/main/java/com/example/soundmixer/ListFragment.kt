package com.example.soundmixer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(R.layout.fragment_list) {

    private var soundList = ArrayList<Result>()

    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showCont()
    }

    private fun showCont() {

        viewModel.mySounds("username:SoundAppProject tag:Rain").observe(viewLifecycleOwner, Observer {
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
                adapter = ListAdapter(soundList)
            }
        })
    }

}