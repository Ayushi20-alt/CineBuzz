package com.example.cinebuzz

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitInstance {

        private val client = OkHttpClient.Builder().build()
        fun getInstance():Retrofit{
            return  Retrofit.Builder()
                .baseUrl("https://cinebuzz.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        fun init():cineservice1
        {
            return getInstance().create(cineservice1::class.java)
        }
}