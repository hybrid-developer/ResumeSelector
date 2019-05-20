package com.zavaitar.hybrid.jsonresume.business.core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

fun LifecycleOwner.registerPresenterForLifecycle(presenter: LifecycleAwarePresenter) {
    lifecycle.addObserver(object : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume() {
            presenter.start()
        }
    })
}

interface LifecycleAwarePresenter {
    fun start()
}