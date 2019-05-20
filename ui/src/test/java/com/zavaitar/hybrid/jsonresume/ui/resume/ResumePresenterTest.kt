package com.zavaitar.hybrid.jsonresume.ui.resume

import com.nhaarman.mockito_kotlin.whenever
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeUseCase
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumePresenter
import com.zavaitar.hybrid.jsonresume.ui.resume.mvp.ResumeView
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResumePresenterTest {

    @Mock lateinit var resumeUseCase: ResumeUseCase
    @Mock lateinit var resumeView: ResumeView

    private lateinit var presenter: ResumePresenter

    @Before
    fun setUp() {
        presenter = ResumePresenter(resumeUseCase)
        presenter.onAttach(resumeView)
    }

    @Test
    fun onStart_whenDataLoad_loadAllResumeDataList_notNull() {
        whenever(resumeUseCase.getAllResume()).thenReturn(listOf())

        presenter.start()

        assertNotNull(resumeView.list)
    }

    @Test
    fun onStart_whenDataLoad_loadAllResumeDataList() {
        val resumeList = listOf<Resume>()
        whenever(resumeUseCase.getAllResume()).thenReturn(resumeList)

        presenter.start()

        assertEquals(resumeList, resumeView.list)
    }
}