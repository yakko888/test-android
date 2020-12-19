package com.testspds.viewmodel.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.testspds.api.ApiNetwork
import com.testspds.model.TestData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class DataRepository @Inject constructor(val retrofit: Retrofit, val context: Context) {

    fun getListData(): LiveData<TestData> {

        val listData: MutableLiveData<TestData> = MutableLiveData()
        val call: Call<TestData> = retrofit.create(ApiNetwork::class.java).getListData()
        call.enqueue(object : Callback<TestData> {
            override fun onFailure(call: Call<TestData>, t: Throwable) {
                listData.postValue(null)
            }

            override fun onResponse(
                call: Call<TestData>,
                response: Response<TestData>
            ) {
                listData.value = response.body()
            }
        })
        return listData
    }
}