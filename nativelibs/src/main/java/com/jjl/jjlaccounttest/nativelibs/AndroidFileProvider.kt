package com.jjl.jjlaccounttest.nativelibs

import android.content.Context
import com.jjl.accounttest.domain.lib.FileProvider
import java.io.ByteArrayOutputStream

/**
 * Created by jjimeno on 22/10/17.
 */
class AndroidFileProvider : FileProvider {

    val context: Context

    constructor(context: Context) {
        this.context = context.applicationContext
    }

    override fun readFullFileWithName(fileName: String): String {
        val ins = context.resources.assets.open(fileName)
        val os = ByteArrayOutputStream()
        readStream(ins, os)
        return os.toString()
    }
}