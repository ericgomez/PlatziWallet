package com.cristianvillamil.platziwallet.ui.home

import androidx.lifecycle.LiveData

interface HomeContract {
    interface View{
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>)
    }

    interface Presenter{
        fun retrieveFavoriteTransfers()
        fun getPercentageLiveData() : LiveData<String>
    }

    // Interfaz del Callback que devuelve el dato que esta entre el presentador y la DB
    interface OnResponseCallback{
        fun onResponse(favoriteList : List<FavoriteTransfer>)
    }
}