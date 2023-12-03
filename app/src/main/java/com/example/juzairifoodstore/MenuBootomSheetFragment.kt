package com.example.juzairifoodstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juzairifoodstore.adapter.MenuAdapter
import com.example.juzairifoodstore.databinding.FragmentMenuBootomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBootomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var  binding:FragmentMenuBootomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBootomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener{
            dismiss()
        }
        val menuFoodName = listOf("Pizza Dominos", "Paket KFC", "Paket MCD", "Paket Mixue","Paket KFC", "Paket MCD", "Paket Mixue")
        val menuItemPrice = listOf("IDR. 200k", "IDR. 75k", "IDR. 125K", "IDR. 55k", "IDR. 75k", "IDR. 125K", "IDR. 55k")
        val menuImage = listOf(
            R.drawable.domios_menu,
            R.drawable.kfc_menu,
            R.drawable.mcd_menu,
            R.drawable.mixue_menu,
            R.drawable.kfc_menu,
            R.drawable.mcd_menu,
            R.drawable.mixue_menu,
        )
        val adapter = MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemPrice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}