package com.example.soundmixer

class SoundRepository {

    var client: ServerAPI = RetrofitClient.retrofit

    suspend fun getJSON(filter: String) = client.getJSON("", filter, "YOUR_API_KEY")
}