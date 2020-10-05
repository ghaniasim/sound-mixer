package com.example.soundmixer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    val repository: SoundRepository = SoundRepository()

    fun mySounds(filter: String) = liveData(Dispatchers.IO) {
        val retrievedSounds = repository.getJSON(filter)

        emit(retrievedSounds)
    }
}