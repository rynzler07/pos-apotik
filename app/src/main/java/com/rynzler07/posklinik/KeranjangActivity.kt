package com.rynzler07.posklinik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rynzler07.posklinik.adapter.MyKeranjangAdapter
import com.rynzler07.posklinik.data.DataObat

class KeranjangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keranjang)
        supportActionBar?.title = "Payment"

        val rv_keranjang: RecyclerView = findViewById(R.id.rv_keranjang)

//        val rv_keranjang = findViewById<RecyclerView>(R.id.rv_keranjang)
        val dataObat:ArrayList<DataObat> = ArrayList()

        dataObat.add(DataObat(R.drawable.icon_obat,"Paracetamol", "Rp 25.000"))
        dataObat.add(DataObat(R.drawable.icon_obat,"Molexflu", "Rp 25.000"))
        dataObat.add(DataObat(R.drawable.icon_obat,"Amlodipine", "Rp 25.000"))
        dataObat.add(DataObat(R.drawable.icon_obat,"Amoxicilin", "Rp 25.000"))
        dataObat.add(DataObat(R.drawable.icon_obat,"Panadol", "Rp 25.000"))
        dataObat.add(DataObat(R.drawable.icon_obat,"Paramex", "Rp 25.000"))

        var adapter = MyKeranjangAdapter(dataObat)
        rv_keranjang.adapter = adapter
        rv_keranjang.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}