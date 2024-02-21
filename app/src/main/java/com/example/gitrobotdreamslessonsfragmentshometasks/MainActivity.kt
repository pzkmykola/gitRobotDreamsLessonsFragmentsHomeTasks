package com.example.gitrobotdreamslessonsfragmentshometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(itemSuperHero: SuperHero) {
        val detailsFragmentToAdd = DetailsFragment()

        detailsFragmentToAdd.setSuperHeroName(itemSuperHero.name)
        detailsFragmentToAdd.setImage(itemSuperHero)
        detailsFragmentToAdd.setSuperHeroPowerStatsAndAppearance(itemSuperHero)
        detailsFragmentToAdd.setSuperHeroSomeBioDetails(itemSuperHero)

        supportFragmentManager.beginTransaction()
            .replace(R.id.listContainer, detailsFragmentToAdd)
            .addToBackStack("details_fragment")
            .commit()
    }
}