package com.example.test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMain1Binding

class Second_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val fname = binding.etFirstName.text.toString()
            val lname = binding.etLastName.text.toString()
            val dob = binding.etDOB.text.toString()
            val country = binding.etCountry.text.toString()
            Log.d("Second_Activity", "An Application received from $fname $lname from $country born on $dob")
            val person = Person_Details("$fname $lname",dob,country)
         val message = Intent(this,Two_Half_Acitvity::class.java)
//            message.putExtra("Name", "$fname $lname")
//            message.putExtra("DOB",dob)
//            message.putExtra("Country",country)
            // Instead of using put extra each time, we created a class that helps us ease the use

            message.putExtra("Person",person)

            startActivity(message)

        }

        var count = 0
        binding.plus.setOnClickListener {
            count++
            binding.tv2.text = "Iteration Count: $count"
        }

        binding.minus.setOnClickListener {
            count--
            binding.tv2.text = "Iteration Count: $count"
        }

        binding.Reset.setOnClickListener {
            count = 0
            binding.tv2.text = "Iteration Count: $count"
        }

        binding.buttonCust.setOnClickListener {
            count = binding.custIter.text.toString().toInt()
            binding.tv2.text = "Iteration Count: $count"
        }

        binding.button2.setOnClickListener {
            val n1 = binding.num1.text.toString().toInt()
            val n2 = binding.num2.text.toString().toInt()
            binding.textView2.text = "Sum = ${n1 + n2}"
        }

        binding.back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.next.setOnClickListener{
        val next = Intent(this,Two_Half_Acitvity::class.java)
        startActivity(next)
        }



    }
}


//Some notes regaarding Fragment vs Activity
//
//It looks like you're attempting to use Fragment as your Second_Activity but are encountering issues because Fragment is not suitable as an activity.
// You should be using Fragment when you want to manage UI components that are a part of an Activity, but if you need a full screen UI component that can be launched as an independent entity, you should use Activity.
//
//Here's a guide to correct this:
//
//Converting Second_Activity from Fragment to Activity
//Change the Class to Extend AppCompatActivity:
//Update your Second_Activity to extend AppCompatActivity instead of Fragment. This will make it a standalone activity.
//
//Update onCreate Method:
//Move UI setup code to the onCreate method and use setContentView to set up the activity’s layout.
//
//Remove Fragment-Specific Methods:
//Remove methods and properties that are specific to Fragment, like onViewCreated and _binding.
//
//Corrected Code Example:
//Here's how you can adjust your Second_Activity to be a proper Activity:
//
//kotlin
//Copy code
//package com.example.test
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import com.example.test.databinding.ActivityMain1Binding
//
//class Second_Activity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMain1Binding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMain1Binding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnSubmit.setOnClickListener {
//            val fname = binding.etFirstName.text.toString()
//            val lname = binding.etLastName.text.toString()
//            val dob = binding.etDOB.text.toString()
//            val country = binding.etCountry.text.toString()
//            Log.d("Second_Activity", "An Application received from $fname $lname from $country born on $dob")
//        }
//
//        var count = 0
//        binding.plus.setOnClickListener {
//            count++
//            binding.tv2.text = "Iteration Count: $count"
//        }
//
//        binding.minus.setOnClickListener {
//            count--
//            binding.tv2.text = "Iteration Count: $count"
//        }
//
//        binding.Reset.setOnClickListener {
//            count = 0
//            binding.tv2.text = "Iteration Count: $count"
//        }
//
//        binding.buttonCust.setOnClickListener {
//            count = binding.custIter.text.toString().toInt()
//            binding.tv2.text = "Iteration Count: $count"
//        }
//
//        binding.button2.setOnClickListener {
//            val n1 = binding.num1.text.toString().toInt()
//            val n2 = binding.num2.text.toString().toInt()
//            binding.textView2.text = "Sum = ${n1 + n2}"
//        }
//
//        binding.back.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
//Key Changes:
//Inheritance: Changed Second_Activity to extend AppCompatActivity.
//Binding Initialization: Used ActivityMain1Binding.inflate(layoutInflater) and setContentView(binding.root) to set up the layout.
//UI Interaction: Moved onCreate logic to handle UI interactions.
//AndroidManifest.xml Update:
//Ensure that Second_Activity is declared in your AndroidManifest.xml:
//
//xml
//Copy code
//<application
//... >
//<activity android:name=".Second_Activity" />
//<!-- Other activities -->
//</application>
//Additional Notes:
//Fragment vs Activity: Remember, a Fragment is a modular part of an Activity, while an Activity represents a full screen UI component.
//Lifecycle Methods: Use onCreate, onStart, onResume, etc., in activities. For fragments, use onCreateView, onViewCreated, etc.
//By making these adjustments, you will resolve the ClassCastException and correctly set up your Second_Activity as a full-screen activity.