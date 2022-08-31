package com.example.dcalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class AlertdisasterActivity : AppCompatActivity() {
    var MedtName: EditText? = null
    var MedtEmail: EditText? = null
    var MedtCrimeDesc: EditText? = null
    var MedtCrimePlace: EditText? = null
    var MedtCrimeDate: EditText? = null
    var MedtCrimeTime: EditText? = null
    var MbtnSubmit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertdisaster)
        MedtName = findViewById(R.id.UserFullNameD)
        MedtEmail = findViewById(R.id.UserEmailD)
        MedtCrimeDesc = findViewById(R.id.DisDescription)
        MbtnSubmit = findViewById(R.id.BtnSubmitDisaster)
        MedtCrimeTime = findViewById(R.id.MedtTimeD)
        MedtCrimeDate = findViewById(R.id.MedtDateD)
        MedtCrimePlace = findViewById(R.id.DisPlace)



        MbtnSubmit!!.setOnClickListener {
            val userName = MedtName!!.text.toString().trim()
            val userEmail = MedtEmail!!.text.toString().trim()
            val userCrimeDescription = MedtCrimeDesc!!.text.toString().trim()
            val userTime = MedtCrimeTime!!.text.toString().trim()
            val userDate = MedtCrimeDate!!.text.toString().trim()
            val userCrimePlace = MedtCrimePlace!!.text.toString().trim()
            val id = System.currentTimeMillis().toString()

            if (userName.isEmpty()) {
                MedtName!!.setError("PLease fill this field!!")
                MedtName!!.requestFocus()
            } else if (userEmail.isEmpty()) {
                MedtEmail!!.setError("PLease fill this field!!")
                MedtEmail!!.requestFocus()
            } else if (userCrimeDescription.isEmpty()) {
                MedtCrimeDesc!!.setError("PLease fill this field!!")
                MedtCrimeDesc!!.requestFocus()
            } else if (userCrimePlace.isEmpty()) {
                MedtCrimePlace!!.setError("PLease fill this field!!")
                MedtCrimePlace!!.requestFocus()
            } else if (userDate.isEmpty()) {
                MedtCrimeDate!!.setError("PLease fill this field!!")
                MedtCrimeDate!!.requestFocus()
            } else if (userTime.isEmpty()) {
                MedtCrimeTime!!.setError("PLease fill this field!!")
                MedtCrimeTime!!.requestFocus()
            } else {
//                proceed to save the data
                val userData=User(userName,userEmail,userCrimeDescription,id,userCrimePlace, userDate, userTime)
//                create a reference to the database to store data
                val reference = FirebaseDatabase.getInstance().getReference().child("UserTwo/$id")
                reference.setValue(userData).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "Data Saving successfull",
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (task.isSuccessful) {
                        Toast.makeText(applicationContext, "Data Saving Failed", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }

    }
}