package com.zavaitar.hybrid.jsonresume.business.resume

import com.zavaitar.hybrid.jsonresume.business.network.ApiService
import io.reactivex.Completable
import javax.inject.Inject

class ResumeUseCase @Inject constructor(private val api: ApiService,
                                        private val resumeRepository: ResumeRepository) {

    fun loadResume(): Completable {
        return api.getResume()
                .doOnSuccess {
                    resumeRepository.resumeData = it
                }.ignoreElement()
    }

    fun getAllResume() = resumeRepository.resumeData
}