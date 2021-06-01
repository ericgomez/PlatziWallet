package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.IOException
import java.io.OutputStreamWriter

class SaveCommand : FileCommand {
    override fun execute(context: Context, fileName: String, vararg arguments: String) {

        try {
            // Variable para poder escribir en nuestro celular, el cual nos servira como puente para poder escribir en memoria
            val outputStreamWriter = OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE))

            outputStreamWriter.write(arguments.toString()) // le indicamos anuesrea variable que puede escribir
            outputStreamWriter.close() // Cerramos nuestro sistema de archivos

        }catch (exception: IOException){
            Log.e("SaveCommand","File write failed: $exception")
        }
    }
}