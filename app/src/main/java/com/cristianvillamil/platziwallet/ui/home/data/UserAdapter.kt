package com.cristianvillamil.platziwallet.ui.home.data

import com.cristianvillamil.platziwallet.ui.home.view.UserViewModel

class UserAdapter() {

    fun getUserViewModel(userResponse: UserResponse) : UserViewModel {
        // Retornamos el UserViewModel

        // En este caso si cambiamos el nombre de alguna variable del data class UserResponse
        // la vista no se vera afectada solo el Adaptador: Ejemplo 'userName' se cambio a 'name'
        return UserViewModel(userResponse.name,userResponse.userPhotoURL)
    }
}