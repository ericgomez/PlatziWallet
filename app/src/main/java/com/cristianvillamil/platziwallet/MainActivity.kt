package com.cristianvillamil.platziwallet

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.cristianvillamil.platziwallet.ui.commands.FileCommandsManager
import com.cristianvillamil.platziwallet.ui.commands.ReadCommand
import com.cristianvillamil.platziwallet.ui.commands.SaveCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val commandsManager = FileCommandsManager() // Creamos una instancia de FileCommandsManager
        val saveCommand = SaveCommand() // Creamos la instancia de SaveCommand

        commandsManager.putCommand("SaveCommand", saveCommand) // Agregamos el comando de guardar
        commandsManager.putCommand("ReadCommand", ReadCommand()) // Agregamos el comando de leer


        // Llamamos y ejecutamos los comandos
        commandsManager
            .getCommand("SaveCommand")
            .execute(this,"exampleFile", "HolaMundo", "PlatziWallet") // Ejecutamos el comando de juardar con el nombre de exampleFile y los argumentos "HolaMundo", "PlatziWallet

        commandsManager
            .getCommand("SaveCommand")
            .execute(this, "exampleFile") // Ejecutamos el comando para leer el archivo exampleFile
    }
}
