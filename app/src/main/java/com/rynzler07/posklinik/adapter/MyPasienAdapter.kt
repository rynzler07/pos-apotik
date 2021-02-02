package com.rynzler07.posklinik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.baseprojectlibrary.base.BaseRecyclerViewAdapter
import com.rynzler07.posklinik.R
import com.rynzler07.posklinik.data.DataPasien
import com.rynzler07.posklinik.databinding.RvListPasienBinding

class MyPasienAdapter : BaseRecyclerViewAdapter<MyPasienAdapter.PasienViewHolder, DataPasien>() {
    inner class PasienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mBinding = RvListPasienBinding.bind(itemView)
        fun onBind(mDataPasien: DataPasien) {
            mBinding.tvNoHP.text = mDataPasien.phoneNumbe
            mBinding.tvNamaPasien.text = mDataPasien.patientName
            mBinding.tvNamaDokter.text = mDataPasien.docterName
            mBinding.tvTglJanji.text = mDataPasien.appointmentDate
        }

    }


    override fun onBindViewHolder(holder: PasienViewHolder, item: DataPasien, position: Int) {
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasienViewHolder {
        return PasienViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_list_pasien, parent, false)
        )
    }
}