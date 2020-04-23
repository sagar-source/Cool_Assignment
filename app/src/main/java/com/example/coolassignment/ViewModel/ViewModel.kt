package com.example.coolassignment.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.coolassignment.API.API
import com.example.coolassignment.Model.Users
import com.example.coolassignment.NetworkClient.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class ViewModel : androidx.lifecycle.ViewModel() {


    private var userList: MutableLiveData<List<Users>>? = null


    val users: LiveData<List<Users>>
        get() {

            if (userList == null) {
                userList = MutableLiveData()

                loadUsers()
            }

            return userList as MutableLiveData<List<Users>>
        }


    private fun loadUsers() {

        val retrofit = RetrofitClient.retrofitClient

        val api = retrofit!!.create<API>(API::class.java)
        val call = api.users


        call.enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {

                userList!!.setValue(response.body())
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {

            }
        })
    }

}
