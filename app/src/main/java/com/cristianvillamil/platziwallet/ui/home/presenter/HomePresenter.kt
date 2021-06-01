package com.cristianvillamil.platziwallet.ui.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()
    private val percentageLiveData : MutableLiveData<String> = MutableLiveData() // Creamos la instancia de tipo mutable

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

                percentageLiveData.value = "40%" // indicamos un nuevo valor

                view.hideLoader() // Le indicamos a la vista que oculte el loader
                view.showFavoriteTransfers(favoriteList) // Muestra la lista de favoritos

            }

        })
    }

    // Devolvemos la interfaz una instancia de LiveData
    override fun getPercentageLiveData() : LiveData<String> = percentageLiveData
}