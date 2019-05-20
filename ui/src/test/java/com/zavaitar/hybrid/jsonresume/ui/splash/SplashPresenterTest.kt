package com.zavaitar.hybrid.jsonresume.ui.splash

import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.whenever
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeUseCase
import com.zavaitar.hybrid.jsonresume.ui.util.RxOverrideSchedulersRule
import com.zavaitar.hybrid.jsonresume.ui.splash.mvp.SplashPresenter
import com.zavaitar.hybrid.jsonresume.ui.splash.mvp.SplashView
import io.reactivex.Completable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashPresenterTest {

    @Rule
    @JvmField
    val rxRule = RxOverrideSchedulersRule()

    @Mock lateinit var resumeUseCase: ResumeUseCase
    @Mock lateinit var splashView: SplashView

    private lateinit var presenter: SplashPresenter

    @Before
    fun setUp() {
        presenter = SplashPresenter(resumeUseCase)
        presenter.onAttach(splashView)
    }

    @Test
    fun onStart_whenLoadData_prefetch_goToHomeScreen() {

        whenever(resumeUseCase.loadResume()).thenReturn(Completable.complete())

        presenter.start()

        verify(splashView).goToHome()
        verify(splashView, never()).displayErrorMessage(IllegalStateException())
    }

    @Test
    fun onStart_whenLoadData_prefetch_displayErrorMessage() {

        val error = IllegalStateException()

        whenever(resumeUseCase.loadResume()).thenReturn(Completable.error(error))

        presenter.start()

        verify(splashView).displayErrorMessage(error)
        verify(splashView, never()).goToHome()
    }
}