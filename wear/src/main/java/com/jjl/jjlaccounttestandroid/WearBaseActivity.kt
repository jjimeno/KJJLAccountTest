package com.jjl.jjlaccounttestandroid

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.wearable.activity.WearableActivity
import com.jjl.accounttest.domain.view.Presenter
import com.jjl.accounttest.domain.view.View

/**
 * Created by jjimeno on 25/10/17.
 */
abstract class WearBaseActivity<out V : View, P : Presenter<V>> : WearableActivity() {

    var presenter: P? = null

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun providePresenter(): P


    open protected fun configureViews() {
        //do nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAmbientEnabled()
        setContentView(getLayoutRes())
        configureViews()
        presenter = providePresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter?.start()
    }

    override fun onStop() {
        presenter?.stop()
        super.onStop()
    }
}