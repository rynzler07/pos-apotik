package com.rynzler07.posklinik


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
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

        var bottomnav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        var frameLayout = findViewById<FrameLayout>(R.id.fl_content)

        val dokterFragment = DokterFragment()
        val patientFragment = PatientFragment()
        val medicineFragment = MedicineFragment()

        makeCurrentFragment(dokterFragment)

        bottomnav?.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_satu -> {
                    makeCurrentFragment(dokterFragment)
                }R.id.navigation_dua -> {
                makeCurrentFragment(patientFragment)
            }R.id.navigation_tiga -> {
                makeCurrentFragment(medicineFragment)
            }
            }
            false
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_content, fragment)
            commit()
        }
    }
