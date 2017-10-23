package com.jjl.accounttest.domain.view

/**
 * Created by jjimeno on 22/10/17.
 */
interface View

interface LoadingView:View
{
    fun showLoading()
    fun hideLoading()
}