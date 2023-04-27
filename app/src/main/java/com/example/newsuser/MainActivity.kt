package com.example.newsuser

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsuser.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var refrence: DatabaseReference
    var modelList = ArrayList<NewsModel>()

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        refrence = FirebaseDatabase.getInstance().reference


        refrence.root.child("User").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (snap in snapshot.children) {
                    var model = snap.getValue(NewsModel::class.java)
                    modelList.add(model!!)
                }

                for (data in modelList) {

                    Log.e(TAG, "onDataChange: ============== " + data.title)
                    Log.e(TAG, "onDataChange: ============== " + data.description)
                    Log.e(TAG, "onDataChange: ============== " + data.key)
                    Log.e(TAG, "onDataChange: ============== " + data.img)
                    Log.e(TAG, "onDataChange: ==============------------------")
                }

                binding.rcvNews.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rcvNews.adapter = NewsAdapter(modelList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}