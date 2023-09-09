package com.example.cinebuzz.otherfiles

import com.example.cinebuzz.dataclass.createpassmodelclass
import com.example.cinebuzz.dataclass.changepassEmail
import com.example.cinebuzz.dataclass.loginResponseX
import com.example.cinebuzz.dataclass.loginmodelclass
import com.example.cinebuzz.dataclass.resetpasss
import com.example.cinebuzz.dataclass.searchMoviemodelclass
import com.example.cinebuzz.dataclass.trendingmodelclassX
import com.example.cinebuzz.dataclass.otpmodelclass
import com.example.cinebuzz.dataclass.signUpmodelclass
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface cineservice1 {


    @POST("login")
    fun sendData(
        @Body loginmodelclass: loginmodelclass,
        ):Call<loginResponseX>

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
    ):Call<ArrayList<searchMoviemodelclass>>

    @GET("trending")
    fun trending(
    ):Call<ArrayList<trendingmodelclassX>>

    @GET("action?genre=Action")
    fun action(
    ):Call<ArrayList<trendingmodelclassX>>

    @GET("Premiere")
    fun premiere(
    ):Call<ArrayList<trendingmodelclassX>>

    @POST("wishlist")
    fun wishlist():Call<ResponseBody>

    @POST("history")
    fun history():Call<ResponseBody>

    @POST("count")
    fun count(): Call<ResponseBody>
}