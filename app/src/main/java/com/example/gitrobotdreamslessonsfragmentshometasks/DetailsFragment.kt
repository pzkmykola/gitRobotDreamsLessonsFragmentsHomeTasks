package com.example.gitrobotdreamslessonsfragmentshometasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment : Fragment() {
    private var superHeroName:String = ""
    private lateinit var superHeroPhoto:ImageView
    var nameTextView: TextView? = null
    var imageImageView: ImageView? = null
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
    }

    fun setImage(image:ImageView){
        superHeroPhoto = image
    }

    fun setSuperHeroName(name:String){
        superHeroName = buildString {
            append("Name of this SuperHero: ")
            append( name )
        }
    }

//    fun show(){
//        nameTextView?.text = superHeroName
//    }
}