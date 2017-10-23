package com.jjl.jjlaccounttestandroid.view.accountList

import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.jjl.accounttest.domain.data.datasource.DefaultAccountDatasource
import com.jjl.accounttest.domain.data.repository.DefaultAccountRepository
import com.jjl.accounttest.domain.model.Account
import com.jjl.accounttest.domain.usecase.accounts.GetAccounts
import com.jjl.accounttest.domain.usecase.accounts.GetAccountsVisible
import com.jjl.accounttest.domain.view.accountList.AccountListContract
import com.jjl.accounttest.domain.view.accountList.AccountListPresenter
import com.jjl.jjlaccounttest.nativelibs.AndroidFileProvider
import com.jjl.jjlaccounttestandroid.R
import com.jjl.jjlaccounttestandroid.view.BaseActivity
import com.pedrogomez.renderers.ListAdapteeCollection
import com.pedrogomez.renderers.RVRendererAdapter
import com.pedrogomez.renderers.RendererBuilder
import kotlinx.android.synthetic.main.activity_account_list.*

open abstract class AccountListActivity : BaseActivity<AccountListContract.AccountListView, AccountListContract.AccountListPresenter>(), AccountListContract.AccountListView {

    abstract fun provideUseCase(): GetAccounts

    override fun getLayoutRes(): Int {
        return R.layout.activity_account_list
    }

    override fun providePresenter(): AccountListContract.AccountListPresenter {
        return AccountListPresenter(this, provideUseCase())
    }

    override fun configureViews() {
        super.configureViews()
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    // View
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun drawAccounts(accounts: List<Account>) {
        val renderer = AccountRenderer()
        val rendererBuilder = RendererBuilder(renderer)
        recyclerview.adapter = RVRendererAdapter(rendererBuilder, ListAdapteeCollection(accounts))

    }
}

class AccountListUnfilteredActivity : AccountListActivity() {
    override fun provideUseCase(): GetAccounts {
        return GetAccounts(DefaultAccountRepository(DefaultAccountDatasource(Gson(), AndroidFileProvider(this))))
    }
}

class AccountListVisibleActivity : AccountListActivity() {
    override fun provideUseCase(): GetAccounts {
        return GetAccountsVisible(DefaultAccountRepository(DefaultAccountDatasource(Gson(), AndroidFileProvider(this))))
    }
}
