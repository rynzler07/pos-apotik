package com.rynzler07.posklinik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.data.DataObat

class MyMedicineAdapter(private val obatList: List<DataObat>) : RecyclerView.Adapter<MyMedicineAdapter.ObatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_medicine,parent,false)

        return ObatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        val currentItem = obatList[position]

        holder.imageView.setImageResource(currentItem.imgObat)
        holder.textView1.text = currentItem.namaObat
        holder.textView2.text = currentItem.hargaObat


    }

    override fun getItemCount() = obatList.size


    class ObatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.img_obat)
        val textView1: TextView = itemView.findViewById(R.id.tv_namaObat)
        val textView2: TextView = itemView.findViewById(R.id.tv_hargaObat)
        val button:Button = itemView.findViewById(R.id.btn_tmbhObat)


    }
}