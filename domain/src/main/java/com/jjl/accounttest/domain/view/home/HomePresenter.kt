package com.jjl.accounttest.domain.view.home

import com.jjl.accounttest.domain.lib.TextKeys
import com.jjl.accounttest.domain.lib.TextProvider
import com.jjl.accounttest.domain.viewmodel.HomeListViewModel
import com.jjl.accounttest.domain.viewmodel.HomeType

/**
 * Created by jjimeno on 22/10/17.
 */
class HomePresenter(override val view: HomeContract.HomeView, val textProvider: TextProvider) : HomeContract.HomePresenter {
    override fun start() {
        super.start()
        getList()
    }

    fun getList() {
        val homeList = arrayListOf<HomeListViewModel>(
                HomeListViewModel(HomeType.DEFAULT, textProvider.provideText(TextKeys.HOME_LIST_DEFAULT_SEARCH.name)),
                HomeListViewModel(HomeType.ONLY_VISIBLE, textProvider.provideText(TextKeys.HOME_LIST_VISIBLE_SEARCH.name))
        )
        view.drawElements(homeList)
    }
}