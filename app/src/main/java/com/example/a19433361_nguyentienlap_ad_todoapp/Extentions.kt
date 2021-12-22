package com.example.a19433361_nguyentienlap_ad_todoapp

import android.app.Activity
import android.widget.Toast

object Extentions {
    fun Activity.toast(msg: String){
        Toast.makeText(this, msg ,Toast.LENGTH_SHORT).show()
    }
}