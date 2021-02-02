package com.rynzler07.posklinik.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.adapter.MyMedicineAdapter
import com.rynzler07.posklinik.adapter.MyPasienAdapter
import com.rynzler07.posklinik.data.DataPasien

/**
 * A simple [Fragment] subclass.
 * Use the [PatientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PatientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_pasien)

        val item:ArrayList<DataPasien> = ArrayList()

        item.add(DataPasien("081999999999", "Erwin Kurniawan", "dr. Gandhi Iskandar","05/01/2021"))
        item.add(DataPasien("085898989898", "Erwin Kurniawan", "dr. Gandhi Iskandar","10/01/2021"))
        item.add(DataPasien("089990333534", "Erwin Kurniawan", "dr. Gandhi Iskandar","15/01/2021"))
        item.add(DataPasien("087524214125", "Erwin Kurniawan", "dr. Gandhi Iskandar","20/01/2021"))
        item.add(DataPasien("082256232123", "Erwin Kurniawan", "dr. Gandhi Iskandar","25/01/2021"))
        val adapter = MyPasienAdapter(item)

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
    }
}