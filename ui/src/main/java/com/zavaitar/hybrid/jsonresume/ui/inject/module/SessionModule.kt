package com.zavaitar.hybrid.jsonresume.ui.inject.module

import com.zavaitar.hybrid.jsonresume.business.injection.RetrofitApiFactory
import com.zavaitar.hybrid.jsonresume.business.injection.SessionScope
import com.zavaitar.hybrid.jsonresume.business.network.ApiService
import com.zavaitar.hybrid.jsonresume.business.network.ApiServiceImpl
import com.zavaitar.hybrid.jsonresume.business.network.RetrofitApiService
import com.zavaitar.hybrid.jsonresume.ui.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class SessionModule {

    @Provides
    fun providesRetrofitApiFactory(): RetrofitApiFactory {
        return RetrofitApiFactory()
    }

    @SessionScope
    @Provides
    fun provideRetrofitApiService(retrofitApiFactory: RetrofitApiFactory): RetrofitApiService {
        return retrofitApiFactory.create(Constants.BASE_URL)
                .create(RetrofitApiService::class.java)
    }

    @SessionScope
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @SessionScope
    @Provides
    fun provideApiService(api: RetrofitApiService): ApiService {
        return ApiServiceImpl(api)
    }
}