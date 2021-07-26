package com.ticketswap.android.assessment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VaccinesFragment : Fragment() {

    val viewModel = VaccinesViewModel()
    val adapter = VaccinesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_vaccines, container, false)

        view.findViewById<RecyclerView>(R.id.vaccines).layoutManager = LinearLayoutManager(requireContext())
        view.findViewById<RecyclerView>(R.id.vaccines).adapter = adapter
        adapter.fragment = this

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vaccinesList.observe(viewLifecycleOwner, {
            adapter.vaccines = it
            adapter.notifyDataSetChanged()
        })
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun onVaccineSelected(vaccine: Vaccine) {
        (activity!! as MainActivity).goToVaccine(vaccine)
    }
}