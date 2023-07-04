package com.example.cinebuzz
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinebuzz.dataclass.searchMoviemodelclass


class searchAdapter(var arrlist : ArrayList<searchMoviemodelclass>) : RecyclerView.Adapter<searchAdapter.MyviewHolder>(){

    inner class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val txt : TextView = itemView.findViewById(R.id.searchtxtitem)
    }

    fun setFilteredList(arrlist: ArrayList<searchMoviemodelclass>){
        this.arrlist = arrlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.searchitem, parent, false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrlist.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.txt.text = arrlist[position].name
    }

}