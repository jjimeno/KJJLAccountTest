package com.jjl.jjlaccounttestandroid.view.home

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.jjl.accounttest.domain.view.home.HomeContract
import com.jjl.accounttest.domain.view.home.HomePresenter
import com.jjl.accounttest.domain.viewmodel.HomeListViewModel
import com.jjl.accounttest.domain.viewmodel.HomeType
import com.jjl.jjlaccounttest.nativelibs.AndroidTextProvider
import com.jjl.jjlaccounttestandroid.R
import com.jjl.jjlaccounttestandroid.view.BaseActivity
import com.jjl.jjlaccounttestandroid.view.accountList.AccountListUnfilteredActivity
import com.jjl.jjlaccounttestandroid.view.accountList.AccountListVisibleActivity
import com.pedrogomez.renderers.ListAdapteeCollection
import com.pedrogomez.renderers.RVRendererAdapter
import com.pedrogomez.renderers.RendererBuilder
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeContract.HomeView, HomePresenter>(), HomeContract.HomeView {

    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun providePresenter(): HomePresenter {
        return HomePresenter(this, AndroidTextProvider(this))
    }

    override fun configureViews() {
        val linManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = linManager
    }

    override fun drawElements(list: List<HomeListViewModel>) {
        val renderer = HomeViewModelRenderer(listener = { homeListViewModel -> showFilter(homeListViewModel.homeType) })
        val rendererBuilder = RendererBuilder(renderer)
        recyclerview.adapter = RVRendererAdapter(rendererBuilder, ListAdapteeCollection(list))
    }

    private fun showFilter(homeType: HomeType) {
        when (homeType) {
            HomeType.DEFAULT -> openIntent(Intent(this, AccountListUnfilteredActivity::class.java))
            HomeType.ONLY_VISIBLE -> openIntent(Intent(this, AccountListVisibleActivity::class.java))
        }
    }

    private fun openIntent(intent: Intent) {
        startActivity(intent)
    }
}
