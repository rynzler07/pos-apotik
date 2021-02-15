package com.rynzler07.posklinik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.data.DataObat

class MyKeranjangAdapter(private val dataObat: List<DataObat>): RecyclerView.Adapter<MyKeranjangAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyKeranjangAdapter.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(
            R.layout.rv_selected_medicine, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataObat.size
    }

    override fun onBindViewHolder(holder: MyKeranjangAdapter.ViewHolder, position: Int) {
        val currentItem = dataObat[position]

        holder?.gambarObat?.setImageResource(currentItem.imgObat)
        holder?.namaObat?.text = currentItem.namaObat
        holder?.hargaObat?.text = currentItem.hargaObat
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val gambarObat = itemView.findViewById<ImageView>(R.id.img_obat)
        val namaObat = itemView.findViewById<TextView>(R.id.tv_namaObat)
        val hargaObat = itemView.findViewById<TextView>(R.id.tv_hargaObat)
    }

}