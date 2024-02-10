package com.example.gitrobotdreamslessonsfragmentshometasks

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailsFragment : Fragment() {
    private var superHeroName:String = ""
    private var superHeroPhoto:String = ""
    var nameTextView: TextView? = null
    lateinit var imageImageView: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameTextView = view.findViewById(R.id.nameOfSH)
        imageImageView = view.findViewById(R.id.imageOfSH)
        nameTextView?.text = superHeroName
        if(superHeroPhoto != "") showImage()
    }

    fun setImage(item: SuperHero){
        superHeroPhoto = item.images.largeImage
    }

    fun setSuperHeroName(name:String){
        superHeroName = buildString {
            append("Name of this SuperHero: ")
            append( name )
        }
    }

    fun showImage()
    {
        //val myContext = requireContext()
        Glide.with(this)
            .load(superHeroPhoto)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(com.google.android.material.R.drawable.mtrl_ic_error)
            )
            .into(imageImageView)
    }
}