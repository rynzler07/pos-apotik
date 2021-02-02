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
import com.rynzler07.posklinik.data.DataPasien

class MyPasienAdapter(private val obatList: List<DataPasien>) : RecyclerView.Adapter<MyPasienAdapter.PasienViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasienViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_pasien,parent,false)

        return PasienViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PasienViewHolder, position: Int) {
        val currentItem = obatList[position]

        holder.textView1.text = currentItem.nomorHP
        holder.textView2.text = currentItem.namaPasien
        holder.textView3.text = currentItem.namaDokter
        holder.textview4.text = currentItem.tglJanji

    }

    override fun getItemCount() = obatList.size


    class PasienViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.tv_noHP)
        val textView2: TextView = itemView.findViewById(R.id.tv_nama_pasien)
        val textView3: TextView = itemView.findViewById(R.id.tv_nama_dokter)
        val textview4: TextView = itemView.findViewById(R.id.tv_tglJanji)



    }
}