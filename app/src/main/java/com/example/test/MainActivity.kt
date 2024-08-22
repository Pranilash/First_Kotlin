package com.example.test

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.test.databinding.ActivityMainBinding
import layout.AirplaneModeChangedReciever


class MainActivity : AppCompatActivity() {

//    private var isReceiverRegistered = false

    private lateinit var receiver: AirplaneModeChangedReciever

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

//        receiver = AirplaneModeChangedReciever()

        binding.Access.setOnClickListener{
            requestPermisssion()
        }



//        //Broadcast Receivers
//        val airplane =  IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        registerReceiver(AirplaneModeChangedReciever(),airplane)
//        isReceiverRegistered = true
//        //If we close the activity the broadcast receiver would be still active causing a memory leak
//        //So we unregister the receiver onStop




        // Uncomment and adjust the following as needed:
        // binding.btnSubmit.setOnClickListener {
        //     val fname = binding.etFirstName.text.toString()
        //     val lname = binding.etLastName.text.toString()
        //     val dob = binding.etDOB.text.toString()
        //     val country = binding.etCountry.text.toString()
        //     Log.d("MainActivity", "An Application received from $fname $lname from $country born on $dob")
        // }
        // var count = 0
        // binding.plus.setOnClickListener {
        //     count++
        //     binding.tv2.text = "Iteration Count: $count"
        // }
        // binding.minus.setOnClickListener {
        //     count--
        //     binding.tv2.text = "Iteration Count: $count"
        // }
        // binding.Reset.setOnClickListener {
        //     count = 0
        //     binding.tv2.text = "Iteration Count: $count"
        // }
        // binding.buttonCust.setOnClickListener {
        //     count = binding.custIter.text.toString().toInt()
        //     binding.tv2.text = "Iteration Count: $count"
        // }
        // binding.button2.setOnClickListener {
        //     val n1 = binding.num1.text.toString().toInt()
        //     val n2 = binding.num2.text.toString().toInt()
        //     binding.textView2.text = "Sum = ${n1 + n2}"
        // }
        // binding.btnimg.setOnClickListener {
        //     binding.imgv.setImageResource(R.drawable.asus)
        // }
        // binding.btnres.setOnClickListener {
        //     binding.imgv.setImageResource(R.drawable.hh)
        // }
        // binding.sub.setOnClickListener {
        //     val checked = binding.q1.checkedRadioButtonId
        //     val check = findViewById<RadioButton>(checked)
        //     val DSA = binding.DSA.isChecked
        //     val CP = binding.CP.isChecked
        //     val Acad = binding.Acad.isChecked
        //     val res = "You want to \n" + check.text + if (DSA) "\n DSA" else "" + if (CP) " CP" else "" + if (Acad) " Academics" else ""
        //     binding.Result.text = res
        // }
        // binding.toats.setOnClickListener {
        //     Toast.makeText(applicationContext, "This is a toast", Toast.LENGTH_LONG).show()
        // }

        binding.NewActivity.setOnClickListener {
            val intent = Intent(this, Second_Activity::class.java) // Use MainActivity1::class.java
            startActivity(intent)
        }
    }
    private fun hasLocationAccess() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED


    private fun requestPermisssion(){
        var requestPermissions = mutableListOf<String>()
        if(!hasLocationAccess())
        {
            requestPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }


        if (requestPermissions.isNotEmpty())
        {
            ActivityCompat.requestPermissions(this,requestPermissions.toTypedArray(),0)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0 && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("RequestPermission", "${permissions[i]} granted.")
                } else {
                    Log.d("RequestPermission", "${permissions[i]} denied.")
                }
            }
        }
    }
    override fun onStop() {
        super.onStop()
        // Unregister the receiver if it is registered
//        if (isReceiverRegistered) {
//            unregisterReceiver(receiver)
//            isReceiverRegistered = false
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Unregister the receiver if it is still registered
//        if (isReceiverRegistered) {
//            unregisterReceiver(receiver)
//            isReceiverRegistered = false
//        }
    }


    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onRestart() {
        super.onRestart()
        println("Restart")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.addperson -> Toast.makeText(this,"Added Person",Toast.LENGTH_SHORT).show()
            R.id.Setting -> Toast.makeText(this,"Opening Settings",Toast.LENGTH_SHORT).show()
            R.id.Close -> finish()
            R.id.Favourites -> Toast.makeText(this,"Added Person to Favourites",Toast.LENGTH_SHORT).show()
            R.id.Feedback -> Toast.makeText(this,"Added Feedback",Toast.LENGTH_SHORT).show()
        }




        return true
    }
}
