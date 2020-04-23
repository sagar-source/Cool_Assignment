package com.example.coolassignment.Activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.widget.Toast

import com.example.coolassignment.Model.Users
import com.example.coolassignment.R
import com.example.coolassignment.Adapter.UserDetailAdapter

import java.util.ArrayList

class UserDetailActivity : AppCompatActivity() {

    internal var userid: String? = null
    internal var list: List<Users>? = ArrayList()
    internal var lis: MutableList<Users> = ArrayList()

    internal lateinit var recyclerView: RecyclerView
    internal lateinit var adapter: UserDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        supportActionBar!!.title = "User Details"

        val bdl = intent.extras
        userid = bdl!!.getString("userid")
        list = bdl.getParcelableArrayList("userdetails")

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@UserDetailActivity)

        for (i in list!!.indices) {
            if (userid == list!![i].userId.toString()) {
                lis.add(list!![i])
            }
        }


        adapter = UserDetailAdapter(this@UserDetailActivity, lis)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter

    }
}
