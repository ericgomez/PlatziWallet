package com.cristianvillamil.platziwallet.ui

// Proxy nos proporciona una capa mas alta de seguridad, es decir, que la clase a la que se quiere acceder esta segura
class TransferProxy {

    val MAX_TRANFER_AMOUNT = 1000000 // Maximo valor a tranferir
    val MIN_TRANSFER_AMOUNT = 100 // Minimo valor a tranferir

    fun checkTransfer(amount: Double) : String{
        // Evaluamos las reglas del negocio
        return when {
            // Si el monto es mayor al maximo
            amount > MAX_TRANFER_AMOUNT -> {
                "La transacción excede el monto"
            }
            // Si el monto es menor al minimo
            amount < MIN_TRANSFER_AMOUNT -> {
                "La transaccion debe ser mayor $MIN_TRANSFER_AMOUNT"
            }
            else -> {
                // En caso de que si cumpla las reglas de negocio
                doTransfer(amount) // Ejecuto el metodo para hacer la transferencia
                "La transferencia se hizo correctamente"
            }
        }
    }

    // Creamos un metodo de hacer la transfencia
    private fun doTransfer(amount: Double){

    }
}