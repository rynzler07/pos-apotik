package com.rynzler07.posklinik.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.data.DataDokter

class DokterViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.rv_list_dokter, parent, false)) {

    final var imgView: ImageView? = null
    final var tvDokter: TextView? = null
    final var tvSpesialis: TextView? = null
    final var tvNamaRs: TextView? = null
    final var imgReview: ImageView? = null
    final var Janji:Button? = null

    init {
        imgView = itemView.findViewById(R.id.img_dokter)
        tvDokter = itemView.findViewById(R.id.tv_dokter)
        tvSpesialis = itemView.findViewById(R.id.tv_spesialis)
        tvNamaRs = itemView.findViewById(R.id.tv_nama_rs)
        imgReview = itemView.findViewById(R.id.img_review)
        Janji = itemView.findViewById(R.id.btn_form)
    }

    fun bind(data: DataDokter) {
        imgView?.setImageResource(data.imgView)
        tvDokter?.text = data.tv_dokter
        tvSpesialis?.text = data.tv_spesialis
        tvNamaRs?.text = data.tv_nama_rs
        imgReview?.setImageResource(data.imgReview)
    }
}