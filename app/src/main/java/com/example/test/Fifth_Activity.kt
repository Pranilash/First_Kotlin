package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.test.databinding.AlertDialogBinding
import com.example.test.databinding.SpinnerBinding

class Fifth_Activity : AppCompatActivity() {
    private lateinit var binding: SpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //If you only know the items before run time and should update them then You can!!
        val custlist = listOf<String>("First","Second","Third")
        val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,custlist)
//        binding.month.adapter = adapter

        binding.month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@Fifth_Activity, "You selected ${selectedItem}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }




    }
}