package com.jjl.accounttest.domain.lib

import java.io.InputStream
import java.io.OutputStream

/**
 * Created by jjimeno on 22/10/17.
 */
interface FileProvider {

    fun readFullFileWithName(fileName: String): String

    fun readStream(ins: InputStream, ous: OutputStream) {
        var arr = ByteArray(1024)
        do {
            val read = ins.read(arr)
            if (read != -1) {
                ous.write(arr, 0, read)
            }
        } while (read != -1)
    }
}