package com.jjl.jjlaccounttestandroid.view.accountList

import com.jjl.accounttest.domain.model.Account
import com.jjl.jjlaccounttestandroid.R
import kotlinx.android.synthetic.main.account_list_item.view.*
import view.BaseRenderer

/**
 * Created by jjimeno on 23/10/17.
 */
class AccountRenderer : BaseRenderer<Account>() {
    override fun getContentView(): Int {
        return R.layout.account_list_item
    }

    override fun draw() {
        rootView.tvAccountBalanceValue.text = content.accountBalanceInCents.toString()
        rootView.tvAccountIbanValue.text = content.iban
        rootView.tvAccountNameValue.text = content.accountName
        rootView.tvAccountNumberValue.text = content.accountNumber
    }
}