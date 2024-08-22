package com.example.test

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.test.databinding.ActivityMain2Binding

class Third_Activity : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding

    private val getContent: ActivityResultLauncher<String> = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            // Handle the URI of the selected content
            binding.imgv.setImageURI(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

         binding.btnimg.setOnClickListener {
             binding.imgv.setImageResource(R.drawable.asus)
         }

         binding.btnres.setOnClickListener {
             getContent.launch("image/*")

         }
         binding.sub.setOnClickListener {
             val checked = binding.q1.checkedRadioButtonId
             val check = findViewById<RadioButton>(checked)
             val DSA = binding.DSA.isChecked
             val CP = binding.CP.isChecked
             val Acad = binding.Acad.isChecked
             val res = "You want to \n" + check.text + if (DSA) "\n DSA" else "" + if (CP) " CP" else "" + if (Acad) " Academics" else ""
             binding.Result.text = res
         }
         binding.toats.setOnClickListener {
             Toast.makeText(applicationContext, "This is a toast", Toast.LENGTH_LONG).show()
         }

        binding.back.setOnClickListener{
                val back = Intent(this,Two_Half_Acitvity::class.java)
            startActivity(back)
        }

        binding.next3.setOnClickListener{
            val next = Intent(this,Fourth_Activity::class.java)
            startActivity(next)
        }

    }
}