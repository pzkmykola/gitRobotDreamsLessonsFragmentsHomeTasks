package com.example.gitrobotdreamslessonsfragmentshometasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class SuperheroViewAdapter(private var items:MutableList<SuperHero>, private var  clickListener:(SuperHero)->Unit):
    RecyclerView.Adapter<SuperheroViewAdapter.SuperheroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return SuperheroViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.initialize(items[position])
        holder.itemView.setOnClickListener {
            clickListener(items[position])
        }
    }
    inner class  SuperheroViewHolder(listItemView: View): RecyclerView.ViewHolder(listItemView){
        private val title: TextView = itemView.findViewById(R.id.listTitle)
        private val image: ImageView = itemView.findViewById(R.id.listImage)

        fun initialize(item: SuperHero)
        {
            this.title.text = item.name
            Glide.with(this.itemView.context)
                .load(item.images.url)
                .into(image)
        }
    }
}
