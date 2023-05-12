package com.example.cinebuzz

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://cinebuzz-production.up.railway.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
