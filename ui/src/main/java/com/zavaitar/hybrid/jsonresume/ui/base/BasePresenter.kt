package com.zavaitar.hybrid.jsonresume.ui.base

import androidx.annotation.CallSuper
import com.zavaitar.hybrid.jsonresume.business.core.LifecycleAwarePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<T : BasePresenter.ViewInterface> : LifecycleAwarePresenter {

    private val subscription: CompositeDisposable = CompositeDisposable()

    protected var view: T? = null

    @CallSuper
    open fun onAttach(view: T) {
        this.view = view
    }

    @CallSuper
    open fun onDetach(view: T) {
        subscription.clear()
        this.view = null
    }


    open fun addSubscription(disposable: Disposable) {
        subscription.add(disposable)
    }

    protected fun Disposable.autoDispose(): Disposable = apply { subscription.add(this) }


    interface ViewInterface {
        //No Implementations. Using as a marker interface.
    }
}