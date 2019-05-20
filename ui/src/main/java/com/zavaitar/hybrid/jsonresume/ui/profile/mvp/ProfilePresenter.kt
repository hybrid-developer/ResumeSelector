package com.zavaitar.hybrid.jsonresume.ui.profile.mvp

import android.os.Parcelable
import com.zavaitar.hybrid.jsonresume.business.data.*
import com.zavaitar.hybrid.jsonresume.ui.base.BaseRequestPresenter
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import javax.inject.Inject

interface ProfileView : BaseRequestPresenter.ViewInterface {
    fun displayResumeCategories()

    fun displayProfileData(basics: Basics)

    fun displayCategory(list: List<out Parcelable>, resumeSection: ResumeSection)
}

class ProfilePresenter @Inject constructor() : BaseRequestPresenter<ProfileView>() {
    lateinit var resume: Resume
    override fun start() {
        view!!.displayResumeCategories()
        view!!.displayProfileData(resume.basics)
    }

    fun displaySelectedCategoryPage(selectedCategoryId: Int) {
        val resumeSection = ResumeSection.values()[selectedCategoryId]
        when (selectedCategoryId) {
            0 -> view!!.displayCategory(resume.work, resumeSection)
            1 -> view!!.displayCategory(resume.education, resumeSection)
            2 -> view!!.displayCategory(resume.skills, resumeSection)
            3 -> view!!.displayCategory(resume.publications, resumeSection)
            4 -> view!!.displayCategory(resume.references, resumeSection)
        }
    }
}
