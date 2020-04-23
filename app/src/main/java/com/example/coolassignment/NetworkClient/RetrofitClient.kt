package com.example.coolassignment.NetworkClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    var BASE_URL = "https://jsonplaceholder.typicode.com/"

    var retrofit: Retrofit? = null

    val retrofitClient: Retrofit?
        get() {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit

        }
}
