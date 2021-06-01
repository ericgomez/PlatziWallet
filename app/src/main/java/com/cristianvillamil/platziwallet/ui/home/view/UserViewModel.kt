package com.cristianvillamil.platziwallet.ui.home.view

// Una data class es una clase que contiene solamente atributos que quedemos guardar

// En este caso si cambiamos el nombre de alguna variable del data class UserResponse
// la vista no se vera afectada solo el Adaptador
data class UserViewModel(val userName: String, val photoURL: String)