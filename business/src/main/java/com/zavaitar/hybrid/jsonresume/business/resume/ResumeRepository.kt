package com.zavaitar.hybrid.jsonresume.business.resume

import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.business.injection.SessionScope
import javax.inject.Inject

@SessionScope
class ResumeRepository @Inject constructor() {

    var resumeData = listOf<Resume>()

    operator fun get(id: Int) = resumeData[id]
}