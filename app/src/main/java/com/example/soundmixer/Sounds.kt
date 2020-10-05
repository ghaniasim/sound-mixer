package com.example.soundmixer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sounds {

    @SerializedName("count")
    @Expose
    var count: Int? = null

    @SerializedName("next")
    @Expose
    var next: Any? = null

    @SerializedName("results")
    @Expose
    var results: List<Result>? = null

    @SerializedName("previous")
    @Expose
    var previous: Any? = null
}