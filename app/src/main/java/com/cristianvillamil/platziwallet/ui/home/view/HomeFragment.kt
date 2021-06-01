package com.cristianvillamil.platziwallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristianvillamil.platziwallet.R
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory
import com.cristianvillamil.platziwallet.ui.home.data.MessageFactory.Companion.TYPE_INFO
import com.cristianvillamil.platziwallet.ui.home.presenter.HomePresenter
import com.cristianvillamil.platziwallet.ui.observable.AvailableBalanceObservable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter()

    // Creamos una nuave instancia de AvailableBalanceObservable
    private val availableBalanceObservable = AvailableBalanceObservable()

    // Creamos una Instancia
    private var homePresenter:HomeContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this) // Reasignamos la instancia
        homePresenter?.retrieveFavoriteTransfers() // Probamos que tengamos acceso a la variable mutable
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
            .into(profilePhotoImageView)

        // Creamos un evento Observer
        /*availableBalanceObservable.addObserver(object : Observer {
            // implementamos en metodo de notificaciones
            override fun notifyChange(newValue: Double) {
                // Cambiamos el texto de amountValueTextView
                amountValueTextView.text = ("$ $newValue")
            }

        })*/

        // Solicitamos el PercentageLiveData por medio de los contratos y nos suscribimos con el observer
        homePresenter!!.getPercentageLiveData().observe(this, Observer<String>{ value ->
            percentageText.text = value // Asignamos el nuevo valor al percentageText
        })
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter

    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE // Mostramos el Loader
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE // Ocultamos el Loader
    }

    // Metodo con el que se comunica nuestro presentador
    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        // Recibimos la data
        favoriteTransferAdapter.setData(favoriteTransfer)

        /*val dialogFactory = MessageFactory() // Creamos la instancia de MessageFactory
        context?.let { // Si el contexto no es Nulo ejecuta la siguiente linea de codigo
            val errorDialog = dialogFactory.getDialog(it, TYPE_INFO) // Obtenemos el dialog por medio de su Tipo
            errorDialog.show()
        }*/
    }
}