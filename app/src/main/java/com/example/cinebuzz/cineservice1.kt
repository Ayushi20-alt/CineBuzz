package com.example.cinebuzz

import com.example.cinebuzz.dataclass.changepassEmail
import com.example.cinebuzz.dataclass.resetpasss
import com.example.cinebuzz.dataclass.searchMoviemodelclass
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface cineservice1 {


    @POST("login")
    fun sendData(
        @Body loginmodelclass: loginmodelclass,
        ):Call<ResponseBody>

    @POST("signup")
    fun createnew(
        @Body signUpmodelclass: signUpmodelclass,
    ):Call<ResponseBody>

    @POST("otp")
    fun otpverify(
        @Body otpmodelclass: otpmodelclass
    ):Call<ResponseBody>

    @PUT("password")
    fun createpass(
        @Body createpassmodelclass: createpassmodelclass
    ):Call<ResponseBody>

    @POST("forgot")
    fun forgotpass(
        @Body forgotpass : changepassEmail
    ):Call<ResponseBody>

    @PUT("resetPass")
    fun resetPass(
        @Body resetPass: resetpasss
    ):Call<ResponseBody>

    @POST("search")
    fun searchMovie(
        @Body searchMoviemodelclass: searchMoviemodelclass
    ):Call<ResponseBody>
}