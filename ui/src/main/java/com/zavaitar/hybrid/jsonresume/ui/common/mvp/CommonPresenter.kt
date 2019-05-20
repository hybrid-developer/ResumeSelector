package com.zavaitar.hybrid.jsonresume.ui.common.mvp

import android.os.Parcelable
import com.zavaitar.hybrid.jsonresume.ui.base.BaseRequestPresenter
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import javax.inject.Inject

interface CommonView : BaseRequestPresenter.ViewInterface {
}

class CommonPresenter @Inject constructor() : BaseRequestPresenter<CommonView>() {

    lateinit var list: ArrayList<Parcelable>
    lateinit var section: ResumeSection

    override fun start() {
        // No Implementation
    }
}