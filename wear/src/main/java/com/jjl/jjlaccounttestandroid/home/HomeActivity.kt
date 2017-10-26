package com.jjl.jjlaccounttestandroid.home

import android.content.Intent
import com.jjl.accounttest.domain.view.home.HomeContract
import com.jjl.accounttest.domain.view.home.HomePresenter
import com.jjl.accounttest.domain.viewmodel.HomeListViewModel
import com.jjl.accounttest.domain.viewmodel.HomeType
import com.jjl.jjlaccounttest.nativelibs.AndroidTextProvider
import com.jjl.jjlaccounttestandroid.R
import com.jjl.jjlaccounttestandroid.WearBaseActivity
import com.jjl.jjlaccounttestandroid.accountList.AccountListUnfilteredActivity
import com.jjl.jjlaccounttestandroid.accountList.AccountListVisibleActivity
import com.pedrogomez.renderers.ListAdapteeCollection
import com.pedrogomez.renderers.RendererAdapter
import com.pedrogomez.renderers.RendererBuilder
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : WearBaseActivity<HomeContract.HomeView, HomeContract.HomePresenter>(), HomeContract.HomeView {
    override fun getLayoutRes(): Int {
        return R.layout.activity_home
    }

    override fun providePresenter(): HomeContract.HomePresenter {
        return HomePresenter(this, AndroidTextProvider(this))
    }

    override fun configureViews() {
        super.configureViews()
    }

    //VIEW
    override fun drawElements(list: List<HomeListViewModel>) {
        val renderer = HomeViewModelRenderer(listener = { homeListViewModel -> showFilter(homeListViewModel.homeType) })
        val rendererBuilder = RendererBuilder(renderer)

        listview.adapter = RendererAdapter(rendererBuilder, ListAdapteeCollection(list))
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
