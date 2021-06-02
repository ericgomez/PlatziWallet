package com.cristianvillamil.platziwallet.ui.loans

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoansViewModel : ViewModel() { // Heredamos de ViewModel

    // Creamos variables de tipo LiveData para comunicar a la vista
    private val percentageLiveData : MutableLiveData<String> = MutableLiveData()
    private val loansListLiveData : MutableLiveData<List<Loan>> = MutableLiveData()

    // Esta funcion cambia los valores de cada uno de los liveData
    fun changeValues(){
        percentageLiveData.value = "100%"
        loansListLiveData.value = emptyList()
    }

    fun getPercentageLiveData() : LiveData<String> = percentageLiveData

    fun getLoansListLiveData() : LiveData<List<Loan>> = loansListLiveData

    override fun onCleared() {
        super.onCleared()
    }
}