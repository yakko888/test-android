package com.testspds

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.testspds.databinding.MainActivityBinding
import com.testspds.ui.main.MainFragment
import com.testspds.viewmodel.repository.DataRepository
import com.testspds.viewmodel.viewmodelfactory.CustomViewModelFactory
import com.testspds.viewmodel.viewmodelfactory.ListDataViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@Suppress("DEPRECATION")
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var dataRepository: DataRepository

    @Inject
    lateinit var viewCustomModelFactory: CustomViewModelFactory
    var dataViewModel: ListDataViewModel?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        binding.listDataViewModel =ListDataViewModel( dataRepository,this)
        dataViewModel = ViewModelProviders.of(this,viewCustomModelFactory).get(ListDataViewModel::class.java)

        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
