package com.example.coolassignment.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.coolassignment.Activity.ImageViewActivity
import com.example.coolassignment.Model.Photo
import com.example.coolassignment.R

class ImageAdapter(internal var mCtx: Context, internal var photoList: List<Photo>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    internal lateinit var id: String
    internal lateinit var server: String
    internal lateinit var secret: String
    internal lateinit var url: String

    internal var farm: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(mCtx).inflate(R.layout.grid_image_layout, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        id = photoList[position].id
        secret = photoList[position].secret
        server = photoList[position].server
        farm = photoList[position].farm

        url = "https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg"

        Glide.with(mCtx)
                .setDefaultRequestOptions(RequestOptions().timeout(300000))
                .load(url)
                .into(holder.imageView)

        holder.itemView.setOnClickListener {
            id = photoList[position].id
            secret = photoList[position].secret
            server = photoList[position].server
            farm = photoList[position].farm

            url = "https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg"

            val intent = Intent(mCtx, ImageViewActivity::class.java)
            intent.putExtra("url", url)
            mCtx.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var img_show: ImageView

        init {

            imageView = itemView.findViewById(R.id.img)
            img_show = itemView.findViewById(R.id.img_show)

        }
    }

}


