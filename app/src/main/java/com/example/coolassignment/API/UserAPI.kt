package com.example.coolassignment.API


import com.example.coolassignment.Model.Users

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {

    @get:GET("posts")
    val users: Call<List<Users>>

}
