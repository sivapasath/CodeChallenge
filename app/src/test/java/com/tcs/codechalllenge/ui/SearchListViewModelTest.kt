package com.tcs.codechalllenge.ui

import com.tcs.codechalllenge.services.ServiceRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

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
    fun getSearchList() {
       `when`(searchListViewModel.getSearchList("hmm")).thenReturn(any())

        searchListViewModel.getSearchList("hmm")

        verify(searchListViewModel.getSearchList("hmm"))
    }
}

