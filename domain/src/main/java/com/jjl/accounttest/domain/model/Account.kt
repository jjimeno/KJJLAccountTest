package com.jjl.accounttest.domain.model

/**
 * Created by jjimeno on 22/10/17.
 */
enum class AccountCurrency {
    EUR,
    DOLLAR
}

enum class AccountType {
    PAYMENT,
    SAVING
}

open class Account(val accountBalanceInCents: Long,
                   val accountCurrency: AccountCurrency,
                   val accountId: Long,
                   val accountName: String,
                   val accountNumber: String,
                   val accountType: AccountType,
                   val alias: String,
                   val isVisible: Boolean,
                   val iban: String)

/** for this example app the parsing of different account classes given is AccountType is undone*/
class SavingAccount(accountBalanceInCents: Long,
                    accountCurrency: AccountCurrency,
                    accountId: Long,
                    accountName: String,
                    accountNumber: String,
                    accountType: AccountType,
                    alias: String,
                    isVisible: Boolean,
                    iban: String,
                    val linkedAccountId: Long,
                    val productName: String,
                    val productType: Long,
                    val savingsTargetReached: Int,
                    val targetAmountInCents: Long
) : Account(accountBalanceInCents,
        accountCurrency,
        accountId,
        accountName,
        accountNumber,
        accountType,
        alias,
        isVisible,
        iban)

