package com.tcs.codechalllenge.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getService(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://www.nactem.ac.uk/software/acromine/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}