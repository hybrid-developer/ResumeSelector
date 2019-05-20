package com.zavaitar.hybrid.jsonresume.business.network

import com.zavaitar.hybrid.jsonresume.business.data.Resume
import io.reactivex.Single

interface ApiService {

    fun getResume(): Single<List<Resume>>
}