package com.example.juzairifoodstore.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juzairifoodstore.R
import com.example.juzairifoodstore.adapter.BuyAgainAdapter
import com.example.juzairifoodstore.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        return binding.root
    }
private fun setupRecyclerView(){
    val buyAgainFoodName = arrayListOf("Makanan 2", "Makanan 2", "Makanan 3")
    val buyAgainFoodPrice = arrayListOf("IDR. 180K", "IDR. 100K", "IDR. 80K")
    val buyAgainFoodImage = arrayListOf(R.drawable.pizzahut_menu,R.drawable.kfc_menu,R.drawable.domios_menu)
    buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
    binding.buyAgainRecyclerView.adapter = buyAgainAdapter
    binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
}
    companion object {

    }
}