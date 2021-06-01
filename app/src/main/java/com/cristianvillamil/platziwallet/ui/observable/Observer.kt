package com.cristianvillamil.platziwallet.ui.observable

interface Observer {
    // Notifica todos los eventos del Observable
    fun notifyChange(newValue: Double)
}