package com.example.test

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.test.databinding.ActivityMain1Binding
import com.example.test.databinding.ActivityMain3Binding
import java.util.jar.Attributes.Name

class Two_Half_Acitvity : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        val name = intent.getStringExtra("Name")
//        val dob = intent.getStringExtra("DOB")
//        val country = intent.getStringExtra("Country")
//
//        val msg = "An Application received from $name from $country born on $dob"

        val person_det = intent.getSerializableExtra("Person",Person_Details::class.java)

        val text = "An Application received from ${person_det?.Name} from ${person_det?.Country} born on ${person_det?.DOB}"

        binding.textView.text = text

        binding.next1.setOnClickListener{
            val next = Intent(this,Third_Activity::class.java)
            startActivity(next)


        }

        binding.back1.setOnClickListener{
            val next = Intent(this,Second_Activity::class.java)
            startActivity(next)
        }



    }
}