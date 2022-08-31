package com.example.dcalert

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CrimeActivity : AppCompatActivity() {
    var MbtnDisasters:Button?= null
    var listusers: ListView?=null
    var Adapter:CustomAdapter ?=null
    var users:ArrayList<User> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crime)
        MbtnDisasters=findViewById(R.id.MbtnDisasters)
        MbtnDisasters!!.setOnClickListener {
            var intent= Intent(this,DisasterActivity::class.java)
            startActivity(intent)
        }
        listusers=findViewById(R.id.MlistCrime)
        users=ArrayList()
        Adapter = CustomAdapter(this, users!!)
        val reference= FirebaseDatabase.getInstance().
        getReference().child("User")
        reference.addValueEventListener(object : ValueEventListener {
            //            Override on data changed
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
//    User for loop to add the user on the arraylist
                for (snap in  snapshot.children){
                    var user=snap.getValue(User::class.java)
                    users!!.add(user!!)
                }
                Adapter!!.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext,"Please Contact the Admin", Toast.LENGTH_LONG).show()
            }
        })
        listusers!!.adapter=Adapter!!

//        Set on item click listener to the listview
        listusers!!.setOnItemClickListener { adapterView, view, i, l ->
            val UserId= users!!.get(i).Id
            val  deletionReference=FirebaseDatabase.getInstance().getReference().child("User/$UserId")
            val alertDialog=AlertDialog.Builder(this)

            alertDialog.setTitle("Alert!!!")
            alertDialog.setMessage("Delete this information if it's irrelevant")

            alertDialog.setNeutralButton("Delete",DialogInterface.OnClickListener{dialogInterface, i ->
                deletionReference.removeValue()
                Toast.makeText(applicationContext,"Deleted Successfully",Toast.LENGTH_LONG).show()
            })
            alertDialog.create().show()

        }

    }


}


















