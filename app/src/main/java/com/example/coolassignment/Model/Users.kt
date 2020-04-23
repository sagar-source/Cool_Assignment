package com.example.coolassignment.Model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Users : Parcelable {


    var userId: Int = 0
        private set

    var title: String? = null
        private set

    var body: String? = null
        private set

    constructor() {
        userId = 0
        title = ""
        body = ""

    }

    constructor(`in`: Parcel) {
        userId = `in`.readInt()
        title = `in`.readString()
        body = `in`.readString()

    }


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(userId)
        dest.writeString(title)
        dest.writeString(body)

    }

    companion object CREATOR : Parcelable.Creator<Users> {
        override fun createFromParcel(parcel: Parcel): Users {
            return Users(parcel)
        }

        override fun newArray(size: Int): Array<Users?> {
            return arrayOfNulls(size)
        }
    }

}
