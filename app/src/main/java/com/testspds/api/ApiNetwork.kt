package com.testspds.api

import com.testspds.model.TestData
import com.testspds.utils.GET_DATA
import retrofit2.Call
import retrofit2.http.GET

interface ApiNetwork {

    @GET(GET_DATA)
    fun getListData():Call<TestData>
}