package com.rynzler07.posklinik.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.adapter.MyPasienAdapter
import com.rynzler07.posklinik.data.DataPasien
import java.util.*

class PatientFragment : Fragment() {

    val database = FirebaseFirestore.getInstance();
    val pasienRef = database.collection("DataPasien")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.title = "Patient"

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_pasien)
        val progresBar: ProgressBar = view.findViewById(R.id.progressBar)

//
//        item.add(DataPasien("081999999999", "Erwin Kurniawan", "dr. Gandhi Iskandar", "05/01/2021"))
//        item.add(DataPasien("085898989898", "Erwin Kurniawan", "dr. Gandhi Iskandar", "10/01/2021"))
//        item.add(DataPasien("089990333534", "Erwin Kurniawan", "dr. Gandhi Iskandar", "15/01/2021"))
//        item.add(DataPasien("087524214125", "Erwin Kurniawan", "dr. Gandhi Iskandar", "20/01/2021"))
//        item.add(DataPasien("082256232123", "Erwin Kurniawan", "dr. Gandhi Iskandar", "25/01/2021"))
        val adapter = MyPasienAdapter()

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter

        progresBar.visibility = View.VISIBLE
        pasienRef.get().addOnSuccessListener {
            val item: ArrayList<DataPasien> = ArrayList()
            item.clear()
            for (i in it.documents) {
                val dataPasien = i.toObject(DataPasien::class.java)
                if (dataPasien != null)
                    item.add(dataPasien)
            }
            adapter.setItem(item)
            progresBar.visibility = View.GONE
        }
    }
}