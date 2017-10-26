package com.jjl.jjlaccounttestandroid.home

import com.jjl.accounttest.domain.viewmodel.HomeListViewModel
import com.jjl.jjlaccounttestandroid.R
import kotlinx.android.synthetic.main.home_list_item.view.*
import view.BaseRenderer

/**
 * Created by jjimeno on 25/10/17.
 */

class HomeViewModelRenderer(listener: (HomeListViewModel) -> Unit) : BaseRenderer<HomeListViewModel>(listener) {
    override fun getContentView(): Int {
        return R.layout.home_list_item
    }

    override fun draw() {

        rootView.textview.text = content.text
    }
}