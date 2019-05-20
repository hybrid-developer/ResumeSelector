package com.zavaitar.hybrid.jsonresume.ui.common

import android.os.Parcelable
import com.zavaitar.hybrid.jsonresume.ui.common.mvp.CommonPresenter
import com.zavaitar.hybrid.jsonresume.ui.common.mvp.CommonView
import com.zavaitar.hybrid.jsonresume.ui.main.ResumeSection
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CommonPresenterTest {

    @Mock lateinit var commonView: CommonView
    private lateinit var presenter: CommonPresenter

    @Before
    fun setUp() {
        presenter = CommonPresenter()
        presenter.onAttach(commonView)
        presenter.section = ResumeSection.SKILLS
        presenter.list = mutableListOf<Parcelable>() as ArrayList<Parcelable>
    }

    @Test
    fun onStart_whenRetrieveSelectedData_displayResumeCategories() {
        Assert.assertNotNull(presenter.section)
    }

    @Test
    fun onStart_whenRetrieveListData_displayResumeCategories() {
        Assert.assertNotNull(presenter.list)
    }
}
