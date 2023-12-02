package com.example.juzairifoodstore

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.juzairifoodstore.databinding.ActivityChoseLocationBinding

class ChoseLocationActivity : AppCompatActivity() {
    private val binding: ActivityChoseLocationBinding by lazy {
        ActivityChoseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationList = arrayOf("Jambi", "Kerinci", "Batang Hari", "Muaro Bulian", "Muaro Bungo")
        val adapter = ArrayAdapter(this, android.R.layout.activity_list_item, locationList)
        val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)
    }
}