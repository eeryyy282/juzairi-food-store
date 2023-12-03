package com.example.juzairifoodstore.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.juzairifoodstore.R
import com.example.juzairifoodstore.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: com.example.juzairifoodstore.adapter.MenuAdapter
    private val  originalMenuFoodName = listOf("Pizza Dominos", "Paket KFC", "Paket MCD", "Paket Mixue","Paket KFC", "Paket MCD", "Paket Mixue")
    private val originalMenuItemPrice = listOf("IDR. 200k", "IDR. 75k", "IDR. 125K", "IDR. 55k", "IDR. 75k", "IDR. 125K", "IDR. 55k")
    private val originalMenuImage = listOf(
        R.drawable.domios_menu,
        R.drawable.kfc_menu,
        R.drawable.mcd_menu,
        R.drawable.mixue_menu,
        R.drawable.kfc_menu,
        R.drawable.mcd_menu,
        R.drawable.mixue_menu,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
private val filteredMenuFoodName = mutableListOf<String>()
private val filteredMenuItemPrice = mutableListOf<String>()
private val filteredMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false )
        adapter = com.example.juzairifoodstore.adapter.MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage)
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup untuk search view
        setupSearchView()
        //menampilkan semua menuItems
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })

    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}