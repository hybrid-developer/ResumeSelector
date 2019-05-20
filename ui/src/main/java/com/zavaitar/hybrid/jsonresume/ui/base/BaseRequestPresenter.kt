package com.zavaitar.hybrid.jsonresume.ui.base

import io.reactivex.Completable
import io.reactivex.Single

abstract class BaseRequestPresenter<V : BaseRequestPresenter.ViewInterface> : BasePresenter<V>() {

    fun <T> Single<T>.withSpinner(): Single<T> = this
            .doOnSubscribe { view?.showLoading() }
            .doAfterTerminate { view?.hideLoading() }


    fun Completable.withSpinner(): Completable = this
            .doOnSubscribe { view?.showLoading() }
            .doAfterTerminate { view?.hideLoading() }

    interface ViewInterface : BasePresenter.ViewInterface {

        fun showLoading()

        fun hideLoading()
    }
}