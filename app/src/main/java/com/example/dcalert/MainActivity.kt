package com.example.dcalert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var MimgCrime:ImageView ?=null
    var MimgViewCrime:ImageView ?=null
    var MimgDisasters:ImageView ?=null
    var MimgViewDisasters:ImageView ?=null
    var MimgAdmins:ImageView ?=null
    var MimgAbout:ImageView ?=null
    var MimgExit:ImageView ?=null
    var MimgCall: ImageView ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()

        MimgCrime=findViewById(R.id.MimgSubmitCrime)

        MimgDisasters=findViewById(R.id.MimgSubmitDisaster)

        MimgCrime=findViewById(R.id.MimgSubmitCrime)
        MimgCrime=findViewById(R.id.MimgSubmitCrime)
        MimgAbout=findViewById(R.id.MimgAbout)
        MimgExit=findViewById(R.id.MimgExit)
        MimgCall=findViewById(R.id.MimgCall)

        MimgCrime !!.setOnClickListener{
            var intents=Intent(this,AlertcrimeActivity::class.java)
            startActivity(intents)

        }


    }
}