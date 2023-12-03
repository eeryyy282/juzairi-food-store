package com.example.juzairifoodstore.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.juzairifoodstore.MenuBootomSheetFragment
import com.example.juzairifoodstore.R
import com.example.juzairifoodstore.adapter.PopularAdapter
import com.example.juzairifoodstore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container, false)

        binding.viewAllMenu.setOnClickListener{
            val bottomSheetDialog = MenuBootomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.kfc, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.mcd, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.starbuck, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.pizzahut, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.mixue, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMassage = "Gambar Dipilih $position"
                Toast.makeText(requireContext() ,itemMassage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Pizza Dominos", "Paket KFC", "Paket MCD", "Paket Mixue", "Pizza PizzaHut")
        val Price = listOf("IDR. 200k", "IDR. 75k", "IDR. 125K", "IDR. 55k", "IDR. 180k")
        val popularFoodImages =
            listOf(R.drawable.domios_menu, R.drawable.kfc_menu, R.drawable.mcd_menu, R.drawable.mixue_menu, R.drawable.pizzahut_menu)
        val adapter = PopularAdapter(foodName, Price, popularFoodImages)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter
    }
}