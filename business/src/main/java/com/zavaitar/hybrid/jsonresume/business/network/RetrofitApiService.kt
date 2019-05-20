package com.zavaitar.hybrid.jsonresume.business.network


import com.zavaitar.hybrid.jsonresume.business.data.Resume
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("/resume.json")
    fun getResume(): Single<List<Resume>>
}