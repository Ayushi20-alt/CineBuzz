package com.example.cinebuzz

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://cinebuzz-production.up.railway.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
   val cineservice1 by lazy{
        retrofit.create(cineservice1::class.java)
    }
}