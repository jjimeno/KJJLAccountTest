package com.jjl.jjlaccounttestandroid.view.home

import com.jjl.accounttest.domain.viewmodel.HomeListViewModel
import com.jjl.jjlaccounttestandroid.R
import com.jjl.jjlaccounttestandroid.view.BaseRenderer

import kotlinx.android.synthetic.main.home_list_item.view.*

/**
 * Created by jjimeno on 23/10/17.
 */
class HomeViewModelRenderer(listener: (HomeListViewModel) -> Unit) : BaseRenderer<HomeListViewModel>(listener) {
    override fun getContentView(): Int {
        return R.layout.home_list_item
    }

    override fun draw() {

        rootView.textview.text = content.text
    }
}