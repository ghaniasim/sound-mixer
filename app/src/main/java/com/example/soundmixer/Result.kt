package com.example.soundmixer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("previews")
    @Expose
    var previews: Previews? = null
}