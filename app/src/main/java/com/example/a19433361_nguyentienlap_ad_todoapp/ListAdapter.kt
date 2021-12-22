package com.example.a19433361_nguyentienlap_ad_todoapp

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter (var mCtx:Context, var resource:Int, var item:List<User>): ArrayAdapter<User>(mCtx,resource,item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(resource,null)

        val txtWork: TextView = view.findViewById(R.id.txtWork)
        val txtStatus: TextView = view.findViewById(R.id.txtStatus)

        var mItem:User =  item[position]
        txtWork.text = mItem.work
        val redText = SpannableString(mItem.status)
        if (mItem.status=="Not Complete"){

            redText.setSpan(ForegroundColorSpan(Color.RED),0,redText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        txtStatus.text =redText


        return view
    }
}