package com.example.gitrobotdreamslessonsfragmentshometasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.animation.AnimatableView

//class SuperheroViewAdapter(private val items:MutableList<SuperHero>, val onClick:(String)->Unit):
//    RecyclerView.Adapter<SuperheroViewHolder>() {
class SuperheroViewAdapter(private val items:MutableList<SuperHero>, private var listener: OnSuperheroItemClickListener):

    RecyclerView.Adapter<SuperheroViewAdapter.SuperheroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return SuperheroViewHolder(listItemView)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.title.text = items[position].name
        val load = Glide.with(holder.itemView.context)
            .load(items[position].images.url)
            .into(holder.image)
        val onClick:String = items[position].name.toString()
        holder.itemView.setOnClickListener { listener}
    }
    class  SuperheroViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.listTitle)
        val image: ImageView = itemView.findViewById(R.id.listImage)

        fun initialize(item: SuperHero, action: OnSuperheroItemClickListener)
        {
            this.title.text = item.name
            val load = Glide.with(this.itemView.context)
                .load(item.images.url)
                .into(image)

            this.itemView.setOnClickListener {
                //action.
            }
        }
    }

    interface OnSuperheroItemClickListener{
        onItemClick(item: SuperHero, position: Int)
        //fun onClick(lambda: (String) -> Unit)
    }
}
