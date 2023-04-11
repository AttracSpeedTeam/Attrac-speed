package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyApiService {


    @GET("/api/attraction")
    fun getAttractions(): Call<List<Attraction>>
}