package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.databinding.RecyclerViewBinding
import com.example.test.databinding.SpinnerBinding

class Sixth_Activity : AppCompatActivity() {

    private lateinit var binding: RecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}