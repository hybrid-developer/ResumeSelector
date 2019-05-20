package com.zavaitar.hybrid.jsonresume.ui.splash.mvp

import com.zavaitar.hybrid.jsonresume.ui.base.BaseRequestPresenter

interface SplashView: BaseRequestPresenter.ViewInterface {

    fun displayErrorMessage(e: Throwable)

    fun goToHome()
}