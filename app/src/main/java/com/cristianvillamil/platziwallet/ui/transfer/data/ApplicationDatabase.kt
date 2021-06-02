package com.cristianvillamil.platziwallet.ui.transfer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TransferEntity::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() { // Retornamos la de clase padre RoomDatabase
    abstract fun getDAO() : TransferDAO
    companion object {

        private var INSTANCE: ApplicationDatabase? = null // Creamos una instancia de Tipo ApplicationDatabase inizalizada en null

        // funcion para solicitar la instancia de la base de datos
        fun getAppDatabase(context: Context): ApplicationDatabase? {
            // implementamos un patron de diseño Singleton
            // Si la instancia es nula
            if (INSTANCE == null){
                // Creamos la instancia
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDatabase::class.java,
                    "platziWalletDatabase"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }

        // Funcion para destruir la instancia
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}