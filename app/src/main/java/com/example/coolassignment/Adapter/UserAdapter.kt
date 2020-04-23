package com.example.coolassignment.Adapter

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.coolassignment.Activity.UserDetailActivity
import com.example.coolassignment.Model.Users
import com.example.coolassignment.R


import java.util.ArrayList

class UserAdapter(internal var mCtx: Context, internal var userList: ArrayList<*>, internal var valueList: List<Users>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.userlayout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textView.text = userList[position].toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(mCtx, UserDetailActivity::class.java)
            intent.putExtra("userid", userList[position].toString())
            intent.putParcelableArrayListExtra("userdetails", valueList as ArrayList<out Parcelable>)
            mCtx.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView: TextView

        init {

            textView = itemView.findViewById(R.id.txt_user_id)
        }
    }
}

