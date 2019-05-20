package com.zavaitar.hybrid.jsonresume.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.zavaitar.hybrid.jsonresume.ui.inject.component.ActivityComponent
import com.zavaitar.hybrid.jsonresume.ui.inject.component.DaggerActivityComponent
import com.zavaitar.hybrid.jsonresume.ui.inject.module.ActivityModule

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    internal fun getActivityComponent(): ActivityComponent {
        return DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()
    }
}