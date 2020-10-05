package com.example.soundmixer

import retrofit2.http.GET
import retrofit2.http.Query

interface ServerAPI {

    // @GET("/apiv2/search/text/?query=&filter=&token=qJknD48oD1coBOqra14qB7W9Ks4zNlscYNpImZXL")
    @GET("/apiv2/search/text/")
    //suspend fun getJSON(): Sounds
    suspend fun getJSON(@Query("query") q: String, @Query("filter") f:String, @Query("token") t:String): Sounds
}