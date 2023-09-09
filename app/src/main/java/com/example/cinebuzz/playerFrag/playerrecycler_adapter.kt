package com.example.cinebuzz.playerFrag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.R
import com.example.cinebuzz.profilefragParts.history_adapter
import com.example.cinebuzz.profilefragParts.wishlistcard_data
import java.util.ArrayList

class playerrecycler_adapter(val context: Context, val playerList: ArrayList<PlayerData_class>):
    RecyclerView.Adapter<playerrecycler_adapter.playerViewModel>() {
    class playerViewModel(itemView : View): RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.playercardimage)
        val txt : TextView = itemView.findViewById(R.id.player1text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): playerViewModel {
        return playerViewModel(
            LayoutInflater.from(context).inflate(R.layout.player_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    override fun onBindViewHolder(holder: playerViewModel, position: Int) {
        holder.img.setImageResource(playerList[position].movieImage)
        holder.txt.text = playerList[position].label
    }
}