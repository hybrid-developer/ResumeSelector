package com.zavaitar.hybrid.jsonresume.business.network

import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.injection.AppScope
import io.reactivex.Single
import javax.inject.Inject

@AppScope
open class ApiServiceImpl @Inject constructor(
        private val retrofitApiService: RetrofitApiService) : ApiService {

    override fun getResume(): Single<List<Resume>> {
       return retrofitApiService.getResume()
    }
}