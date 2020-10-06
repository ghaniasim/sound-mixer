package com.example.soundmixer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


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
        Toast.makeText(activity, item.previews?.preview_hq_mp3, Toast.LENGTH_SHORT).show()
    }

    override fun onIconClick() {
        Toast.makeText(activity, "Icon clicked", Toast.LENGTH_SHORT).show()
    }

}