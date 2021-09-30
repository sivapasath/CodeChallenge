package com.tcs.codechalllenge.model

data class SearchSubListResponse(
    val lf: String,
    val freq: String,
    val since: String,
    val vars: ArrayList<SearchSubListResponse>
)