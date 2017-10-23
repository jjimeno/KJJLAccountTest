package com.jjl.accounttest.domain.usecase.accounts

import com.jjl.accounttest.domain.data.AccountRepository
import com.jjl.accounttest.domain.model.Account
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

/**
 * Created by jjimeno on 22/10/17.
 */
class GetAccountsVisible(repo: AccountRepository) : GetAccounts(repo) {
    override fun perform(input: Nothing?): Deferred<List<Account>> {
        return async(CommonPool) {
            super.perform(input)
                    .await()
                    .filter { account -> account.isVisible }
        }
    }
}