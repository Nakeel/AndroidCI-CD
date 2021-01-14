package com.nakeeljr.circleci

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nakeeljr.circleci.models.MovieModel
import com.nakeeljr.circleci.viewmodel.MainActivityViewModel
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainActivityViewModelTest {

    private lateinit var mMainViewModel : MainActivityViewModel
    private val list = ArrayList<MovieModel>()

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        mMainViewModel = MainActivityViewModel()
    }

    @Test
    fun testWhenLiveDataIsUpdated_NewDataAdded() {
        list.add(MovieModel("","",""))
        mMainViewModel.setMovieLiveData(list)
        Assert.assertEquals(mMainViewModel.getMovieLiveData().value!!.size,1)
    }
}