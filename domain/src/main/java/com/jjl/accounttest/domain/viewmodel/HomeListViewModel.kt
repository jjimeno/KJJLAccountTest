package com.jjl.accounttest.domain.viewmodel

/**
 * Created by jjimeno on 22/10/17.
 */

enum class HomeType {
    DEFAULT,
    ONLY_VISIBLE
}

data class HomeListViewModel(val homeType: HomeType, val text: String) {
}