package com.jjl.jjlaccounttestandroid.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.jjl.accounttest.domain.view.Presenter
import com.jjl.accounttest.domain.view.View

/**
 * Created by jjimeno on 22/10/17.
 */
abstract class BaseActivity<out V : View, T : Presenter<V>> : AppCompatActivity() {

    var presenter: T? = null

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun providePresenter(): T


    open protected fun configureViews() {
        //do nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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