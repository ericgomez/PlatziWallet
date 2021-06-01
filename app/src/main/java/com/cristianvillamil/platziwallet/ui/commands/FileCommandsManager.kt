package com.cristianvillamil.platziwallet.ui.commands

// Delegacion de comandos
class FileCommandsManager {
    private val commands: HashMap<String, FileCommand> = HashMap() // Creamos la instancia del HashMap

    fun putCommand(commandName: String, fileCommand: FileCommand){
        commands[commandName] = fileCommand
    }

    // Solicitamos comandos
    fun getCommand(commandName: String) : FileCommand{
        // Si el comando dentro de commands existe
        if (commands.containsKey(commandName)){
            return commands[commandName]!! // Nos aseguramos que commandName no sea null utilizamos !!

        }else{
            throw RuntimeException("command $commandName no esta registrado")
        }
    }
}