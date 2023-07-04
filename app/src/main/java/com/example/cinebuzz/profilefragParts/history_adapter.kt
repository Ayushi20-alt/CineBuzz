package com.example.cinebuzz.profilefragParts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import java.util.ArrayList

class history_adapter(val context: Context, val historyList: ArrayList<wishlistcard_data>):
    RecyclerView.Adapter<history_adapter.historyViewModel>() {

    class historyViewModel(itemView : View): RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.historyimage)
        val txt : TextView = itemView.findViewById(R.id.historyname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): historyViewModel {
        return historyViewModel(LayoutInflater.from(context).inflate(R.layout.history_item, parent, false))
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: historyViewModel, position: Int) {
        holder.img.setImageResource(historyList[position].wishlistmovie)
        holder.txt.text = historyList[position].wishlistname
    }
}