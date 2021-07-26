package com.ticketswap.android.assessment

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class VaccineViewModel : ViewModel() {

    val bookAppointment = BookAppointmentImpl()

    fun bookAppointment(fragment: Fragment) {
        bookAppointment.bookAppointment()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                (fragment as VaccineFragment).confirmAppointment()
            }, {})
    }
}