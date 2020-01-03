package com.think42labs.ktgmail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.think42labs.ktgmail.net.APIService
import com.think42labs.ktgmail.ui.ListActivityViewModel
import java.lang.IllegalArgumentException


/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
open class AppViewModelFactory(var apiService: APIService) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel: ViewModel = when {
            modelClass.isAssignableFrom(ListActivityViewModel::class.java) -> ListActivityViewModel(
                apiService
            )
            modelClass.isAssignableFrom(ListActivityViewModel::class.java) -> ListActivityViewModel(
                apiService
            )
            else -> throw IllegalArgumentException("Unknown model class ${modelClass.canonicalName}")
        }
        return viewModel as T
    }

}