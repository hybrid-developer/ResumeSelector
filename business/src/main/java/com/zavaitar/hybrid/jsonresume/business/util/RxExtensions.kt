package com.zavaitar.hybrid.jsonresume.business.util

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Iterable<T>.toObservable() = Observable.fromIterable(this)

fun <T> Single<T>.onDefaultSchedulers(): Single<T> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun Completable.onDefaultSchedulers(): Completable =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.onDefaultSchedulers(): Observable<T> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Flowable<T>.onDefaultSchedulers(): Flowable<T> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.onDefaultSchedulers(): Maybe<T> =
        subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())