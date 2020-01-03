package com.think42labs.ktgmail.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.think42labs.ktgmail.Constants
import com.think42labs.ktgmail.KtMail
import com.think42labs.ktgmail.LiveEvent
import com.think42labs.ktgmail.net.APIService
import com.think42labs.ktgmail.net.Response
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Timed


/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
open class ListActivityViewModel(var apiService: APIService) : ViewModel() {

    var error = LiveEvent<String>()

    var inboxList: MutableLiveData<List<Response>> = MutableLiveData()

    init {
        getMailList()
    }

    @SuppressLint("CheckResult")
    private fun getMailList() {

        if (!Constants.isNetworkAvailable(KtMail.getContext()!!)) {
            error.postValue("Network not available")
            return
        }

        apiService.getInboxList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Response>> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<Response>) {
                    when {
                        t.isNotEmpty() -> inboxList.postValue(t)
                        else -> error.postValue("Something went wrong")
                    }
                }

                override fun onError(e: Throwable) {
                    error.postValue("Something went wrong")
                }

            })
    }

    fun showSnackBar() {
        error.postValue("Single Live event working fine")
    }
}