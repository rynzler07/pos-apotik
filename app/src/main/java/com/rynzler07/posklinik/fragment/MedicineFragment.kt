package com.rynzler07.posklinik.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rynzler07.posklinik.R

/**
 * A simple [Fragment] subclass.
 * Use the [MedicineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicineFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine, container, false)
    }
}