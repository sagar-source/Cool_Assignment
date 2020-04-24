package com.example.coolassignment.Fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.coolassignment.API.FlickrAPI
import com.example.coolassignment.Adapter.ImageAdapter
import com.example.coolassignment.Model.Photo
import com.example.coolassignment.R

import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class FlickrFragment : Fragment() {

    internal lateinit var recyclerView: RecyclerView
    internal lateinit var adapter: ImageAdapter
    internal lateinit var dialog: ProgressDialog
    internal lateinit var requestQueue: RequestQueue

    internal var list: MutableList<Photo> = ArrayList()

 
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_flickr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestQueue = Volley.newRequestQueue(activity!!)

        recyclerView = view.findViewById(R.id.recyclerview_flickr)
        recyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(activity, 2)
        recyclerView.layoutManager = gridLayoutManager


        dialog = ProgressDialog(context)
        dialog.setMessage("please wait")
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        loadData()

    }

    private fun loadData() {

        val postRequest = StringRequest(Request.Method.GET, FlickrAPI.url,
                Response.Listener { response ->
                    dialog.dismiss()
                    try {

                        val obj = JSONObject(response)

                        val photoArray = obj.getJSONObject("photos").getJSONArray("photo")

                        for (i in 0 until photoArray.length()) {

                            val photoObject = photoArray.getJSONObject(i)

                            val photo = Photo(photoObject.getString("id"), photoObject.getString("secret"),
                                    photoObject.getString("server"), photoObject.getInt("farm"))

                            list.add(photo)
                        }


                        adapter = ImageAdapter(activity!!, list)
                        adapter.notifyDataSetChanged()
                        recyclerView.adapter = adapter

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {
                    // error
                    dialog.dismiss()
                }
        )
        requestQueue.add(postRequest)
    }

}
