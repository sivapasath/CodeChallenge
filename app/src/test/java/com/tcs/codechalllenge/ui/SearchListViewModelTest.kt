package com.tcs.codechalllenge.ui

import com.tcs.codechalllenge.model.SearchListResponse
import com.tcs.codechalllenge.services.ServiceRepository
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class SearchListViewModelTest {

    lateinit var searchListViewModel : SearchListViewModel

    @Mock
    var serviceRepository = ServiceRepository()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        searchListViewModel = SearchListViewModel()
    }

    @Test
    fun getSearchListNotEmpty() {
        val rawResponse: Response<List<SearchListResponse>> =
            serviceRepository.getSearchList("hmm").execute()

        assertTrue(rawResponse.isSuccessful)
        rawResponse.body()?.let { assertTrue(it.isNotEmpty()) }
    }
}

