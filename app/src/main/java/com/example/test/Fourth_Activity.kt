package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.AlertDialogBinding

class Fourth_Activity : AppCompatActivity() {

    private lateinit var binding: AlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = AlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr.Devil to your contacts?")
            .setIcon(R.drawable.ic_addcont)
            .setPositiveButton("Yes") { dialogInterface, i ->
                Toast.makeText(this, "You added Devil to your contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { dialogInterface, i ->
                Toast.makeText(this, "You did not add Devil to your contact list", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.alert1.setOnClickListener {
            addContactDialog.show()
        }

        val opt = arrayOf("First","second","Third")
        val Singlechoice = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(opt,0) {
                    dialogInterface, i -> Toast.makeText(this,"You selected ${opt[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Yes") { _,_ ->
                Toast.makeText(this, "You selected one of the items", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_ ->
                Toast.makeText(this, "You did not select one of the items", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.alert2.setOnClickListener {
            Singlechoice.show()
        }

        val multiopt = arrayOf("First","second","Third")
        val Multichoice = AlertDialog.Builder(this)
            .setTitle("Choose any of these options")
            .setMultiChoiceItems(multiopt, booleanArrayOf(false,false,false)){
                _,i,isChecked-> if (isChecked)
            {
                Toast.makeText(this, "You checked ${multiopt[i]}", Toast.LENGTH_SHORT).show()
            }
                else
            {
                Toast.makeText(this, "You unchecked ${multiopt[i]}", Toast.LENGTH_SHORT).show()
            }
            }


            .setPositiveButton("Yes") { _,_ ->
                Toast.makeText(this, "You selected one or more of the items", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_ ->
                Toast.makeText(this, "You did not select any of the items", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.alert3.setOnClickListener {
            Multichoice.show()
        }

        binding.back4.setOnClickListener{
            val next = Intent(this,Third_Activity::class.java)
            startActivity(next)
        }

        binding.next4.setOnClickListener{
            val b = Intent(this,Fifth_Activity::class.java)
            startActivity(b)
        }

    }
}
