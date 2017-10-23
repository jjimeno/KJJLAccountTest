package com.jjl.accounttest.domain.usecase.accounts

import com.jjl.accounttest.domain.data.AccountRepository
import com.jjl.accounttest.domain.model.Account
import com.jjl.accounttest.domain.usecase.UseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

/**
 * Created by jjimeno on 22/10/17.
 */

open class GetAccounts(private val repo: AccountRepository) : UseCase<Nothing, List<Account>> {
    override fun perform(input: Nothing?): Deferred<List<Account>> {
        val job = async(CommonPool) {
            repo.getAccounts().await()
        }
        return job
    }
}