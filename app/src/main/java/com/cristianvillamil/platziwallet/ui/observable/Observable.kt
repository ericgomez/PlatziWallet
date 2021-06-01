package com.cristianvillamil.platziwallet.ui.observable

interface Observable {
    fun addObserver(observer: Observer) // Añadimos un observer
    fun removeObserver(observer: Observer) // Removemos observer
    fun notifyObservers(newValue: Double) // Notificamo el observer
}