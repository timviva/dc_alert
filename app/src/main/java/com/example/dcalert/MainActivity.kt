package com.example.dcalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var MtvCrime:TextView?=null
    var MtvDisaster:TextView?=null
    var MtvExit:TextView?=null
    var MtvAbout:TextView?=null
    var MtvEmerg:TextView?=null
    var MtvAdmin:TextView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

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




    }
}