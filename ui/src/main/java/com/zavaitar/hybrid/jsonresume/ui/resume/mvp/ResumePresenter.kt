package com.zavaitar.hybrid.jsonresume.ui.resume.mvp

import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.resume.ResumeUseCase
import com.zavaitar.hybrid.jsonresume.ui.base.BaseRequestPresenter
import javax.inject.Inject

interface ResumeView: BaseRequestPresenter.ViewInterface {
    var list: List<Resume>
}

class ResumePresenter @Inject constructor(private val resumeUseCase: ResumeUseCase) :
        BaseRequestPresenter<ResumeView>() {

    override fun start() {
        view?.list = resumeUseCase.getAllResume()
    }
}

interface ResumeItemClickListener {
   fun onResumeItemClickListener(resume: Resume)
}