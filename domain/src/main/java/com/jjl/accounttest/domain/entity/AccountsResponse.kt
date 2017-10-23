package com.jjl.accounttest.domain.entity

import com.jjl.accounttest.domain.model.Account

/**
 * Created by jjimeno on 22/10/17.
 */

enum class ResponseCode {
    OK
}

data class AccountsResponse(val accounts: List<Account>,
                            val returnCode: ResponseCode)