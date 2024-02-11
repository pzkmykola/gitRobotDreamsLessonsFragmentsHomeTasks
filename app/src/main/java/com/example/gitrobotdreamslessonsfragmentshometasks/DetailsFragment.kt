package com.example.gitrobotdreamslessonsfragmentshometasks

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannedString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.toSpannable
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class DetailsFragment : Fragment() {
    private var superHeroName:String = ""
    private var superHeroIntelligence:String = ""
    private var superHeroStrenght:String = ""
    private var superHeroAsCombat:String = ""
    private var superHeroPhoto:String = ""
    private var superHeroGender:String = ""
    private var superHeroRace:String = ""
    private var superHeroHeight:String = ""
    private var superHeroBioFA:String = ""
    private var superHeroBioPubl:String = ""
    var nameTextView: TextView? = null
    var intelligenceTextView: TextView? = null
    var strengthTextView: TextView? = null
    var combatTextView: TextView? = null
    var genderTextView: TextView? = null
    var raceTextView: TextView? = null
    var heightTextView: TextView? = null
    var firstAppearenceTextView: TextView? = null
    var publishedTextView: TextView? = null
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
        intelligenceTextView = view.findViewById(R.id.intelligenceDetails)
        strengthTextView = view.findViewById(R.id.strengthDetails)
        combatTextView = view.findViewById(R.id.combatDetails)
        genderTextView = view.findViewById(R.id.genderDetails)
        raceTextView = view.findViewById(R.id.raceDetails)
        heightTextView = view.findViewById(R.id.heightInSmDetails)
        firstAppearenceTextView = view.findViewById(R.id.firstAppearance)
        publishedTextView = view.findViewById(R.id.publisher)

        nameTextView?.text = superHeroName
        intelligenceTextView?.text = superHeroIntelligence
        strengthTextView?.text = superHeroStrenght
        combatTextView?.text = superHeroAsCombat
        genderTextView?.text = superHeroGender
        raceTextView?.text = superHeroRace
        heightTextView?.text = superHeroHeight
        firstAppearenceTextView?.text = superHeroBioFA
        publishedTextView?.text = superHeroBioPubl

        if(superHeroPhoto != "") showImage()
    }

    fun setImage(item: SuperHero){
        superHeroPhoto = item.images.largeImage
    }

    fun setSuperHeroName(name:String){
        superHeroName = buildString {
            append("The name of SuperHero is ")
            append( name )
        }
    }

    fun setSuperHeroPowerStatsAndAppearance(item: SuperHero){
        superHeroIntelligence = item.powerstats.intelligence.toString()
        superHeroStrenght = item.powerstats.strength.toString()
        superHeroAsCombat = item.powerstats.combat.toString()
        superHeroGender = item.appearance.gender
        superHeroRace = item.appearance.race
        superHeroHeight = item.appearance.height[1].toString()
    }
    fun setSuperHeroSomeBioDetails(item: SuperHero) {
        superHeroBioFA = item.biography.firstAppearance
        superHeroBioPubl = item.biography.publisher
    }

    fun showImage()
    {
        Glide.with(this)
            .load(superHeroPhoto)
            .apply(RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(com.google.android.material.R.drawable.mtrl_ic_error)
            )
            .into(imageImageView)
    }
}