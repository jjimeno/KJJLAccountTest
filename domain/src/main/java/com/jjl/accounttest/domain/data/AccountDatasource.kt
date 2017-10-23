package com.jjl.accounttest.domain.data

import com.jjl.accounttest.domain.model.Account

/**
 * Created by jjimeno on 22/10/17.
 */
interface AccountDatasource {
    fun getAccounts(): List<Account>
}