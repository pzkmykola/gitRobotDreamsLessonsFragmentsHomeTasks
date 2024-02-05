package com.example.gitrobotdreamslessonsfragmentshometasks

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  SuperheroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val title: TextView = itemView.findViewById(R.id.listTitle)
    val image: ImageView = itemView.findViewById(R.id.listImage)
}