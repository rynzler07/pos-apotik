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
import com.rynzler07.posklinik.adapter.MyMedicineAdapter
import com.rynzler07.posklinik.data.DataObat

/**
 * A simple [Fragment] subclass.
 * Use the [MedicineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_obat)

        val item:ArrayList<DataObat> = ArrayList()

        item.add(DataObat(R.drawable.icon_obat, "Paracetamol", "Rp 25.000"))
        item.add(DataObat(R.drawable.icon_obat, "Molexflu", "Rp 25.000"))
        item.add(DataObat(R.drawable.icon_obat, "Amlodipine", "Rp 25.000"))
        item.add(DataObat(R.drawable.icon_obat, "Amoxicilin", "Rp 25.000"))
        item.add(DataObat(R.drawable.icon_obat,"Obat 5", "Rp 25.000"))
        val adapter = MyMedicineAdapter(item)

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
    }
}