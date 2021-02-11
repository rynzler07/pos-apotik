package com.rynzler07.posklinik


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rynzler07.posklinik.fragment.DokterFragment
import com.rynzler07.posklinik.fragment.MedicineFragment
import com.rynzler07.posklinik.fragment.PatientFragment

class MainActivity : AppCompatActivity() {

    //Membuat fragment objek
    lateinit var dokterFragment: DokterFragment
    lateinit var patientFragment: PatientFragment
    lateinit var medicineFragment: MedicineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomnav.setItemIconTintList(null);
        val dokterFragment = DokterFragment()
        val patientFragment = PatientFragment()
        val medicineFragment = MedicineFragment()

        makeCurrentFragment(dokterFragment)

        bottomnav?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_satu -> {
                    makeCurrentFragment(dokterFragment)
                }
                R.id.navigation_dua -> {
                    makeCurrentFragment(patientFragment)
                }
                R.id.navigation_tiga -> {
                    makeCurrentFragment(medicineFragment)
                }
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_keranjang) {
            val intent = Intent(this, KeranjangActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
//            Toast.makeText(this, "Item Keranjang Clicked", Toast.LENGTH_SHORT).show()
            return true
        }else if (id == R.id.action_search){
            Toast.makeText(this, "Item Pencarian Clicked", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_content, fragment)
            commit()
        }
}
