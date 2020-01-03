package com.think42labs.ktgmail.net

import com.think42labs.ktgmail.Constants
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */

interface APIService {

    @GET(Constants.END_POINT)
    fun getInboxList(): Observable<List<Response>>
}