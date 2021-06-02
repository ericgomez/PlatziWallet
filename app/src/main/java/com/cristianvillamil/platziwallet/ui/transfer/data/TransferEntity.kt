package com.cristianvillamil.platziwallet.ui.transfer.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transfers") //Nombre de la clase al momento de Guardar llamada transfers
data class TransferEntity(

    @ColumnInfo(name = "transaction_id") //Nombre de la variable al momento de Guardar llamada transaction_id
    @PrimaryKey(autoGenerate = true) // Indicamos que el parametro tendra una llave primaria autogenerada
    val transactionId: Int = 0,

    @ColumnInfo(name = "user_id") //Nombre de la variable al momento de Guardar llamada user_id
    val userId: String,

    @ColumnInfo(name = "user_name") //Nombre de la variable al momento de Guardar llamada user_name
    val userName: String,

    @ColumnInfo(name = "transaction_date") //Nombre de la variable al momento de Guardar llamada transaction_date
    val transactionDate: String,

    @ColumnInfo(name = "transaction_amount") //Nombre de la variable al momento de Guardar llamada transaction_amount
    val transactionAmount: String,

    @ColumnInfo(name = "receiver_user_id") //Nombre de la variable al momento de Guardar llamada receiver_user_id
    val receiverUserId: String
)