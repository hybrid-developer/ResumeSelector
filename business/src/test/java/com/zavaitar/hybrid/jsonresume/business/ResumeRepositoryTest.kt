package com.zavaitar.hybrid.jsonresume.business

import com.nhaarman.mockito_kotlin.whenever
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeRepository
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResumeRepositoryTest {

    private lateinit var resumeRepository: ResumeRepository
    private var resumeList = mutableListOf<Resume>()

    @Mock lateinit var resume: Resume

    @Before
    fun setUp() {
        resumeRepository = ResumeRepository()
        resumeList.add(resume)
        resumeRepository.resumeData = resumeList
    }

    @Test
    fun getAllResumeData_whenRequested() {
        assertEquals(resume, resumeRepository[0])
    }

    @Test
    fun getResumeDataForIndex_whenRequested() {
        whenever(resume.id).thenReturn(2)
        assertEquals(2, resumeRepository[0].id)
    }
}