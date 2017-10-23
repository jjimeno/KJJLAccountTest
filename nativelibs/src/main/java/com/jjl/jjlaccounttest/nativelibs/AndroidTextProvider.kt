package com.jjl.jjlaccounttest.nativelibs

import android.content.Context
import com.jjl.accounttest.domain.lib.TextProvider


/**
 * Created by jjimeno on 22/10/17.
 */
class AndroidTextProvider(context: Context) : TextProvider {
    val context: Context

    override fun provideText(key: String): String {
        return getStringResourceByName(key)
    }

    private fun getStringResourceByName(aString: String): String {
        val packageName = context.packageName
        val resId = context.resources.getIdentifier(aString, "string", packageName)
        return context.getString(resId)
    }

    init {
        this.context = context.applicationContext
    }
}