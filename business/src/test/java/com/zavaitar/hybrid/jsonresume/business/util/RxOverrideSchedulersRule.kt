package com.zavaitar.hybrid.jsonresume.business.util

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.Callable

class RxOverrideSchedulersRule : TestRule {

    private val rxHandler = Function<Scheduler, Scheduler> { Schedulers.trampoline() }

    private val androidHandler = Function<Callable<Scheduler>, Scheduler> { Schedulers.trampoline() }

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxAndroidPlugins.reset()
                RxJavaPlugins.reset()

                RxAndroidPlugins.setInitMainThreadSchedulerHandler(androidHandler)
                RxJavaPlugins.setIoSchedulerHandler(rxHandler)
                RxJavaPlugins.setComputationSchedulerHandler(rxHandler)

                base.evaluate()

                RxAndroidPlugins.reset()
                RxJavaPlugins.reset()
            }
        }
    }
}