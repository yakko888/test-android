package com.testspds.application

import android.app.Application
import com.testspds.application.module.ActivityBuildersModule
import com.testspds.application.module.ContextModule
import com.testspds.application.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContextModule::class,
        NetworkModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<MasterApp> {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}