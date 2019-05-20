package com.zavaitar.hybrid.jsonresume.business

import com.nhaarman.mockito_kotlin.whenever
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.network.ApiService
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeRepository
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeUseCase
import com.zavaitar.hybrid.jsonresume.business.util.RxOverrideSchedulersRule
import io.reactivex.Single
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResumeUseCaseTest {

    @Rule
    @JvmField
    val rxRule = RxOverrideSchedulersRule()

    @Mock lateinit var resumeRepository: ResumeRepository
    @Mock lateinit var api: ApiService

    private lateinit var resumeUseCase: ResumeUseCase

    @Before
    fun setUp() {
        resumeUseCase = ResumeUseCase(api, resumeRepository)
    }

    @Test
    fun loadResume_whereApiResponse_returns_Completable() {
        val resumeList = listOf<Resume>()

        whenever(api.getResume()).thenReturn(Single.just(resumeList))
        whenever(resumeRepository.resumeData).thenReturn(resumeList)
        resumeUseCase.loadResume().test()

        assertEquals(resumeList, resumeRepository.resumeData)
    }

    @Test
    fun getAllResume_whereRepository_returns_resumeList() {
        val resumeList = listOf<Resume>()
        whenever(resumeRepository.resumeData).thenReturn(resumeList)

        assertEquals(resumeList, resumeUseCase.getAllResume())
    }
}