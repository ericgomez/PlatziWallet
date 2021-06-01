package com.cristianvillamil.platziwallet.ui.home.data

// Clase User con un Contructor privado
class User private constructor(private val userName: String, private val password: String) {

    //Patron Builder
    class Builder {
        // Gestiona todos los parametros opcionales o no
        var userName: String = ""
        var password: String? = null

        // Funcion setear el UserName
        fun setUserName(newUserName: String): Builder {
            this.userName = newUserName
            return this
        }

        // Funcion setear el Password
        fun setPassword(newPassword: String): Builder {
            this.password = newPassword
            return this
        }

        // Se encarga de crear la instancia de User
        fun build(): User {
            // Retorna el User y la instancia
            return User(userName, password ?: "")
            // ?: si la instancia es nula, retornamos un vacio
        }
    }
}