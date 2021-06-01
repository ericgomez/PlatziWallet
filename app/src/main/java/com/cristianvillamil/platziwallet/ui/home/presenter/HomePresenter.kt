package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {

        view.showLoader() // Le indicamos a la vista que Mostramos el Loader

        homeInteractor.retrieveFavoriteTransferFromCache(object : HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {

                UserSingleton.getInstance().userName = "Hola"

                // Creamos una nueva Instancia por medio del Builder
                val user = User.Builder()
                    .setUserName("hola")
                    .setPassword("kjhkjshdkjashd")
                    .build()

                view.hideLoader() // Le indicamos a la vista que oculte el loader
                view.showFavoriteTransfers(favoriteList) // Muestra la lista de favoritos

            }

        })
    }
}