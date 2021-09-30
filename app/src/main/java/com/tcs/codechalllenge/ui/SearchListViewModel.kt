package com.tcs.codechalllenge.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcs.codechalllenge.model.SearchListResponse
import com.tcs.codechalllenge.model.SearchSubListResponse
import com.tcs.codechalllenge.services.ServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class SearchListViewModel : ViewModel() {

    var mSearchList = MutableLiveData<List<SearchSubListResponse>>()
    var errorResponse = MutableLiveData<Boolean>(false)
    private var serviceRepository : ServiceRepository = ServiceRepository()

    fun getSearchList(sf: String) {
        serviceRepository.getSearchList(sf).enqueue(object : Callback<List<SearchListResponse>> {
            override fun onResponse(
                call: Call<List<SearchListResponse>>,
                response: Response<List<SearchListResponse>>
            ) {
                var lfList: List<SearchSubListResponse> = arrayListOf()
                response.body().let {
                    if (it != null && it.isNotEmpty()) {
                        lfList = it[0].lfs
                    }
                }
                mSearchList.postValue(lfList)
            }

            override fun onFailure(call: Call<List<SearchListResponse>>, t: Throwable) {
                errorResponse.postValue(true)
            }
        })
    }

}