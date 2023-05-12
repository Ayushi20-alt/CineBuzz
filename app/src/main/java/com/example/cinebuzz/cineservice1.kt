package com.example.cinebuzz

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface cineservice1 {


    @POST("login")
    fun sendData(
        @Body loginmodelclass: loginmodelclass,
        ):Call<loginmodelclass>

    @POST("signup")
    fun createnew(
        @Body signUpmodelclass: signUpmodelclass,
    ):Call<signUpmodelclass>

    @POST("otp")
    fun otpverify(
        @Body otpmodelclass: otpmodelclass
    ):Call<otpmodelclass>
}