package com.example.soundmixer

class SoundRepository {

    var client: ServerAPI = RetrofitClient.retrofit

    suspend fun getJSON(filter: String) = client.getJSON("",
        "username:SoundAppProject tag:$filter",
        "name,previews",
        "LrVfNJZK6PUEKH5A1WTSmJAmyRx4XIfYhJVXsQNi")
}