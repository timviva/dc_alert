package com.example.dcalert

import android.Manifest
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var MtvCrime:CardView?=null
    var MtvDisaster:CardView?=null
    var MtvExit:CardView?=null
    var MtvAbout:CardView?=null
    var MtvEmerg:CardView?=null
    var MtvAdmin:CardView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        MtvCrime=findViewById(R.id.MtvCrimeAlert)
        MtvDisaster=findViewById(R.id.MtvDisasterAlert)
        MtvAdmin=findViewById(R.id.MtvAdmin)
        MtvAbout=findViewById(R.id.MtvAbout)
        MtvExit=findViewById(R.id.MimgExit)
        MtvEmerg=findViewById(R.id.MtvEmergencyCall)

        MtvCrime !!.setOnClickListener{
            var intents=Intent(this,AlertcrimeActivity::class.java)
            startActivity(intents)

        }
        MtvAdmin !!.setOnClickListener{
            var intents=Intent(this,RegisterActivity::class.java)
            startActivity(intents)

        }
        MtvDisaster !!.setOnClickListener{
            var intents=Intent(this,AlertdisasterActivity::class.java)
            startActivity(intents)


        }
        MtvEmerg!!.setOnClickListener{
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+254745525971"))
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        MtvExit!!.setOnClickListener{
            val alertDialog= AlertDialog.Builder(this)

            alertDialog.setTitle("Exit Dialog")
            alertDialog.setMessage("Do you want to Exit ?")

            alertDialog.setPositiveButton("Yes",
                DialogInterface.OnClickListener{ dialogInterface, i ->
                    finish()
                })
            alertDialog.setNegativeButton("No",
                DialogInterface.OnClickListener{ dialogInterface, i ->
                    var intent=Intent(this,MainActivity::class.java)
                    startActivity(intent)
                })



            alertDialog.create().show()

        }
        MtvAbout !!.setOnClickListener{
            val alertDialog= AlertDialog.Builder(this)

            alertDialog.setTitle("ABOUT DIALOG")
            alertDialog.setMessage("This app is designed to alert whoever is concerned like Police , Red Cross etc On Crimes calamities as they occur.The user is Allowed to submit details in which the admin will login and view the crimes or disasters nearby")


            alertDialog.create().show()
        }


    }
}