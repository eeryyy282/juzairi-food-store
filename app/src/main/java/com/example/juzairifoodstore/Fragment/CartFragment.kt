package com.example.juzairifoodstore.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juzairifoodstore.R
import com.example.juzairifoodstore.adapter.CartAdapter
import com.example.juzairifoodstore.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)


        val cartFoodName = listOf("Pizza Dominos", "Paket KFC", "Paket MCD", "Paket Mixue")
        val cartItemPrice = listOf("IDR. 200k", "IDR. 75k", "IDR. 125K", "IDR. 55k")
        val cartImage = listOf(
            R.drawable.domios_menu,
            R.drawable.kfc_menu,
            R.drawable.mcd_menu,
            R.drawable.mixue_menu,
        )
        val adapter = CartAdapter(ArrayList(cartFoodName), ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycleView.adapter = adapter
        return binding.root
    }

    companion object {


    }
}