package com.testspds.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.testspds.R
import com.testspds.adapter.ListDataAdapter
import com.testspds.databinding.MainFragmentBinding
import com.testspds.viewmodel.repository.DataRepository
import com.testspds.viewmodel.viewmodelfactory.CustomViewModelFactory
import com.testspds.viewmodel.viewmodelfactory.ListDataViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var dataRepository: DataRepository

    @Inject
    lateinit var viewCustomModelFactory: CustomViewModelFactory
    var dataFullViewModel: ListDataViewModel?=null

    private lateinit var dataListAdapter: ListDataAdapter

    companion object {
        fun newInstance() = MainFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: MainFragmentBinding = DataBindingUtil.setContentView(getActivity()!!, R.layout.main_fragment)
        binding.listDataViewModel =ListDataViewModel( dataRepository, activity!!)
        dataFullViewModel = ViewModelProviders.of(this,viewCustomModelFactory).get(ListDataViewModel::class.java)

        binding.recyclerViewSearchResults.layoutManager = LinearLayoutManager(activity)
        dataListAdapter = ListDataAdapter()
        binding.recyclerViewSearchResults.adapter = dataListAdapter

        dataFullViewModel!!.getListData().observe(this, Observer {

            dataListAdapter.setAllDataItems(it)

        })

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    //TODO load items from https://public-api.wordpress.com/rest/v1/freshly-pressed?number=30
    // and display the "Featured Image" for each post that has one

}
