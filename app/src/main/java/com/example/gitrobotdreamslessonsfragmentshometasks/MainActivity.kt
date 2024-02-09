package com.example.gitrobotdreamslessonsfragmentshometasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(name: String) {
        val detailsFragmentToAdd = DetailsFragment()
        detailsFragmentToAdd.setSuperHeroName(name)
        supportFragmentManager.beginTransaction()
            .add(R.id.listContainer, detailsFragmentToAdd)
            .addToBackStack("details_fragment")
            .commit()
    }
}