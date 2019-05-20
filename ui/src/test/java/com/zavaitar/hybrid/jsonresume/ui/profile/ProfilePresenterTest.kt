package com.zavaitar.hybrid.jsonresume.ui.profile

import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfilePresenter
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfileView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProfilePresenterTest {

    @Mock lateinit var profileView: ProfileView
    private lateinit var presenter: ProfilePresenter

    @Before
    fun setUp() {
        presenter = ProfilePresenter()
        presenter.onAttach(profileView)
        presenter.resume = mock(Resume::class.java)
    }

    @Test
    fun onStart_whenRetrieveSelectedResume_displayResumeCategories() {
        Assert.assertNotNull(presenter.resume)
    }
}