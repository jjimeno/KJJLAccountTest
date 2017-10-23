package com.jjl.accounttest.domain.data.datasource

import com.google.gson.Gson
import com.jjl.accounttest.domain.data.AccountDatasource
import com.jjl.accounttest.domain.entity.AccountsResponse
import com.jjl.accounttest.domain.lib.FileProvider
import com.jjl.accounttest.domain.model.Account

/**
 * Created by jjimeno on 22/10/17.
 */
class DefaultAccountDatasource(private val gson: Gson, private val fileProvider: FileProvider) : AccountDatasource {

    override fun getAccounts(): List<Account> {
        val json = fileProvider.readFullFileWithName("response.json")
        return gson.fromJson(json, AccountsResponse::class.java).accounts
    }
}