package com.jjl.accounttest.domain.data.repository

import com.jjl.accounttest.domain.data.AccountDatasource
import com.jjl.accounttest.domain.data.AccountRepository
import com.jjl.accounttest.domain.model.Account
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

/**
 * Created by jjimeno on 22/10/17.
 */
class DefaultAccountRepository(private val dataSource: AccountDatasource) : AccountRepository {
    override fun getAccounts(): Deferred<List<Account>> {
        return async(CommonPool) {
            dataSource.getAccounts()
        }
    }
}