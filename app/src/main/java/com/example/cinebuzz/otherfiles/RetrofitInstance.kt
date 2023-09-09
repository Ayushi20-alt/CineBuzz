package com.example.cinebuzz.otherfiles

import com.example.cinebuzz.SplashScreen.Companion.token
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitInstance {

//        private val client = OkHttpClient.Builder().build()
//        fun getInstance():Retrofit{
//            return  Retrofit.Builder()
//                .baseUrl("https://cinebuzz.onrender.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        }
//        fun init():cineservice1
//        {
//            // interface ka reference pass kiya h
//            return getInstance().create(cineservice1::class.java)
//        }


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://cinebuzz.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().addHeader("Authorization", "Bearer ${token}").build()
            chain.proceed(request)
        }.build())
        .build()

    fun init(): cineservice1 {
        return retrofit.create(cineservice1::class.java)
    }
}