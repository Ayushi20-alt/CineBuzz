package com.example.cinebuzz.profilefragParts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R

class wishlistadapter(val context: Context, val arrList : ArrayList<wishlistcard_data>):
    RecyclerView.Adapter<wishlistadapter.Myviewholder1>() {

    class Myviewholder1(itemView : View): RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.wishlistimage)
        val txt : TextView = itemView.findViewById(R.id.textView15)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder1 {
        return Myviewholder1(LayoutInflater.from(context).inflate(R.layout.wishlist_item, parent, false))

    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: Myviewholder1, position: Int) {
        holder.img.setImageResource(arrList[position].wishlistmovie)
        holder.txt.text = arrList[position].wishlistname
    }


}