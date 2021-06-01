package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.IOException
import java.io.OutputStreamWriter

class SaveCommand : FileCommand {
    override fun execute(context: Context, fileName: String, vararg arguments: String) {

        try {
            var argumentsString = ""
            arguments.forEach { argumentsString = argumentsString + "\n"+it } // Obtenemos cada uno de los argumentos y agregarlos en su contenido

            // Variable para poder escribir en nuestro celular, el cual nos servira como puente para poder escribir en memoria
            val outputStreamWriter = OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE))

            outputStreamWriter.write(argumentsString) // le indicamos anuesrea variable que puede escribir
            outputStreamWriter.close() // Cerramos nuestro sistema de archivos

        }catch (exception: IOException){
            Log.e("SaveCommand","File write failed: $exception")
        }
    }
}