package com.tcs.codechalllenge.services

import com.tcs.codechalllenge.model.SearchListResponse
import retrofit2.Call

open class ServiceRepository {

    fun getSearchList(sf: String): Call<List<SearchListResponse>> {
        return ApiClient.getService().getSearchData(sf)
    }
}