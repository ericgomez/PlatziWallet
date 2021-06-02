package com.cristianvillamil.platziwallet.ui.transfer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao // Data Access Object - Con esto vamos a acceder al Objeto, traer parametros, insertar, guardar y eliminar
interface TransferDAO {
    // la peticion las realizaremos por medio de Querys

    @Query("SELECT * FROM transfers") // Query de consulta
    // Al momento de pedir getAll - nos retornara una lista de tranfers
    fun getAll() : List<TransferEntity>

    @Query("SELECT * FROM transfers WHERE user_name LIKE :userName") // Query de consulta
    // Al momento de pedir findTransferByUserName - nos retornara una lista de tranfers por usuario
    fun findTransferByUserName(userName: String) : List<TransferEntity>

    @Insert // Para guardar simplemente hacemos Insert y el se encarga de hacer todo
    // Al momento de pedir saveTransfer - Nos permitira guardar una tranferencia
    fun saveTransfer(transfer : TransferEntity)

    @Delete // Para guardar simplemente hacemos Delete y el se encarga de hacer todo
    // Al momento de pedir delete - Nos permitira eliminar una tranferencia
    fun delete(transfer: TransferEntity)
}