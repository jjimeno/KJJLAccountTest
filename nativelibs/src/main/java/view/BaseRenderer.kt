package view

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrogomez.renderers.Renderer

/**
 * Created by jjimeno on 23/10/17.
 */
abstract class BaseRenderer<T> : Renderer<T> {
    private var listener: ((T) -> Unit)? = null

    constructor() : super()

    constructor(listener: (T) -> Unit) : super() {
        this.listener = listener
    }

    @LayoutRes
    abstract fun getContentView(): Int

    abstract fun draw()

    override fun setUpView(rootView: View) {
    }

    override fun render() {
        draw()
    }

    override fun inflate(inflater: LayoutInflater, parent: ViewGroup): View {
        return inflater.inflate(getContentView(), parent, false)
    }

    override fun hookListeners(rootView: View) {
        rootView.setOnClickListener({ listener?.invoke(content) })
    }
}