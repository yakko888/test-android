package com.testspds.viewmodel.viewmodelfactory

import android.content.Context
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testspds.model.TestData
import com.testspds.viewmodel.repository.DataRepository
import javax.inject.Inject

class ListDataViewModel @Inject constructor(private val dataRepository: DataRepository, private val context: Context):
    ViewModel(), Observable {

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    fun getListData(): LiveData<TestData> {

        return dataRepository.getListData()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }
}