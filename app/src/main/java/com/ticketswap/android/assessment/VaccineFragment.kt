package com.ticketswap.android.assessment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VaccineFragment : Fragment() {

    val viewModel = VaccineViewModel()

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_vaccine, container, false)

        arguments!!.let {
            val vaccine = Vaccine(
                id = it.getLong("id"),
                name = it.getString("name", ""),
                description = it.getString("description", ""),
                requiredShots = it.getInt("requiredShots"),
                daysBetweenShots = it.getInt("daysBetweenShots")
            )

            view.findViewById<TextView>(R.id.name).text = vaccine.name
            view.findViewById<TextView>(R.id.requiredShots).text = "Shots required: ${vaccine.requiredShots}"
            view.findViewById<TextView>(R.id.daysBetweenShots).text = "Days between shots: ${vaccine.daysBetweenShots}"
            view.findViewById<TextView>(R.id.description).text = vaccine.description
        }

        view.findViewById<Button>(R.id.bookAppointment).setOnClickListener {
            viewModel.bookAppointment(this)
        }

        return view
    }

    fun confirmAppointment() {
        Toast.makeText(context, "You have an appointment!", Toast.LENGTH_LONG).show()
    }
}