package com.example.bias_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Idol(val nombre:String, val alias: String , val bio: String, val calificacion: Float) :
    Parcelable {
}