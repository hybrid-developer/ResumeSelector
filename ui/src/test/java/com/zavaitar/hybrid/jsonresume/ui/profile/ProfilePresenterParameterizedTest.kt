package com.zavaitar.hybrid.jsonresume.ui.profile

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.zavaitar.hybrid.jsonresume.business.data.Resume
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfilePresenter
import com.zavaitar.hybrid.jsonresume.ui.profile.mvp.ProfileView
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.mockito.Mockito.anyList
import org.mockito.Mockito.mock

@RunWith(Parameterized::class)
class ProfilePresenterParameterizedTest(private val selectedCategoryId: Int) {

    companion object {
        @JvmStatic
        @Parameters
        fun selectedCategoryId(): List<Int> {
            return (0..4).toList()
        }
    }

    private lateinit var profileView: ProfileView
    private lateinit var presenter: ProfilePresenter

    @Before
    fun setUp() {
        presenter = ProfilePresenter()
        profileView = mock(ProfileView::class.java)
        presenter.onAttach(profileView)
        presenter.resume = mock(Resume::class.java)
    }

    @Test
    fun onDisplaySelectedCategoryPage_whenCategoryIsSelected_showCorrectPage() {
        presenter.displaySelectedCategoryPage(selectedCategoryId)
        when(selectedCategoryId) {
            0 -> verify(profileView).displayCategory(anyList(), any())
            1 -> verify(profileView).displayCategory(anyList(), any())
            2 -> verify(profileView).displayCategory(anyList(), any())
            3 -> verify(profileView).displayCategory(anyList(), any())
            4 -> verify(profileView).displayCategory(anyList(), any())
        }
    }
}