package com.jjl.accounttest.domain.view

/**
 * Created by jjimeno on 22/10/17.
 */
interface Presenter<out T : View> {

    val view: T

    fun start() {
        //default implementation that does nothing
    }

    fun stop(){
        //Default implementation that does nothing
        //subclasses should stop/cancel its background jobs
    }
}

class BasePresenter<out T : View>(override val view: T) : Presenter<T>