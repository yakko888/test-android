package com.testspds.application.module

import com.testspds.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class, FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}