package com.tcs.codechalllenge.services

import com.tcs.codechalllenge.model.SearchListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("dictionary.py")
    fun getSearchData(@Query("sf") sf: String): Call<List<SearchListResponse>>
}