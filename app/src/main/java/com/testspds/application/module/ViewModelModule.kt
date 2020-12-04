package com.testspds.application.module

import androidx.lifecycle.ViewModel
import com.testspds.application.ViewModelKey
import com.testspds.viewmodel.viewmodelfactory.ListDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListDataViewModel::class)
    abstract fun bindListRetrofitViewModel(listDataViewModel: ListDataViewModel): ViewModel

}