package com.example.coolassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.coolassignment.Model.Users
import com.example.coolassignment.R

class UserDetailAdapter(internal var mCtx: Context, internal var List: List<Users>) : RecyclerView.Adapter<UserDetailAdapter.UserDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailAdapter.UserDetailViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.userdetaillayout, parent, false)
        return UserDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDetailAdapter.UserDetailViewHolder, position: Int) {
        holder.text_title.text = List[position].title
        holder.text_message.text = List[position].body


        holder.itemView.setOnClickListener {
            currentPosition = position

            notifyDataSetChanged()
        }

        if (currentPosition == position) {

            val slideDown = AnimationUtils.loadAnimation(mCtx, R.anim.slide_down)

            holder.linearLayout.visibility = View.VISIBLE

            holder.linearLayout.startAnimation(slideDown)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class UserDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var linearLayout: LinearLayout
        var text_title: TextView
        var text_message: TextView

        init {

            linearLayout = itemView.findViewById(R.id.linearlayout)
            text_title = itemView.findViewById(R.id.txt_user_title)
            text_message = itemView.findViewById(R.id.txt_user_message)
        }
    }

    companion object {

        private var currentPosition = 0
    }
}


