package com.jjl.accounttest.domain.view.accountList

import com.jjl.accounttest.domain.usecase.accounts.GetAccounts
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

/**
 * Created by jjimeno on 22/10/17.
 */
class AccountListPresenter(override val view: AccountListContract.AccountListView,
                           val getAccountsUseCase: GetAccounts) : AccountListContract.AccountListPresenter {

    override fun start() {
        super.start()
        queryAccounts()
    }

    private fun queryAccounts() {
        view.showLoading()
        async(CommonPool) {
            try {
                val accounts = getAccountsUseCase.perform(null).await()
                async(UI) {
                    view.hideLoading()
                    view.drawAccounts(accounts)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}