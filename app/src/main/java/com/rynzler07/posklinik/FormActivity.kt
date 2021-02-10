package com.rynzler07.posklinik

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.rynzler07.posklinik.data.DataPasien
import com.rynzler07.posklinik.databinding.ActivityFormBinding


class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    val database = FirebaseFirestore.getInstance();
    val pasienRef = database.collection("DataPasien")

    var db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaDokter = intent.getStringExtra("NamaDokter") as String
        var valueRadio = "L"


        binding.rgJenisKelamin.setOnCheckedChangeListener { radioGroup, i ->
            if (i == binding.rbLaki.id) {
                valueRadio = "L"
            } else {
                valueRadio = "P"
            }
        }


        binding.btnSubmitPasien.setOnClickListener {
            val nama = binding.EditTextNamaPasien.text.toString().trim()
            val noHp = binding.EditTextNoHP.text.toString().trim()
            val alamat = binding.EditTextAlamat.text.toString().trim()
            val tglJanji = binding.EditTextTglJanji.text.toString().trim()
            val jamJanji = binding.EditTextJamJanji.text.toString().trim()

            val mDataPasien = DataPasien(
                patientName = nama,
                address = alamat,
                phoneNumbe = noHp,
                docterName = namaDokter,
                appointmentDate = tglJanji,
                appointmentTime = jamJanji,
                gender = valueRadio
            )
            if (validate(nama, alamat, tglJanji, jamJanji,noHp)) {
                binding.progressBar.visibility =View.VISIBLE
                pasienRef.add(mDataPasien)
                    .addOnCompleteListener {
                        binding.progressBar.visibility =View.GONE
                        if (it.isSuccessful) {
                            Toast.makeText(applicationContext, "Sukses", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Gagal mendaftar",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }

    private fun validate(
        nama: String,
        noHp: String,
        alamat: String,
        tgljanji: String,
        jamjanji: String
    ): Boolean {

        if (nama.isEmpty()) {
            binding.EditTextNamaPasien.error = "Masukkan Nama !!"
            return false
        }else if(noHp.isEmpty()){
            binding.EditTextNoHP.error = "Masukkan No Hp !!"
            return false
        }else if(alamat.isEmpty()){
            binding.EditTextAlamat.error = "Masukkan Alamat !!"
            return false
        }else if(tgljanji.isEmpty()){
            binding.EditTextTglJanji.error = "Masukkan Tanggal !!"
            return false
        }else if(jamjanji.isEmpty()){
            binding.EditTextJamJanji.error = "Masukkan Jam !!"
            return false
        } else {
            binding.EditTextNamaPasien.error = null
            binding.EditTextNoHP.error = null
            binding.EditTextAlamat.error = null
            binding.EditTextTglJanji.error = null
            binding.EditTextJamJanji.error = null
        }
        return true
    }
}