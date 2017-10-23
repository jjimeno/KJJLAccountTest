package com.jjl.accounttest.domain.view.accountList

import com.jjl.accounttest.domain.model.Account
import com.jjl.accounttest.domain.view.LoadingView
import com.jjl.accounttest.domain.view.Presenter

/**
 * Created by jjimeno on 22/10/17.
 */
interface AccountListContract {

    interface AccountListView : LoadingView {
        fun drawAccounts(account: List<Account>)
    }

    interface AccountListPresenter : Presenter<AccountListView>
}