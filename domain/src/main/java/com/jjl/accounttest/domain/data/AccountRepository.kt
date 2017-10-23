package com.jjl.accounttest.domain.data

import com.jjl.accounttest.domain.model.Account
import kotlinx.coroutines.experimental.Deferred

/**
 * Created by jjimeno on 22/10/17.
 */
interface AccountRepository {
    fun getAccounts(): Deferred<List<Account>>
}