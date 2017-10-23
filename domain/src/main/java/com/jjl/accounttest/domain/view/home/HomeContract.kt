package com.jjl.accounttest.domain.view.home

import com.jjl.accounttest.domain.view.Presenter
import com.jjl.accounttest.domain.view.View
import com.jjl.accounttest.domain.viewmodel.HomeListViewModel

/**
 * Created by jjimeno on 22/10/17.
 */
interface HomeContract {
    interface HomeView : View {
        fun drawElements(list: List<HomeListViewModel>)
    }

    interface HomePresenter : Presenter<HomeView>
}