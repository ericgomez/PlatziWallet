package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class ReadCommand : FileCommand {

    override fun execute(context: Context, fileName: String, vararg arguments: String) {
        var fileString = ""

        val inputStream = context.openFileInput(fileName) // Abrimos una conexion en el sistema de archivos pero para lectura
        val stringBuilder = StringBuilder() // hacemos apend a cada uno de los string de la memoria
        val inputStreamReader = InputStreamReader(inputStream) // Leemos nuestro archivo
        val bufferedReader = BufferedReader(inputStreamReader) // Permite leer linea por linea el archivo

        bufferedReader.forEachLine { stringBuilder.append("\n").append(it) }  // por cada linea agregamos un salto de linea
        fileString = stringBuilder.toString() // Pasamos el contenido a un String

        Log.e("ReadedFile",fileString) // Escribimos en el Log que ya tenemos los archivos
    }
}