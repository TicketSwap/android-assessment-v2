package com.ticketswap.android.assessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VaccinesViewModel : ViewModel() {

    private val database = VaccineDatabase()

    val vaccinesListMutable = MutableLiveData<List<Vaccine>>()
    val vaccinesList: LiveData<List<Vaccine>> = vaccinesListMutable

    init {
        vaccinesListMutable.value = database.getVaccines()
    }
}