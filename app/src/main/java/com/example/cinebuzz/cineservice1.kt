package com.example.cinebuzz

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface cineservice1 {

    @POST("login")
    fun sendData(
       @Body cine1: cine1
    ):Call<cine1>

}