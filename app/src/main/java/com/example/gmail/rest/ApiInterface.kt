package com.example.gmail.rest

import com.example.gmail.model.ItemGmailResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("inbox.json")
    fun getList(): Call<List<ItemGmailResponse>>

}