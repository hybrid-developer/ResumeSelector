package com.zavaitar.hybrid.jsonresume.ui.splash.mvp

import com.zavaitar.hybrid.jsonresume.business.resume.ResumeUseCase
import com.zavaitar.hybrid.jsonresume.business.util.onDefaultSchedulers
import com.zavaitar.hybrid.jsonresume.ui.base.BaseRequestPresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val resumeUseCase: ResumeUseCase) :
        BaseRequestPresenter<SplashView>() {

    override fun start() {
        resumeUseCase.loadResume()
                .onDefaultSchedulers()
                .subscribe(
                        { view?.goToHome() },
                        { view?.displayErrorMessage(it) })
                .autoDispose()
    }
}
