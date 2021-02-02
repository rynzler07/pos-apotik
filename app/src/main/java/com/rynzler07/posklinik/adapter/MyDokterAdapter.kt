package com.rynzler07.posklinik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.baseprojectlibrary.base.BaseRecyclerViewAdapter
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.data.DataDokter
import com.rynzler07.posklinik.databinding.RvListDokterBinding


class MyDokterAdapter : BaseRecyclerViewAdapter<MyDokterAdapter.ViewHolder, DataDokter>() {
   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = RvListDokterBinding.bind(itemView)
       fun onBind(data: DataDokter){
           binding.imgDokter.setImageResource(data.imgView)
           binding.tvDokter.text = data.tv_dokter
           binding.tvSpesialis.text = data.tv_spesialis
           binding.tvNamaRs.text = data.tv_nama_rs
           binding.imgReview.setImageResource(data.imgReview)
       }
       init {
           binding.btnForm.setOnClickListener{
               onItemClick?.invoke(items[adapterPosition])
           }
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, item: DataDokter, position: Int) {
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_list_dokter, parent, false))
    }
}

//class MyDokterAdapter(private val data: ArrayList<DataDokter>): RecyclerView.Adapter<DokterViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DokterViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return DokterViewHolder(
//            inflater,
//            parent
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    override fun onBindViewHolder(holder: DokterViewHolder, position: Int) {
//        holder.bind(data[position])
//    }
//}
