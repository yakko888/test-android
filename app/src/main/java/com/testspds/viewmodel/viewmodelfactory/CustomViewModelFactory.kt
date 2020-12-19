package com.testspds.viewmodel.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testspds.viewmodel.repository.DataRepository

import javax.inject.Inject

class CustomViewModelFactory @Inject constructor(private val dataRepository: DataRepository?, private val context: Context):ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(ListDataViewModel::class.java)){
            return ListDataViewModel(dataRepository!!, context) as T
        }else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }
}