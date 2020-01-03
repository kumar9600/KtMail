package com.think42labs.ktgmail

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar
import android.net.ConnectivityManager




/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
object Constants {

    const val BASE_URL = "https://api.androidhive.info/"

    const val END_POINT = "json/inbox.json"

    fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}