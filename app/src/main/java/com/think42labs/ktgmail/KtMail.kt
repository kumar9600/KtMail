package com.think42labs.ktgmail

import android.app.Activity
import android.content.Context
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import com.task.di.DaggerAppComponent
import com.task.di.AppComponent
import dagger.android.AndroidInjector


/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
open class KtMail : DaggerApplication() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: KtMail? = null

        fun getContext(): Context? {
            return instance!!.applicationContext
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        val appComponent: AppComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }
}