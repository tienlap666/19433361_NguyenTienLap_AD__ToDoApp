package com.example.a19433361_nguyentienlap_ad_todoapp

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recylerview_work.view.*
class RecyclerviewAdapter(private val list:ArrayList<User>) : RecyclerView.Adapter<RecyclerviewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recylerview_work,parent,false)

        return  RecyclerViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = list[position]
        holder.txtWork.text = currentItem.work
        val redText = SpannableString(currentItem.status)
        if (currentItem.status.equals("Not Complete")){
            redText.setSpan(ForegroundColorSpan(Color.RED),0,redText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        holder.txtStatus.text = redText

        //
        holder.cardView.setOnClickListener {

            holder.cardView.setCardBackgroundColor(Color.GRAY)

        }



    }

    override fun getItemCount(): Int {
        return list.size
    }
    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtWork: TextView = itemView.txtWorkRe
        val txtStatus: TextView = itemView.txtStatusRe
        val cardView: CardView = itemView.cardView
    }
}