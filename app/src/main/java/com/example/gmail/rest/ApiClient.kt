package com.example.gmail.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
   const val BASE_URL = "https://api.androidhive.info/json/"
   private var retrofit: Retrofit? = null
   val client: Retrofit?
      get() {
         if (retrofit == null) {
            retrofit = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
         }
         return retrofit
      }
}