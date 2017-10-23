package com.jjl.accounttest.domain.model

import com.google.gson.Gson
import com.jjl.accounttest.domain.entity.AccountsResponse
import org.junit.Assert
import org.junit.Test

/**
 * Created by jjimeno on 22/10/17.
 */
class AccountTest {

    @Test
    fun `parsing account ok`() {
        val string = provideElementsAsString()
        val parsedObj = Gson().fromJson(string, AccountsResponse::class.java)
        Assert.assertNotNull(parsedObj)
        Assert.assertEquals(3,parsedObj.accounts.size)

        val account = parsedObj.accounts.first()
        Assert.assertEquals(985000, account.accountBalanceInCents)
        Assert.assertEquals(AccountCurrency.EUR, account.accountCurrency)
        Assert.assertEquals(748757694, account.accountId)
        Assert.assertEquals("Hr P L G N StellingTD", account.accountName)
        Assert.assertEquals(748757694, account.accountNumber.toLong())
        Assert.assertEquals(AccountType.PAYMENT, account.accountType)
        Assert.assertEquals("", account.alias)
        Assert.assertEquals(true, account.isVisible)
        Assert.assertEquals("NL23INGB0748757694", account.iban)
    }

    private fun provideElementsAsString(): String {
        return "{\n" +
                "\t\"accounts\": [{\n" +
                "\t\t\"accountBalanceInCents\": 985000,\n" +
                "\t\t\"accountCurrency\": \"EUR\",\n" +
                "\t\t\"accountId\": 748757694,\n" +
                "\t\t\"accountName\": \"Hr P L G N StellingTD\",\n" +
                "\t\t\"accountNumber\": 748757694,\n" +
                "\t\t\"accountType\": \"PAYMENT\",\n" +
                "\t\t\"alias\": \"\",\n" +
                "\t\t\"isVisible\": true,\n" +
                "\t\t\"iban\": \"NL23INGB0748757694\"\n" +
                "\t}, {\n" +
                "\t\t\"accountBalanceInCents\": 1000000,\n" +
                "\t\t\"accountCurrency\": \"EUR\",\n" +
                "\t\t\"accountId\": 700000027559,\n" +
                "\t\t\"accountName\": \",\",\n" +
                "\t\t\"accountNumber\": 748757732,\n" +
                "\t\t\"accountType\": \"PAYMENT\",\n" +
                "\t\t\"alias\": \"\",\n" +
                "\t\t\"isVisible\": false,\n" +
                "\t\t\"iban\": \"NL88INGB0748757732\"\n" +
                "\t}, {\n" +
                "\t\t\"accountBalanceInCents\": 15000,\n" +
                "\t\t\"accountCurrency\": \"EUR\",\n" +
                "\t\t\"accountId\": 700000027559,\n" +
                "\t\t\"accountName\": \"\",\n" +
                "\t\t\"accountNumber\": \"H 177-27066\",\n" +
                "\t\t\"accountType\": \"SAVING\",\n" +
                "\t\t\"alias\": \"SAVINGS\",\n" +
                "\t\t\"iban\": \"\",\n" +
                "\t\t\"isVisible\": true,\n" +
                "\t\t\"linkedAccountId\": 748757694,\n" +
                "\t\t\"productName\": \"Oranje Spaarrekening\",\n" +
                "\t\t\"productType\": 1000,\n" +
                "\t\t\"savingsTargetReached\": 1,\n" +
                "\t\t\"targetAmountInCents\": 2000\n" +
                "\t}],\n" +
                "\t\"failedAccountTypes\": \"CREDITCARDS\",\n" +
                "\t\"returnCode\": \"OK\"\n" +
                "}\n"
    }
}