package com.cristianvillamil.platziwallet.ui.observable

class AvailableBalanceObservable : Observable { // Implementamos interfas de Observable

    private val amountObserverList: ArrayList<Observer> = arrayListOf() // Creamos variable mutable con la lista de nuestro observadores, inicializamos con una lista vacia
    private var amount: Double = 0.0

    // Funcion para cambiar el saldo disponible
    fun changeAmount(newValue: Double){
        amount = newValue // Cambiamos amount por el nuevo valor
        notifyObservers(amount) // Notificamos a los observadores de este nuevo valor
    }

    // Agregamos o suscribirnos un Observer
    override fun addObserver(observer: Observer) {
        amountObserverList.add(observer)
    }

    // Removemos un Observer
    override fun removeObserver(observer: Observer) {
        amountObserverList.remove(observer)
    }

    // Notificamos actualizaciones del Observer
    override fun notifyObservers(newValue: Double) {
        // Le notificamos a cada uno de los observer que se suscribio por medio de un forEach
        amountObserverList.forEach {
            it.notifyChange(newValue)
        }
    }
}