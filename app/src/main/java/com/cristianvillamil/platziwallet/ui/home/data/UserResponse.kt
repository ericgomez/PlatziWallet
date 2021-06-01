package com.cristianvillamil.platziwallet.ui.home.data

// Una data class es una clase que contiene solamente atributos que quedemos guardar
data class UserResponse (

    val id:String,
    val name: String,
    val token: String,
    val userPhotoURL: String,
    val tokenTransfer: String
)
