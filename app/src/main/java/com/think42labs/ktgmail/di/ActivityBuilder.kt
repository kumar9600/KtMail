package com.task.di

import com.think42labs.ktgmail.ui.InboxActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun buildInboxActivity(): InboxActivity
}
