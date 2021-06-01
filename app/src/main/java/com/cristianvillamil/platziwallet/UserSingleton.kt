package com.cristianvillamil.platziwallet

class UserSingleton {

    var userName = "Eric" // Datos de Prueba

    //  companion object: Nos da todos los valores estaticos que necesitamos en nuestro proyecto
    companion object{
        // Creamos una instancia con valor inicial Nulo
        private var instance : UserSingleton? = null

        // Funcion que se encargara de darnos la instancia del usuario
        fun getInstance() : UserSingleton {
            // Si no existe la instancia
            if (instance == null){
                // Le asignamos un valor
                instance = UserSingleton()
            }

            // Si existe solo la retornamos
            return instance as UserSingleton
        }
    }
}