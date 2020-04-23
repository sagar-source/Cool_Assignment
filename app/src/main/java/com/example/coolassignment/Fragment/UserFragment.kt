package com.example.coolassignment.Fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.coolassignment.Model.Users
import com.example.coolassignment.R
import com.example.coolassignment.Adapter.UserAdapter
import com.example.coolassignment.ViewModel.ViewModel

import java.util.ArrayList
import java.util.HashMap

class UserFragment : Fragment() {

    internal lateinit var recyclerView: RecyclerView

    internal lateinit var adapter: UserAdapter

    internal lateinit var dialog: ProgressDialog

    internal lateinit var model: ViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)


        dialog = ProgressDialog(activity)
        dialog.setMessage("please wait")
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        model = ViewModelProviders.of(this).get(ViewModel::class.java)

        loadData()
    }

    private fun loadData() {

        model.users.observe(activity!!, Observer { userList ->
            val hashMap = HashMap<Any,Any>()
            for (i in userList!!.indices) {
                hashMap.put(userList[i].userId, userList[i])

            }

            val list_key = ArrayList<Any>()
            list_key.addAll(hashMap.keys)


            adapter = UserAdapter(activity!!, list_key, userList)
            adapter.notifyDataSetChanged()
            recyclerView.adapter = adapter
            dialog.dismiss()
        })
    }
}
