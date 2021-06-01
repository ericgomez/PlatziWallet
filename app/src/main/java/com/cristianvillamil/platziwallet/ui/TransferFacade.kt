package com.cristianvillamil.platziwallet.ui

class TransferFacade {
    // Creamos las instancias
    val analyticsManager: AnalyticsManager = AnalyticsManager()
    val securityManager = SecurityManager()
    val transferManager : TransferManager = TransferManager()

    // Realiza la transferencia
    fun tranfer(){
        // En este caso vemos que Facede esta encapsulando la complejidad de 3 subsistemas en un solo metodo de
        // tranferencia
        val token = securityManager.getToken()
        analyticsManager.registerTransfer(token)
        transferManager.tranfer(token)
    }
}