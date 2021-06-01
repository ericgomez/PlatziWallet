package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {

        view.showLoader() // Le indicamos a la vista que Mostramos el Loader

        homeInteractor.retrieveFavoriteTransferFromCache(object : HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {

                UserSingleton.getInstance().userName = "Hola"

                view.hideLoader() // Le indicamos a la vista que oculte el loader
                view.showFavoriteTransfers(favoriteList) // Muestra la lista de favoritos

            }

        })
    }
}