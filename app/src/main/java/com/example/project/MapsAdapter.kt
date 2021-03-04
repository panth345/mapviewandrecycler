package com.example.project

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import model.UserMap
private const val TAG = "MapsAdapter"

class MapsAdapter(val context : Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(position: Int)

        fun onItemLongClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userMap = userMaps[position]
        val textviewitem = holder.itemView.findViewById<TextView>(android.R.id.text1)
        holder.itemView.setOnClickListener {
            Log.i(TAG, "Tapped on position $position")
           onClickListener.onItemClick(position)

        }
        holder.itemView.setOnLongClickListener {
           onClickListener.onItemLongClick(position)
            return@setOnLongClickListener true
        }
      //  val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTItle)
        textviewitem.text = userMap.title
    }
}

