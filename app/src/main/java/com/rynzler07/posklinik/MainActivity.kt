package com.rynzler07.posklinik


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Membuat fragment objek
    lateinit var dokterFragment: DokterFragment
    lateinit var patientFragment: PatientFragment
    lateinit var medicineFragment: MedicineFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Membuat framelayout dan bottomnav
        var bottomnav: BottomNavigationView? = findViewById<BottomNavigationView>(R.id.navigation_bottom_view)
        var frameLayout: FrameLayout? = findViewById<FrameLayout>(R.id.framelayout_content)

        // Membuat Set default Fragment
        dokterFragment = DokterFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout_content, dokterFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        // Memanggil 3 Fragment yang sudah dibuat
        bottomnav?.setOnNavigationItemReselectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_satu -> {
                    dokterFragment = DokterFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout_content, dokterFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                    R.id.navigation_dua -> {
                    patientFragment = PatientFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout_content, patientFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                    R.id.navigation_tiga -> {
                    medicineFragment = MedicineFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.framelayout_content, medicineFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

        false

        }

    }
}