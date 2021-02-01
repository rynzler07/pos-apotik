package com.rynzler07.posklinik.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.adapter.MyDokterAdapter
import com.rynzler07.posklinik.data.DataDokter
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [DokterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DokterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dokter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView:RecyclerView = view.findViewById(R.id.rv_dokter)

        val item:ArrayList<DataDokter> = ArrayList()

        item.add(DataDokter(R.drawable.dokter1, "dr. Gandhi Iskandar", "Test", "Heart - Persahabatan Hospital", R.drawable.review_star, R.drawable.dokter1))
        item.add(DataDokter(R.drawable.dokter1, "dr. Tuti Hartati", "Eye", "RSUD Mitra Plumbon", R.drawable.review_star, R.drawable.dokter1))
        item.add(DataDokter(R.drawable.dokter1, "dr. Asep Sumail", "Dental", "Audy Dental Clinic", R.drawable.review_star, R.drawable.dokter1))
        item.add(DataDokter(R.drawable.dokter1, "dr. Hetti Mariyati", "Skin", "Rumah Sakit Edelweis", R.drawable.review_star, R.drawable.dokter1))
        item.add(DataDokter(R.drawable.dokter1, "dr. Bayu Mahadi", "Heart", "Khalisa Hospital", R.drawable.review_star, R.drawable.dokter1))
        val adapter = MyDokterAdapter(item)

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
    }
}