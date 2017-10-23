package com.jjl.accounttest.domain.lib

/**
 * Created by jjimeno on 22/10/17.
 */
enum class TextKeys {
    HOME_LIST_DEFAULT_SEARCH,
    HOME_LIST_VISIBLE_SEARCH
}

interface TextProvider {
    fun provideText(key: String): String
}