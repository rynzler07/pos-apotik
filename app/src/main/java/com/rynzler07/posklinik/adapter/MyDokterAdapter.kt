package com.rynzler07.posklinik.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.data.DataDokter
import com.rynzler07.posklinik.viewholder.DokterViewHolder

class MyDokterAdapter(private val data: ArrayList<DataDokter>): RecyclerView.Adapter<DokterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DokterViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
        holder.bind(data[position])
    }
}