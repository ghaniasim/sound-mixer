package com.example.soundmixer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null

    @SerializedName("license")
    @Expose
    var license: String? = null

    @SerializedName("username")
    @Expose
    var username: String? = null
}