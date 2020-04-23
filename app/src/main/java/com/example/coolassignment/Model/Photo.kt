package com.example.coolassignment.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Photo(id: String, secret: String, server: String, farm: Int) {

    var id: String
        internal set
    var secret: String
        internal set
    var server: String
        internal set
    var farm: Int = 0
        internal set

    init {
        this.id = id
        this.secret = secret
        this.server = server
        this.farm = farm
    }
}
